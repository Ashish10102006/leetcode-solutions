/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //Bruteforce 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head ==null || head.next==null) return false;
        HashSet<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                return true; // cycle found
            }
            seen.add(head); // store node reference
            head = head.next;
         }
         return false;
    }
}