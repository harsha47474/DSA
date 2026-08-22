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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // edge cases
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        // step 1 : move the fast pointer n step ahead 
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // handle head edge case
        if (fast == null) {
            return head.next;
        }

        // step 2 : move slow and fast pointer at same pace till the fast.next is null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        } // now slow lands on the node before the node to be deleted

        slow.next = slow.next.next;
        return head;
    }
}