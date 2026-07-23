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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode temp = head;
        ListNode leftHead = null;
        ListNode startNode = null;
        ListNode endNode = null;
        ListNode tail = null;

        int count = 1;
        ListNode t = null;

        while (temp != null && count <= right) {
            if (count == left) {
                startNode = temp;
            }

            if (count == left - 1) {
                leftHead = temp;
            }

            if (count == right) {
                endNode = temp;
                tail = temp.next;
                endNode.next = null;
            }

            temp = temp.next;
            count++;
        }

        ListNode node = rev(startNode);
        if (leftHead == null){
            head = node;
        }else{
            leftHead.next = node;
        }
        while (node.next != null) {
            node = node.next;
        }

        node.next = tail;
        return head;
    }

    public ListNode rev(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
