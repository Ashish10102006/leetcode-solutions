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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> map =new HashMap<>();

        // Count frequency
        ListNode temp = head;
        while(temp!=null){
            map.put(temp.val,map.getOrDefault(temp.val,0)+1);
            temp=temp.next;
        }

        // Dummy node
        ListNode result = new ListNode(0);
        ListNode curr = result;

        // Create new list using only values occurring once
        temp = head;

        while (temp != null) {
            if (map.get(temp.val) == 1) {
                curr.next = new ListNode(temp.val);
                curr = curr.next;
            }
            temp = temp.next;
        }

        return result.next;    
    }
}