public class Solution {
    public int rob2_DP(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }//corner case
        
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }//corner case
        
        int[] maxNo = new int[len];//DP array for first house isn't robbed
        int[] maxYes = new int[len - 1];//DP array for first house is robbed
        
        //we divide the whole problem into 2 option
        //1: the first house is robbed, then the second house and last house
        //cannot be robbed, and the house between is just the same question
        //as House Robber 1
        //2: the first house is not robbed, then we are free to decide wether
        //to rob the second house and last house, it's the same question
        //as House Robber 1
        
        //if len=2, the only result of maxNo is just rob the second one
        //and for maxYes is just rob the first one
        if(len == 2){
            maxNo[len - 1] = nums[1];
            maxYes[len - 2] = 0;
        }else{
            maxNo[1] = nums[1];
            maxNo[2] = Math.max(nums[1], nums[2]);
            if(len == 3){
                //if len=3, then the only option for maxYes is to just rob
                //the first house
                maxYes[len - 2] = 0;
            }else if(len == 4){
                //if len=4, then the only option for maxYes is to rob the 
                //first house and the third house
                maxYes[len - 2] = nums[2];
            }else{
                maxYes[2] = nums[2];
                maxYes[3] = Math.max(nums[2], nums[3]);
            }
        }
        
        //now we solve the problem in the same way as House Robber 1
        //and compare which option has a higher gain.
        for(int i = 3; i < len; i++){
            maxNo[i] = Math.max(maxNo[i - 1], maxNo[i - 2] + nums[i]);
        }
        
        for(int i = 4; i < len - 1; i++){
            maxYes[i] = Math.max(maxYes[i - 1], maxYes[i - 2] + nums[i]);
        }
        
        return Math.max(maxNo[len - 1], maxYes[len - 2] + nums[0]);
    }
}