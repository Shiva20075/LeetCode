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
    public ListNode deleteMiddle(ListNode head) {
        
        if (head == null || head.next == null) {
            return null;
        }

        ListNode temp = head;
        ListNode slow = temp;
        ListNode fast = temp;
        ListNode prev = null;

        while (temp.next != null && fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            temp = temp.next;
            
        }

        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }
}