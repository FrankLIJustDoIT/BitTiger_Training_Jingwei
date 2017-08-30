public class Solution {
    //we can solve this problem by doing recursion
    public boolean canCross_recursion(int[] stones) {
        int k = 0;//k is the steps we jumped last time
        return helper(stones, 0, k);
    }
    
    //everytime we run helper, we computing on this stone, with the number of units we 
    //jumped last time, whether we can make it to jump to the last stone
    private boolean helper(int[] stones, int index, int k){
        if(index == stones.length - 1){
            return true;
        }//base case, already the last stone
        
        for(int i = k - 1; i <= k + 1; i++){
            if(i <= 0){
                continue;
            }//corner case, for the case of start point or just jumped one unit last time
            
            int nextJump = stones[index] + i;
            
            for(int j = index + 1; j < stones.length; j++){
                if(stones[j] > nextJump){
                    break;
                }//if this stones is already cannot be reached by the units we are gonna jump, we just
                //break out of it
                
                if(stones[j] == nextJump){
                    //we choose to jump that much to a certain stone, if we can then jump to the other side
                    //then it is a successful jump and we can return true
                    if(helper(stones, j, i)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}