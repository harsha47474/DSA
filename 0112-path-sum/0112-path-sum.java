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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkIfExists(root, targetSum, 0);
    }

    public boolean checkIfExists(TreeNode root, int targetSum, int sum) {
        if(root == null) return false;

        sum += root.val;

        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        return checkIfExists(root.left, targetSum, sum) || checkIfExists(root.right, targetSum, sum);
    }
}