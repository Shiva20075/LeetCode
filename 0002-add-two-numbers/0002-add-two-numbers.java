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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int carry = 0;

        while (t1 != null || t2 != null || carry != 0) {

            int sum = 0;

            if (t1 != null && t2 != null) {
                sum += t1.val + t2.val + carry;
                t1 = t1.next;
                t2 = t2.next;
            } else {

                if (t1 != null) {
                    sum += t1.val + carry;
                    t1 = t1.next;
                } else if (t2 != null){
                    sum += t2.val + carry;
                    t2 = t2.next;
                } else {
                    sum += carry;
                }
            }

            if (sum > 9) {
                carry = sum/10;
                sum = sum%10;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = temp.next;
            
        }

        return res.next;
    }
}