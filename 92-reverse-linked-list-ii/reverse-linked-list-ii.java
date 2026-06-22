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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null ) return head;
        ListNode dummynode= new ListNode(0);
        dummynode.next=head;
        ListNode prev=dummynode;
        for(int i=1;i<left;i++){
            prev=prev.next;
        }
        ListNode curr=prev.next;
        for(int i=1;i<=(right-left);i++){
            ListNode temp=prev.next;
            prev.next=curr.next;
            curr.next=curr.next.next;
            prev.next.next=temp;
        }
        return dummynode.next;
    }
}
// A good rule of thumb:
// Use a dummy node whenever an operation might modify the head of a linked list.

// prev = node before the reversing section
// curr = first node of the reversing section