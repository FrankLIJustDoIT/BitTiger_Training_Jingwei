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
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
    
    //to solve this question in O(1) space, we just in-order traverse this tree
    //because for a BST, the in-order traverse is actually traverse all the 
    //nodes in ascending order, so we can detect where the wrong swap is
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
    
    private void traverse(TreeNode node){
        if(node == null){
            return;
        }
        
        traverse(node.left);
        
        //if prev.val >= cur.val, the ascending order broke, it means
        //we find out a wrong element
        if(firstNode == null && prevNode.val >= node.val){
            firstNode = prevNode;
        }
        
        //it's probably the two wrong swapped elements are just a parent-child pair
        //so when we find the firstNode, we then at first record the next node(curNode)
        //as the secondNode, if no more secondNode could be found, then it is just the case
        if(firstNode != null && prevNode.val >= node.val){
            secondNode = node;
        }
        
        prevNode = node;
        
        traverse(node.right);
    }
}