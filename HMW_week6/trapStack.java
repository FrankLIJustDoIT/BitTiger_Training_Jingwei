public class Solution {
    public int trapStack(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }//corner case
        
        int res = 0;
        
        //we use stack here because every time when we find a bar that some water
        //can be saved, we compute from the bar closest from this bar
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < height.length;){
            if(stack.isEmpty() || height[stack.peekFirst()] >= height[i]){
                //this bar is lower than the previous one so no water can be saved
                stack.addFirst(i);
                //only in this way we i++;
                i++;
            }else{
                //this bar is higher than the previous one, so maybe some water can be
                //saved, we pop() the index of previous one first
                int curIndex = stack.removeFirst();
                
                if(stack.isEmpty()){
                    //if empty, it means this is not a pool, so no water can be saved
                    continue;
                }
                
                //if not empty, it means a pool exist
                int preIndex = stack.peekFirst();
                
                //this is a general function, given two bars witch are not next to each other, the amount of
                //water can be saved between is the height of lower one * the distance.
                //Sometimes the result can be negative, when the left side bar is even lower than its previous one
                //but when we compute all the bars which is apporoaprite, the result is always right
                res += (Math.min(height[preIndex], height[i]) - height[curIndex]) * (i - preIndex - 1);
            }
        }
        
        return res;
    }
}