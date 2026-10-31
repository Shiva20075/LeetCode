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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode temp = head;
        ListNode dummyOdd = new ListNode(0);
        ListNode odd = dummyOdd;  
        ListNode dummyEven = new ListNode(0);
        ListNode even = dummyEven; 
        int index = 1;

        while (temp != null) {


            if (index % 2 == 0 ){

                even.next = temp;
                even = even.next;

            } else {
                
                odd.next = temp;
                odd = odd.next;

            }

            temp = temp.next;
            index++;
        }

        even.next = null;
        odd.next = dummyEven.next;
        return dummyOdd.next;
    }
}