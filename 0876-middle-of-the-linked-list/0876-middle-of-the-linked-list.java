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

        if (head == null) {
            return null;
        }

        ListNode node = head;
        int count = 0;
        int temp = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        int mid = count / 2;
        node = head;
        
        while (node != null) {

            if (temp == mid) {
                return node;
            }

            temp++;
            node = node.next;
        }
        return null;
    }
}