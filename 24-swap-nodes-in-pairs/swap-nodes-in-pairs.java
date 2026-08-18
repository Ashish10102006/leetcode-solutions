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
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;

        ListNode curr = head;
        ListNode prev = null;


        while (curr != null && curr.next != null){

             ListNode first = curr;
            ListNode second = curr.next;
            ListNode nextPair = second.next;

            // Swap the two nodes
            second.next = first;
            first.next = nextPair;

            // Connect previous pair to current pair
            if (prev == null) {
                head = second;
            } else {
                prev.next = second;
            }

            // Move to the next pair
            prev = first;
            curr = nextPair;
        }

        return head;
    }
}