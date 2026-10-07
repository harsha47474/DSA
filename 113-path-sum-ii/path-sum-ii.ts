/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function pathSum(root: TreeNode | null, targetSum: number): number[][] {
    let ans: number[][] = []
    let curr: number[] = []
    checkPathSum(root, targetSum, ans, curr, 0);
    return ans;
};

function checkPathSum(root: TreeNode | null, targetSum: number,
    ans: number[][], curr: number[], sum: number): void {

    if (root == null) {
        return;
    }

    curr.push(root.val);
    sum += root.val;

    if (root.left == null && root.right == null) {
        if (sum == targetSum) {
            ans.push([...curr]);
        }
    }

    checkPathSum(root.left, targetSum, ans, curr, sum);
    checkPathSum(root.right, targetSum, ans, curr, sum);
    curr.pop();
}