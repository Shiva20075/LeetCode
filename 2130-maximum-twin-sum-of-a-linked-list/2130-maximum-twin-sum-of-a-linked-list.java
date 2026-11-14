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
    public int pairSum(ListNode head) {

        int l = 0;
        ListNode rev = null;
        ListNode temp = head;
        List<Integer> ans = new ArrayList<>();

        while (temp != null) {
            
            ListNode newNode = new ListNode(temp.val);

            newNode.next = rev;
            rev = newNode;
            temp = temp.next;
            l++;
        }

        temp = head;
        int sum = 0;

        for (int i = 0; i < l/2; i++) {

            sum += temp.val + rev.val;
            temp = temp.next;
            rev = rev.next;
            ans.add(sum);
            sum = 0;
        }

        Collections.sort(ans);
        return ans.get(ans.size() - 1);
    }
}