public class Solution {
    public int lengthOfLIS_DP(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }//corner case
        
        int len = nums.length;
        //dp[i] represents from 0 to i, the length of the LIS by far
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLIS = 1;
        
        for(int i = 1; i < len; i++){
            int maxVal = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            
            dp[i] = maxVal + 1;
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        return maxLIS;
    }
}