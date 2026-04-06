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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode next = null;
        ListNode prev = null;

        while (temp != null) {
            next = temp.next;   // save next
            temp.next = prev;   // reverse link
            prev = temp;        // move prev forward
            temp = next;        // move temp forward
        }

        return prev;
    }
}