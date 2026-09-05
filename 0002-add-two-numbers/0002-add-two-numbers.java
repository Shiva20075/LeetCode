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
        
        if ( l1 == null && l2 == null ){
            return null;
        }

        int sum = 0;
        int count = 0;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        while (l1 != null || l2 != null ){
            
            count+= carry;
            carry = 0;

            if ( l1 != null && l2 != null){
                count += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;

            } else if ( l1 != null && l2 == null ) {

                count += l1.val;
                l1 = l1.next;

            } else if ( l2 != null && l1 == null) {
                count += l2.val;
                l2 = l2.next;
            }

            if (count > 9) {
                carry = count/10;
            }

            sum =  count % 10;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            count = 0;
        }

        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }
        return ans.next;
    }
}