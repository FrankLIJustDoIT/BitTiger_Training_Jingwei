/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //to have a right-side view, we need to do a bfs and for each layer, only add the right most node to result
    //list. we often use queue to implement bfs, so for each layer the right-most node should always be added first
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }//corner case
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);
        while(!queue.isEmpty()){
            //the temp length is just the number of nodes in this layer, remember the length of the queue 
            //so that nodes from next layer won't be output in this for loop
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.removeLast();
                if(i == 0){
                    //only add the right most one
                    res.add(node.val);
                }
                //always try to add right subnode first and then try the left one to maintain the
                //order of queue
                if(node.right != null){
                    queue.addFirst(node.right);
                }
                if(node.left != null){
                    queue.addFirst(node.left);
                }
            }
        }
        
        return res;
        
    }
}