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
    int maxValue = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        dfs(root, root.val, root.val);
        return maxValue;
    }
    private void dfs(TreeNode root, int min, int max){
        if(root == null) return;
        maxValue = Math.max(maxValue, Math.max(Math.abs(root.val - min), Math.abs(max - root.val)));
        dfs(root.left, Math.min(root.val, min), Math.max(root.val, max));
        dfs(root.right, Math.min(root.val, min), Math.max(root.val, max));
    }
}