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
    // BFS TRAVERSAL
    // public int deepestLeavesSum(TreeNode root) {
    //     int sum = 0;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);

    //     while (!q.isEmpty()) {
    //         int size = q.size();

    //         int currSum = 0;
    //         for (int i = 0; i < size; i++) {
    //             TreeNode temp = q.poll();
    //             currSum += temp.val;
    //             if (temp.left != null)
    //                 q.offer(temp.left);
    //             if (temp.right != null)
    //                 q.offer(temp.right);
    //         }

    //         sum = currSum;
    //     }

    //     return sum;
    // }

    // DFS TRAVERSAL
    int MAX_DEPTH = 0;
    int totalSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return totalSum;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (depth > MAX_DEPTH) {
                MAX_DEPTH = depth;
                totalSum = root.val;
            } else if (depth == MAX_DEPTH) {
                totalSum += root.val;
            }
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}