public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }//corner case
        
        //this two max pointer are used for recording the local max bar，because only
        //when you know the local max, you can compute how much water you can save
        int leftMax = 0;
        int rightMax = 0;
        
        int left = 0;//two primary pointers
        int right = height.length - 1;
        
        int res = 0;
        
        while(left <= right){
            if(height[left] <= height[right]){
                //which means the left bar got an opportunity to save water
                //because it's sure there is at least one bar higher or equal
                //to this bar
                if(height[left] >= leftMax){
                    //this bar is higher than local max, so no water can be
                    //above and after this bar, so we then need to set a 
                    //new local max
                    leftMax = height[left];
                }else{
                    //this bar is lower than the local max, so above this bar, some
                    //water can be saved
                    res += leftMax - height[left];
                }
                
                left++;
            }else{
                //which means now we cannot use leftMax-height[left] to compute the water
                //so we have to left shift right pointer to see whether it can be used,
                //before we doing this, we need to determine how much water can be saved
                //after this bar
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    res += rightMax - height[right];
                }
                
                right--;
            }
        }
        
        return res;
    }
}