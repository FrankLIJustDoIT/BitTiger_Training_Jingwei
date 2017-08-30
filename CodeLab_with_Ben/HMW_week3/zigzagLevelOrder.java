public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }//corner case
        
        helper(root, res, 1);
        return res;
    }
    //helper function, level is used to mark the level of current node
    private void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root==null){
            return;
        }//base case
        
        //if a new level of node is gonna to be processed, add a list to res
        if(res.size()<level){
            res.add(new ArrayList<Integer>());
        }
        
        //get the corresponding list in res to add current node according to the level the node belong to
        List<Integer> list = res.get(level-1);
        
        if(level%2==0){
            list.add(0,root.val);//add in the head
        }else{
            list.add(root.val);//add in the tail
        }
        
        helper(root.left,res,level+1);//do recursion
        helper(root.right,res,level+1);
    }
}