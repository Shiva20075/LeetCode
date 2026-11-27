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
    public int[] nextLargerNodes(ListNode head) {
        
        ListNode temp = head;
        List<ListNode> ls = new ArrayList<>();
         
        while (temp != null) {
            
            ls.add(temp);
            temp = temp.next;
        }

        Stack<ListNode> s = new Stack<>();
        int arr[] = new int[ls.size()];
        int l = ls.size()-1;

        for (int i = l; i >= 0; i--) {
            
            while (!s.isEmpty() && s.peek().val <= ls.get(i).val) {
                s.pop();
            }

            if (!s.isEmpty()) {
                arr[i] = s.peek().val;
            } else {
                arr[i] = 0;
            }

            s.push(ls.get(i));
        }
        return arr;
    }
}