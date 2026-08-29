/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// ======================== PRIORITY QUEUE METHOD ============================
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         fillPQ(root, pq);
//         for (int i = 1; i < k; i++) {
//             pq.poll();
//         }

//         return pq.peek();
//     }

//     public void fillPQ(TreeNode root, PriorityQueue<Integer> pq) {
//         if (root == null)
//             return;
//         pq.offer(root.val);
//         fillPQ(root.left, pq);
//         fillPQ(root.right, pq);
//     }
// }

// ========================== INRODER METHOD ===================================
class Solution {
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k){
        findInorder(root, k);
        return ans;
    }
    public void findInorder(TreeNode root, int k){
        if(root == null) return;

        findInorder(root.left, k);
        count++;
        if(count == k){
            ans = root.val;
            return;
        }
        findInorder(root.right, k);
    }
}
