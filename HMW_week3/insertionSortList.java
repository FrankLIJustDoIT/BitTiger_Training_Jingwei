/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);

        while(head != null){
            ListNode curr = dummy;

            while(curr.next != null && curr.next.val < head.val){
                curr = curr.next;
            }
            
            ListNode temp = head.next;
            head.next = curr.next;
            curr.next = head;
            head = temp;
        }
        
        return dummy.next;
    }
}