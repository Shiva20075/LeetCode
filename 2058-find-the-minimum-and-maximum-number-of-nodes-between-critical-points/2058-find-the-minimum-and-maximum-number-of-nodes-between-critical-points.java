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
        
        ListNode prev = null;
        ListNode curr = head;
        List<Integer> l = new ArrayList<>();
        int index = 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = 0;
        int[] arr = new int[2];

        while (curr != null) {
            ListNode next = curr.next;

            if(prev != null && next != null){
                if( prev.val < curr.val && curr.val > next.val || curr.val < prev.val && curr.val < next.val){
                    l.add(index);
                }
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        if(l.size() < 2){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }

        maxVal = l.get((l.size()-1)) - l.get(0);
        
        for (int i = 0; i < l.size()-1; i++){
            minVal = Math.min(minVal,l.get(i+1) - l.get(i));
        }

        arr[0] = minVal;
        arr[1] = maxVal;
        return arr;
    }
}