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
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null){
            return res;
        }//corner case
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode node = queue.removeLast();
                if(i==0){
                    res.add(node.val);
                }
                if(node.right!=null){
                    queue.addFirst(node.right);
                }
                if(node.left!=null){
                    queue.addFirst(node.left);
                }
            }
        }
        
        return res;
        
    }
}