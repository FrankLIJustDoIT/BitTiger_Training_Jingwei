public class Solution {
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null){
            return res;
        }//corner case
        
        helper(root, res, 1);
        
        return res;
    }
    
    //level is used to mark the num of level the node belong to
    private void helper(TreeNode node, List<Integer> res, int level){
        if(node==null){
            return;
        }//base case
        
        //because traverse right subtree first, so the first element 
        //be traversed in a new level is the right most one in this level
        if(res.size() < level){
            res.add(node.val);
        }
        
        //res.set(level-1,node.val);
        helper(node.right,res,level+1);
        helper(node.left,res,level+1);
    }
}
