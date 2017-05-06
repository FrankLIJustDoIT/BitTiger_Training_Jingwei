/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;//the node before slow
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }//to find the midium node
        
        //prev is now in the middle node of the list
        //set its next to null means cut the whole
        //list into 2 parts
        prev.next = null;
        
        ListNode left = sortList(head);
        //slow is the first node of the next half
        ListNode right = sortList(slow);
        
        return merge(left,right);
    }
    private ListNode merge(ListNode a, ListNode b){
        
        ListNode fakeHead = new ListNode(0);
        ListNode head = fakeHead;
        
        while(a != null && b != null){
            if(a.val <= b.val){
                head.next = a;
                a = a.next;
            }else{
                head.next = b;
                b = b.next;
            }
            head = head.next;
        }
        
        head.next = (a == null ? b : a);
        
        return fakeHead.next;
    }
}