public class Solution {
    public int maxSubArray_DP(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }//corner case
        
        int len = nums.length;
        //maxDP[i] means the max sum which end with nums[i];
        //the global max sum must end with certain point
        //in nums, so we compute each of them and find the 
        //max within them
        int[] maxDP = new int[len];
        maxDP[0] = nums[0];
        int max = maxDP[0];
        
        for(int i = 1; i < len; i++){
            //if maxDP[i-1]<0, then maxDP[i-1]+nums[i] < nums[i], so the 
            //max value end with nums[i] must be nums[i] itself
            //vice versa
            maxDP[i] = (maxDP[i - 1] < 0 ? 0 : maxDP[i - 1]) + nums[i];
            max = Math.max(max, maxDP[i]);
        }
        
        return max;
    }
}