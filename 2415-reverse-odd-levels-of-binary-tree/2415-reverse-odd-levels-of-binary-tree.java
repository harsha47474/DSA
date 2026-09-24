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
class Solution {

    // METHOD 1 - BFS TRAVERSAL
    // public TreeNode reverseOddLevels(TreeNode root) {
    //     int level = 0;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);

    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         List<TreeNode> list = new ArrayList<>();

    //         for(int i=0; i<size; i++){
    //             TreeNode temp = q.poll();
    //             list.add(temp);

    //             if(temp.left != null && temp.right != null){
    //                 q.offer(temp.left);
    //                 q.offer(temp.right);
    //             }
    //         }

    //         if(level % 2 == 1){
    //             int left = 0;
    //             int right = list.size() - 1;
    //             while(left <= right){
    //                 int leftVal = list.get(left).val;
    //                 list.get(left).val = list.get(right).val;
    //                 list.get(right).val = leftVal;

    //                 left++;
    //                 right--;
    //             }
    //         }
    //         level++;
    //     }
    //     return root;
    // }

    // METHOD - 2 : DFS TRAVERSAL 
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }
    public void dfs(TreeNode root1, TreeNode root2, int level){
        if(root1 == null) return;

        if(level % 2 != 0){
            int tempVal = root1.val;
            root1.val = root2.val;
            root2.val = tempVal;
        } 

        dfs(root1.left, root2.right, level+1);
        dfs(root1.right, root2.left, level+1);
    }
}