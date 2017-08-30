public class Solution {
    private List<List<Integer>> resList;
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        this.resList = new ArrayList<>();
        if(root==null){ return resList; }//corner case
        List<Integer> list = new ArrayList<>();
        helper(list,root,sum);
        
        return resList;
    }
    
    private void helper(List<Integer> list, TreeNode root, int sum){
        list.add(root.val);
        
        if(root.left==null && root.right==null){
            if(root.val==sum){
                this.resList.add(new ArrayList<Integer>(list));
            }
        }
        if(root.left!=null){ helper(list,root.left,sum-root.val); }
        if(root.right!=null){ helper(list,root.right,sum-root.val); }
        
        list.remove(list.size()-1);
    }
}