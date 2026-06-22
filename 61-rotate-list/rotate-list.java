// Short pattern trick for Rotate List

// When you see:

// Rotate list right by k

// Ask only:

// Who becomes the new head?
// Who becomes the new tail?

// Example:

// 1 → 2 → 3 → 4 → 5
// k = 2
// Result:
// 4 → 5 → 1 → 2 → 3
// Notice:
// New head = 4
// New tail = 3
// Then think:
// Last k nodes move to the front.
// So:
// 1 → 2 → 3 | 4 → 5
//           ^
//       new tail
// Memory rule
// Rotate = Find the cut point.
// That's the pattern. Don't memorize code; find where the list should be cut.

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        // Find length and tail
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        // Handle large k
        k=k%length;
        if(k==0) return head;

        // Make circular list
        tail.next = head;
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
}
// 1. Find length
// 2. k %= length
// 3. Make list circular
// 4. Go to (length - k)th node
// 5. Break the circle