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

 /* 
 //Brutee fore approch
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set =new HashSet<>();
        while(head!=null){
            if(set.contains(head)) return head;
            set.add(head);
            head=head.next;
        }
        return null;
    }
}
*/
//optimal approch

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast !=null && fast.next!=null)// and becoz fast is moving two steps at a time 
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                while(head!=slow){
                    head=head.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// Note for your notebook
// Cycle detection: slow → 1 step, fast → 2 steps.
// Finding cycle start: head → 1 step, slow → 1 step.
// Reason: Moving both one step makes them meet at the first node of the cycle.