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
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int middle;
        if(length %2!=0) middle=(length+1)/2;
        else middle=(length/2)+1;

        temp=head;
        for(int i=1;i<middle;i++){
            temp=temp.next;
        }
        
        return temp;
    }
}