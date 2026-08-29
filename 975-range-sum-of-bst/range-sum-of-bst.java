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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return -1;
        return calculateSum(root, low, high);
    }
    public int calculateSum(TreeNode root, int low, int high){
        if(root == null) return 0;
        int sum = 0;
        if(root.val >=low && root.val<=high) sum = root.val + calculateSum(root.left, low, high) + calculateSum(root.right, low, high);
        else if(root.val > high) sum = calculateSum(root.left, low, high);
        else if(root.val < low) sum = calculateSum(root.right, low, high);

        return sum;
    }
}