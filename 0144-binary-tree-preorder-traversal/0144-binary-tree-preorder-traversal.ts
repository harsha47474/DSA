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

function preorderTraversal(root: TreeNode | null): number[] {
    let curr: TreeNode = root;
    let preorder: number[] = [];

    while(curr != null){
        if(curr.left === null){
            preorder.push(curr.val);
            curr = curr.right;
        } else {
            let prev: TreeNode = curr.left;
            while(prev.right !== null && prev.right !== curr){
                prev = prev.right;
            }
            if(prev.right === null){
                prev.right = curr;
                preorder.push(curr.val);
                curr = curr.left;
            }
            else {
                prev.right = null;
                curr = curr.right;
            }
        }
    }

    return preorder;
};