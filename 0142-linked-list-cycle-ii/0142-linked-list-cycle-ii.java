public class Solution {

    public ListNode detectCycle(ListNode head) {

        Set<ListNode> s = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {

            if (s.contains(temp)) {
                return temp;
            }

            s.add(temp);
            temp = temp.next;
        }

        return null;
    }
}
