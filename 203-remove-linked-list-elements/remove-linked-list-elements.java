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
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead= new ListNode();
        ListNode tail = newHead;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val!=val){
                tail.next=temp; 
                tail = tail.next;
            }
            temp=temp.next;
        }
        tail.next = null;
        return newHead.next;
    }
}