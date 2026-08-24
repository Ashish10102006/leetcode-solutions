public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = 0;
        int lengthB = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;

        // Find length of A
        while (tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }

        // Find length of B
        while (tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }

        // Reset pointers
        tempA = headA;
        tempB = headB;

        // Move longer list forward
        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;

            while (diff > 0) {
                tempA = tempA.next;
                diff--;
            }
        } 
        else {
            int diff = lengthB - lengthA;

            while (diff > 0) {
                tempB = tempB.next;
                diff--;
            }
        }

        // Move both pointers together
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}