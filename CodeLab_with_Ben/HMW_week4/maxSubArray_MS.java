public class Solution {
    public int maxSubArray_MS(int[] nums) {
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
        
        return helper(nums, maxDP, len - 1);
    }
    private int helper(int[] nums, int[] maxDP, int pos){
        if(pos == 0){
            return maxDP[0];
        }
        
        int preMax = helper(nums, maxDP, pos - 1);
        
        maxDP[pos] = (maxDP[pos - 1] < 0 ? 0 : maxDP[pos - 1]) + nums[pos];
        return Math.max(preMax, maxDP[pos]);
    }
}