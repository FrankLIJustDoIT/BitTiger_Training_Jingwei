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
    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        
        convertBST(root.right);
        
        int temp = root.val;
        root.val += preSum;
        preSum += temp;
        
        convertBST(root.left);
        
        return root;
    }
}