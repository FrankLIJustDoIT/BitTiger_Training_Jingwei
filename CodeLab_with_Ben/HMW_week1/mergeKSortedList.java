public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length<1){ return null; }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
            lists.length,
            new Comparator<ListNode>(){
                public int compare(ListNode node1, ListNode node2){
                    return node1.val-node2.val;
                }
            }
        );
        
        for(ListNode node:lists){
            if(node!=null){ queue.offer(node);}
        }
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next!=null){
                queue.offer(tail.next);
            }
        }
        return head.next;
    }
}