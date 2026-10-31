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
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }

        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int[] nodes = new int[length];
        temp = head;

        for (int i = 0; i < length; i++) {
            nodes[i] = temp.val;
            temp = temp.next;
        }

        divide(nodes,0,length-1); 

        ListNode dummy = new ListNode(0);
        temp = dummy;

        for (int i = 0; i < nodes.length; i++) {
            temp.next = new ListNode(nodes[i],null);
            temp = temp.next;
        }

        return dummy.next;
    }

    public void divide(int[] nodes,int start,int end) {

        if (start >= end) return;
        
        int mid = (start+end)/2;

        divide(nodes,start,mid);
        divide(nodes,mid+1,end);
        merge(nodes,start,mid,end);
    }

    public void merge(int[] nodes,int start,int mid,int end){

        int res[] = new int[nodes.length];
        int index = start;
        int left = start;
        int right = mid+1;

        while (left <= mid && right <= end) {
            
            if (nodes[left] <= nodes[right]){
                res[index++] = nodes[left];
                left++;
            } else {
                res[index++] = nodes[right];
                right++;
            }
        }

        while (left <= mid) {
            res[index++] = nodes[left++];
        }

        while (right <= end) {
            res[index++] = nodes[right++];
        }

        for (int i = start; i <= end; i++) {
            nodes[i] = res[i];
        }
    }
}