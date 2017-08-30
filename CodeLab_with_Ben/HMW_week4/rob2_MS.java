public class Solution {
    public int rob2_MS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }//corner case
        
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }//corner case
        
        int maxYes = 0;
        int maxNo = 0;
        
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
            maxNo = nums[1];
            maxYes = 0;
        }else{
            maxNo = noHelper(nums, nums.length - 1);
            if(len == 3){
                //if len=3, then the only option for maxYes is to just rob
                //the first house
                maxYes = 0;
            }else if(len == 4){
                //if len=4, then the only option for maxYes is to rob the 
                //first house and the third house
                maxYes = nums[2];
            }else{
                maxYes = yesHelper(nums, nums.length - 2);
            }
            
        }
        System.out.println(maxNo);
        System.out.println(maxYes);
        return Math.max(maxNo, maxYes + nums[0]);
    }
    private int noHelper(int[] nums, int pos){
        if(pos == 1){
            return nums[1];
        }
        if(pos == 2){
            return Math.max(nums[1], nums[2]);
        }
        
        return Math.max(noHelper(nums, pos - 1), noHelper(nums, pos - 2) + nums[pos]);
    }
    private int yesHelper(int[] nums, int pos){
        if(pos == 2){
            return nums[2];
        }
        if(pos == 3){
            return Math.max(nums[2], nums[3]);
        }
        
        return Math.max(yesHelper(nums, pos - 1), yesHelper(nums, pos - 2) + nums[pos]);
    }
}