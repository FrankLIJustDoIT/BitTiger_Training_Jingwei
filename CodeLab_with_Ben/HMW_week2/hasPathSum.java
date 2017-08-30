public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){ return false; }//corner case
        
        if(root.val==sum && root.left==null && root.right==null){
            return true;
        }//base case
        
        //do recursion
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}