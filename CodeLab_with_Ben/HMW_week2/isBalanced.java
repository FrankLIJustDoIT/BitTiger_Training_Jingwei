public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){ return true; }//corner case
        
        //use helper function to do recursion
        return helper(root)!=-1;
    }
    
    //return int value means the height of current node
    private int helper(TreeNode root){
        if(root==null){ return 0; }//base case
        
        int leftHight = helper(root.left);//do recursion
        int rightHight = helper(root.right);
        
        if(leftHight==-1 || rightHight==-1 || Math.abs(leftHight-rightHight)>1){
            return -1;
        }//-1 means the there exist 2 path whose depth difference has already exceed 1
        
        return Math.max(leftHight,rightHight)+1;
    }
}