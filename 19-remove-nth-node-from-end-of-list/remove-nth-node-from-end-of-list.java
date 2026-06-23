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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

ListNode temp = head;
int length = 0;
while(temp != null){
    length++;
    temp = temp.next;
}
// or int length = 1;
// while(temp.next != null){
//     length++;
//     temp = temp.next;
// }

if(n == length) return head.next;//This line handles the case where the node to remove is the head.

temp = head;

for(int i = 1; i < length - n; i++){
    temp = temp.next;
}

temp.next = temp.next.next;

return head;
    }
}