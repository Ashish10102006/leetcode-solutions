// he pattern to recognize
// Whenever you see:
// Reverse only a portion of a linked list (left to right)
// Think:
// Find prev
// Fix curr
// Move curr.next to after prev repeatedly
// That's the pattern. If you remember "take curr.next and move it to the front", you can rebuild the code even if you forget every line.

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
// curr = first node of the reversing section .  curr = fixed card
// Pick node after curr
// Delete it from chain
// Insert after prev



// Here’s a very short example 👇
// List:
// 1 → 2 → 3 → 4 → 5

// We reverse from 2 to 4

// So:

// prev = 1
// curr = 2 👉 curr is FIXED here
// Step 1: move 3 in front
// 1 → 3 → 2 → 4 → 5
//         ↑
//       curr (still 2)
// Step 2: move 4 in front
// 1 → 4 → 3 → 2 → 5
//              ↑
//            curr still 2
// Key idea (1 line):

// 👉 curr stays at 2, and we keep moving next nodes (3, 4, …) to the front of it.