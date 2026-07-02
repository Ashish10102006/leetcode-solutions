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
    public boolean isPalindrome(ListNode head) {
        ListNode copy = copyList(head);
       // reverses the original list, so there is no original list left to compare against.
        ListNode newHead = reverseList(copy);

        ListNode temp1 = head;
        ListNode temp2 = newHead;

        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val)
                return false;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode copyList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            tail.next = new ListNode(head.val);
            tail = tail.next;
            head = head.next;
        }

        return dummy.next;
    }
}