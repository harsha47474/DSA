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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if (lh == rh)
            return (1 << lh) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int findLeftHeight(TreeNode root) {
        int hght = 0;
        while (root != null) {
            hght++;
            root = root.left;
        }
        return hght;
    }

    private int findRightHeight(TreeNode root) {
        int hght = 0;
        while (root != null) {
            hght++;
            root = root.right;
        }
        return hght;
    }
}