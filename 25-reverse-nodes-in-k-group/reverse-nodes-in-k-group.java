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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode temp =head;
        ListNode prevLast=null;

        while( temp!=null ){
            ListNode kThNode=getKthNode(temp, k);
            if(kThNode==null){
                if(prevLast != null)
                {
                    prevLast.next=temp;
                }
                break;
            }

            ListNode nextNode=kThNode.next;

            kThNode.next = null;

            reverseLinkedList(temp);

            if(temp==head) head=kThNode;
            else prevLast.next=kThNode;

            prevLast=temp;
            temp=nextNode;
        }

        return head;
    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public ListNode getKthNode(ListNode temp ,int k){
        k-=1;

        while(temp!=null && k>0){

            k--;
            temp=temp.next;
        }
        return temp;
    }
}