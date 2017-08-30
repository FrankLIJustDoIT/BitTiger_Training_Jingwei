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
    private int count;
    
    public int pathSum(TreeNode root, int sum) {
        this.count = 0;
        
        //cache(x,y) means the the current sum x has appeared y times in the path
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0,1);
        
        helper(root, 0, sum, cache);
        
        return this.count;
    }
    private void helper(TreeNode root, int curSum, int target, Map<Integer, Integer> cache){
        if(root == null){
            return;
        }//base case
        
        curSum += root.val;//compute current sum
        
        if(cache.containsKey(curSum - target)){
            count += cache.get(curSum - target);
        }//curSum-target exists means there is a part of path sum to the target value in
        //the path
        
        //put the cursum in the cache map
        cache.put(curSum, cache.getOrDefault(curSum, 0) + 1);
        
        //traverse the two subtree
        helper(root.left, curSum, target, cache);
        helper(root.right, curSum, target, cache);
        
        //when we finish traversing the two subtree of the node, we delete
        //the record of this path so we maintain that the sum can only be 
        //computed follow a path
        cache.put(curSum, cache.get(curSum) - 1);
    }
}