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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1 = head;
        ListNode temp2 = head;

        for(int i=1; i<k; i++){
            temp1 = temp1.next;
        }
        ListNode temp = temp1;
        
        while(temp.next != null){
            temp = temp.next;
            temp2 = temp2.next;
        }

        int val = temp1.val;
        temp1.val = temp2.val;
        temp2.val = val;

        return head;
    }
}