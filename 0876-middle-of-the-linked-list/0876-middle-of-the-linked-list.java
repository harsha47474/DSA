/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // ListNode temp = head;
        // int count = 0;
        // while(temp!= null){
        //     temp = temp.next;
        //     count++;
        // }
        // int mid = count/2;
        // temp = head;
        // int currentIdx = 0;
        // while(temp!=null){
        //     if(currentIdx == mid){
        //         return temp;
        //     }
        //     currentIdx++;
        //     temp = temp.next;
        // }
        // return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}