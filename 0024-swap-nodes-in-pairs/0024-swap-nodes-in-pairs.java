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

        if (head == null || head.next == null){
            return head;
        }        
        ListNode newHead = head.next;
        ListNode temp = null;
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null){

            ListNode next = curr.next;

            curr.next = prev;
            prev.next = next;

            if (temp != null){
                temp.next = curr;
            }

            if (next == null || next.next == null){
                break;
            }

            temp = prev;
            prev = next;
            curr = next.next;
        }
        return newHead;
    }
}