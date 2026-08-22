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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(int i=0; i<lists.length; i++){
            ListNode root = lists[i];
            ListNode temp = root;
            while(temp != null){
                ListNode prev = temp;
                temp = temp.next;
                prev.next = null;
                queue.offer(prev);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!queue.isEmpty()){
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        return temp.next;
    }
}