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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Map<Integer, Integer> map = new TreeMap<>();
        ListNode temp = head.next;
        ListNode prev = head;
        int count = 1;
        int minValue = -1;
        int maxValue = -1;
        int prevValue = -1;
        int minDistance = Integer.MAX_VALUE;

        while(temp.next != null){
            if ((prev.val > temp.val && temp.val < temp.next.val) ||
                (prev.val < temp.val && temp.val > temp.next.val)){
                // map.put(inc, count);
                // inc++;
                if(minValue == -1){
                    minValue = count;
                    maxValue = count;
                } else {
                    prevValue = maxValue;
                    maxValue = count;
                    minDistance = Math.min(minDistance, maxValue - prevValue);
                }
            }
            // } else if(){
            //     // map.put(inc, count);
            //     // inc++;
            // }
            count++;
            temp = temp.next;
            prev = prev.next;
        }

        int maxDistance = maxValue - minValue;
        if(minValue == -1 || maxValue == -1 || minValue == maxValue) return new int[]{-1,-1};
        else return new int[]{minDistance, maxDistance};

        // int n = map.size();
        // if(map.size() == 0 || map.size() == 1) return new int[]{-1,-1};
        // if(map.size() == 2) return new int[]{map.get(1) - map.get(0), map.get(1) - map.get(0)};

        // int maxDistance = map.get(n-1) - map.get(0);
        // int minDistance = Integer.MAX_VALUE;

        // for(int i=0; i<n-1; i++){
        //     int minD = map.get(i+1) - map.get(i);
        //     if(minD < minDistance){
        //         minDistance = minD;
        //     }
        // }
        
        // return new int[]{minDistance, maxDistance};
    }
}