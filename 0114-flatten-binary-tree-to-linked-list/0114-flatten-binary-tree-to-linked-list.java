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
    // ========== NUBRA METHOD ==========
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root){
        if(root == null) return;
        preOrderTraversal(root);
        TreeNode temp = root;
        if(list.size() == 1) return;

        for(TreeNode t: list){
            temp.right = t;
            temp.left = null;
            temp = temp.right;
        }
    }
    
    public void preOrderTraversal(TreeNode root){
        if(root == null) return;

        list.add(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}