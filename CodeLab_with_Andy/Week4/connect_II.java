/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    //the main idea is simply using bfs to traverse the tree
    public void connect_II(TreeLinkNode root) {
        if(root == null){
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int len = queue.size();
            TreeLinkNode dummy = new TreeLinkNode(0);
            while(len > 0){
                dummy.next = queue.remove();
                if(dummy.next.left != null){
                    queue.add(dummy.next.left);
                }
                if(dummy.next.right != null){
                    queue.add(dummy.next.right);
                }
                dummy = dummy.next;
                len--;
            }  
        }
    }
}