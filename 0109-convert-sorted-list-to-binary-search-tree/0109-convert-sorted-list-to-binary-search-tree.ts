/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

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

function sortedListToBST(head: ListNode | null): TreeNode | null {
    let nums: number[] = [];
    let temp: ListNode = head;
    while(temp != null){
        nums.push(temp.val);
        temp = temp.next;
    }

    return build(0, nums.length-1, nums);
};

function build(left: number, right: number, nums: number[]): TreeNode | null {
    if(left > right) {
        return null;
    }

    let mid: number = Math.floor((left + right) / 2);
    let root: TreeNode = new TreeNode(nums[mid]);
    
    root.left = build(left, mid-1, nums);
    root.right = build(mid+1, right, nums);

    return root;
}