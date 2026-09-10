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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        int[] avg = countTheSubtree(root);
        return count;
    }
    private int[] countTheSubtree(TreeNode root){
        if(root == null) return new int[]{0,0};
        
        int[] leftSub = countTheSubtree(root.left);
        int[] rightSub = countTheSubtree(root.right);

        int avg = (leftSub[0] + rightSub[0] + root.val) / (leftSub[1] + rightSub[1] + 1);
        if(avg == root.val) count++;

        return new int[]{leftSub[0] + rightSub[0] + root.val, leftSub[1] + rightSub[1] + 1};
    }
}