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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        int n = 0;
        
        while(curr != null){
            n++;
            curr = curr.next;
        }

        curr = head;
        k = k % n;  // The TLE killer

        while (k > 0) {
            while (curr.next != null) {
                if (curr.next.next == null) {
                    ListNode lNode = curr.next;
                    lNode.next = head;
                    curr.next = null;
                    head = lNode;
                    break;
                }
                curr = curr.next;
            }
            curr = head;
            k--;
        }
        return head;
    }
}