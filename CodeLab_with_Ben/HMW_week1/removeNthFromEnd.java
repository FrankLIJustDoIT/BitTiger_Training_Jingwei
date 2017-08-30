public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode front = dummy;
        ListNode back = dummy;
        dummy.next = head;
        for(int i=1; i<=n+1; i++){
            front = front.next;
        }
        while(front!=null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}