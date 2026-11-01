class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}