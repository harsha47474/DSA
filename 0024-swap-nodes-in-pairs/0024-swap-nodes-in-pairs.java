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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode = dummy;
        ListNode currNode = dummy.next;
        ListNode nextNode = dummy.next.next;

        while(prevNode.next != null && prevNode.next.next != null){
            ListNode first = prevNode.next;
            ListNode second = first.next;

            prevNode.next = second;
            first.next = second.next;
            second.next = first;

            prevNode = first;
        }
        return dummy.next;
    }
}