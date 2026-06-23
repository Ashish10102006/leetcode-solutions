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
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         if(head ==null || head.next==null) return false;
//         HashSet<ListNode> seen = new HashSet<>();
//         while (head != null) {
//             if (seen.contains(head)) {
//                 return true; // cycle found
//             }
//             seen.add(head); // store node reference
//             head = head.next;
//          }
//          return false;
//     }
// }


// Eficient approch
// Think:
// Slow and Fast store node addresses,if the addresses become equal, they met.
// If the linked list is straight:
//     Fast reaches null first.
//     => No cycle.
// If the linked list has a cycle:
//     Fast keeps moving inside the cycle.
//     Since Fast moves faster than Slow,
//     it eventually catches Slow.
//     => Cycle exists.
// Fast speed > Slow speed
// ⇒ In a cycle, they must meet.
// Ultra-short version:
// No cycle → Fast reaches null.
// Cycle → Fast meets Slow.
public class Solution {
   public boolean hasCycle(ListNode head) {
    if(head==null || head.next==null) return false;
    ListNode slow=head;//address
    ListNode fast=head;//address
    while(fast !=null && fast.next!=null ){
        slow=slow.next;//1 step
        fast=fast.next.next;// 2 step
        if(slow==fast) return true;

    }
    return false;
   }
}   
