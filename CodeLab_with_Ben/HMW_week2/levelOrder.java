public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root==null){ return resList; }//corner case
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);
        
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<len; i++){
                if(queue.peekLast().left!=null){
                    queue.addFirst(queue.peekLast().left);
                }
                if(queue.peekLast().right!=null){
                    queue.addFirst(queue.peekLast().right);
                }
                list.add(queue.removeLast().val);
            }
            resList.add(list);
        }
        
        return resList;
    }
}