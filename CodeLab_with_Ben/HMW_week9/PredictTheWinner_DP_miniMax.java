public class Solution {
    public boolean PredictTheWinner_DP_miniMax(int[] nums) {
        if(nums == null || nums.length <= 1){
            return true;
        }//corner case
        
        int len = nums.length;
        
        //here we use dp array to do miniMax
        //dp[i][j] means partly profit
        int[][] dp = new int[len][len];
        
        for(int i = 0; i < len; i++){
            dp[i][i] = nums[i];
        }
        
        for(int end = 1; end < len; end++){
            for(int i = 0, j = end; j < len; i++, j++){
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        
        return dp[0][len - 1] >= 0;
    }
}