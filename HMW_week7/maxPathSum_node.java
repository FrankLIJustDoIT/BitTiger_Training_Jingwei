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
    class nodeSave{
        int singlePath;//the max single path value
        int maxPath;//the max value in total, include cross path
        public nodeSave(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    public int maxPathSum_node(TreeNode root) {
        nodeSave res = helper(root);
        
        return res.maxPath;
    }
    
    private nodeSave helper(TreeNode node){
        if(node == null){
            return new nodeSave(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }//corner/base case
        
        nodeSave left = helper(node.left);
        nodeSave right = helper(node.right);
        
        //there's no mean if single path in left or right child is a negative value
        int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath)) + node.val;
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, Math.max(0, left.singlePath) + Math.max(0, right.singlePath) + node.val);
        
        return new nodeSave(singlePath, maxPath);
    }
}