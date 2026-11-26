import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        int carry = 0;

        while (t1 != null || t2 != null) {

            if (t1 != null) {
                s1.add(t1);
                t1 = t1.next;
            }

            if (t2 != null) {
                s2.add(t2);
                t2 = t2.next;
            }
        }

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {

            int sum = carry;

            if (!s1.isEmpty() && !s2.isEmpty()) {
                sum += s1.pop().val + s2.pop().val;
            } else if (!s1.isEmpty()) {
                sum += s1.pop().val;
            } else if (!s2.isEmpty()) {
                sum += s2.pop().val;
            }

            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            res.next = node;
            res = res.next;
        }

        ListNode temp = dummy.next;
        ListNode prev = null;

        while (temp != null) {

            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
}