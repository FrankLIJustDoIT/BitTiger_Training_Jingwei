public class Solution {
    class Pair{
        //the pair is used to record the min and max value by the time we traverese
        //a num in nums, we should make sure that for a pair, the max is always equal
        //to or later than min in appearing in nums
        int min;
        int max;
        public Pair(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }//corner case
        
        //we use stack here because we can always access the last added pair in O(1) time,
        //so we can compare it with the current access num and so do further operation
        Deque<Pair> stack = new ArrayDeque<>();
        
        for(int m : nums){
            if(stack.isEmpty() || stack.peekLast().min >= m){
                //in this condition, this two pairs cannot form the 132 pattern, so we just
                //add it into stack
                stack.addLast(new Pair(m, m));
            }else if(stack.peekLast().min < m){
                //in this comndition, we got a chance to form a 312 pattern
                //we first pop this pair
                Pair last = stack.removeLast();
                
                if(last.max > m){
                    //we form a 132
                    return true;
                }else{
                    //in this condition, we possibly cannot totally form but partly form a 132, so we
                    //renew the last pair by giving current m to last.max, so that the last.min must appear
                    //earlyer than last.max in nums, this is what we call half-formed
                    last.max = m;
                    
                    while(!stack.isEmpty() && stack.peekLast().max <= m){
                        //the last pair is not qualified, so we keep traversing other pairs
                        //try to find a pair which has a larger max than m
                        stack.removeLast();
                    }
                    
                    if(!stack.isEmpty() && stack.peekLast().min < m){
                        //if stack is not empty, which means this pair has a large max, if it also has a lower 
                        //min, then it's a good 132 pattern
                        return true;
                    }
                    
                    //if we don't find a good 132 by now, we just add the new last pair to stack, which the max 
                    //must appear earlyer than min in the nums
                    stack.addLast(last);
                }
            }
        }
        
        return false;
    }
}