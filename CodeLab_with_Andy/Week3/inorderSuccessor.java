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
    //for a bst, inorder successor of a node is just the smallest node of all the nodes bigger than this one 
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return root;
        }
        
        if(p.val < root.val){
            //in this condition p must have a inorder successor, at least the root can be its inorder successor, so try
            //to find it in the root.left, if nothing found out, the root is just the inorder successor
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }else{
            //it is possible p doesn't have a inorder successor actually, so we can just return it no matter whether the 
            //result is null
            return inorderSuccessor(root.right, p);
        }
        
    }
}