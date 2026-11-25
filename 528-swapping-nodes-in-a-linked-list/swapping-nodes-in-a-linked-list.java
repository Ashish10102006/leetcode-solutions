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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node1=null;
        ListNode node2=null;

        ListNode temp = head;
        int length=0;
        
        // Step 1: Find length
        while(temp != null)
        {
            length++;
            temp=temp.next;
        }

        // Step 2: Find both positions
        int pst1=k;
        int pst2=length-k+1;

        temp=head;
        int i=1;

        // Step 3: Find kth node from beginning
        while(temp!=null && i<pst1)
        {
            temp=temp.next;
            i++;
        }
        node1=temp;

        temp=head;
        int j=1;

        // Step 4: Find kth node from end
        while(temp!=null && j<pst2)
        {
            temp=temp.next;
            j++;
        }
        node2=temp;

        // Step 5: Swap values
        int swap=node1.val;
        node1.val=node2.val;
        node2.val=swap;

        return head;
    }
}
/*
To find back postition:-
Remember:
- 0-based indexing: n - k
- 1-based indexing: n - k + 1
*/