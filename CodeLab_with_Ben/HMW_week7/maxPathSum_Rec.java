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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum_Rec(TreeNode root) {
        helper(root);
        
        return maxPath;
    }
    //here we use a helper function to do the recursion, everytime when we 
    //do the recursion, we at first compute left and right, which must be
    //two lines from left side and right side, then we compute what the cross
    //sum could be and update maxPath if necessary, we then return the maximum
    //line between left and right to the parent node.
    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }//corner/base case
        
        
        //if the subline is negative, there's no mean we take it
        //into consideration.
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        
        maxPath = Math.max(maxPath, left + right + node.val);
        
        return Math.max(left, right) + node.val;
    }
}