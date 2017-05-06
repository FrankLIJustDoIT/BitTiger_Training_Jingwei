/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode quickSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }//corner case
        
        ListNode fakeSmall = new ListNode(0);
        ListNode fakeEqual = new ListNode(0);
        ListNode fakeBig = new ListNode(0);//used for return result
        
        ListNode small = fakeSmall;
        ListNode equal = fakeEqual;
        ListNode big = fakeBig;//used for iteration
        ListNode curr = head;//head is the pivot;
        
        //do quick sort, save node in different list group accordingly
        while(curr != null){
            if(curr.val < head.val){
                small.next = curr;
                small = small.next;
            }else if(curr.val == head.val){
                equal.next = curr;
                equal = equal.next;
            }else{
                big.next = curr;
                big = big.next;
            }
            curr = curr.next;
        }
        
        small.next = null;//add an end 
        equal.next = null;
        big.next = null;
        
        return mergeQuickSort(mergeQuickSort(quickSortList(fakeSmall.next),fakeEqual.next),quickSortList(fakeBig.next));
    }
    private ListNode mergeQuickSort(ListNode a, ListNode b){
        if(a == null || b == null){
            return a == null ? b : a;
        }//corner case
        
        //traverse a to the end, and add b in the tail of a
        //because list nodes in a and b are sorted and 
        //nodes in b is always bigger than those in a
        ListNode trav = a;
        while(trav.next != null){
            trav = trav.next;
        }
        
        trav.next = b;
        
        return a;
    }
}