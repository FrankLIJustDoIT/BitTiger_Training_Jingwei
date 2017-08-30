
public class solution {
    private ListNode findMiddle(ListNode head){
    	if(head==null){ return null; }
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast.next!=null || fast.next.next!=null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }
}
