/*
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // Base case
        if (head == null)
            return null;

        Node curr = head;

        // Step 1: Insert copied nodes after every original node
        while (curr != null) {
            Node newNode = new Node(curr.val);

            newNode.next = curr.next;
            curr.next = newNode;

            curr = newNode.next;
        }

        // Step 2: Copy random pointers
        curr = head;

        while (curr != null) {

            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // Step 3: Separate the two linked lists
        curr = head;

        Node newHead = head.next;
        Node newCurr = newHead;

        while (curr != null) {

            // Restore original list
            curr.next = newCurr.next;
            curr = curr.next;

            // Connect copied list
            if (curr != null) {
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }

        return newHead;
    }
}