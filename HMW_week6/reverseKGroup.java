/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }//corner case
        
        ListNode dummy = new ListNode(-1);//set a dummy head so we can make operation with head
        //but can always have the new head to return
        dummy.next = head;
        
        ListNode beg = dummy;
        
        int count = 0;
        while(head != null){
            count++;
            if(count % k == 0){
                //which means there is a set of k nodes can be operated
                beg = helper(beg, head.next);
                //now beg is the last node of the last reversed set, so it functioned just the same
                //way as dummy
                head = beg.next;
            }else{
                head = head.next;
            }
        }
        
        return dummy.next;
    }
    
    //the beg is actually the node just before the first node of the set to be operated and the end
    //is the node just after
    private ListNode helper(ListNode beg, ListNode end){
        ListNode prev = beg;
        ListNode curr = beg.next;
        ListNode first = curr;
        ListNode next;
        
        //all the node in the set point back
        while(curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //the first node is now the last node after reversing, so it should point to end node
        first.next = end;
        
        //the prev node is used to be the last node in the set, so now it should be the first node
        //and so we need to let beg point to it
        beg.next = prev;
        
        return first;
    }
}