
public class solution {
    private ListNode insertSortedList(ListNode head, ListNode target){
    	if(head==null){ return target; }
    	
    	ListNode node = head;
    	
    	if(head.val<=target.val){
    		target.next = head;
    		return target;
    	}
    	while(node.next!=null){
    		if(node.val<=target.val && target.val<=node.next.val){
    			target.next = node.next;
    			node.next = target;
    			return head;
    		}
    		node = node.next;
    	}
    	node.next = target;
    	return head;
    }
}
