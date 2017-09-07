/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //for each recursion level, it returns the maximum money the thief can get if he start from this house
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int rob = root.val;
        int notRob = 0;
        
        if(root.left != null){
            rob += (rob(root.left.left) + rob(root.left.right));
            notRob += rob(root.left);
        }
        
        if(root.right != null){
            rob += (rob(root.right.left) + rob(root.right.right));
            notRob += rob(root.right);
        }
        
        return Math.max(rob, notRob);
    }
}