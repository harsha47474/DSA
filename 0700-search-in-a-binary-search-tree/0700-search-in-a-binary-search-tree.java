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
// =========================== DFS TRAVERSAL ==============================
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         if(root == null) return null;
//         TreeNode temp = root;
//         if (root.val == val) return root;
//         else if (root.val > val) temp = searchBST(root.left, val);
//         else if (root.val < val) temp = searchBST(root.right, val);
//         return temp;
//     }
// }

// ============================ BFS TRAVERSAL =============================
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.val == val) return temp;
            else if(temp.val > val && temp.left != null) queue.offer(temp.left);
            else if(temp.val < val && temp.right != null) queue.offer(temp.right);
        }
        return null;
    }
}