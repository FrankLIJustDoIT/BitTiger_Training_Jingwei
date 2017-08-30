public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }//corner case
        
        //we traverse through the nums, for each element in the nums, if its value is in the range[0,nums[i]-1), then
        //we put it in the pos which is just same as its value, so that when we finish 
        //traverse all the elements and retraverse it again, when we first meet nums[i] != i+1
        //it is the first missing positive integer
        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]){
                //we swap the old value in nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                //after swaping nums[i] now get a new value, so we should traverse it again
                i--;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
}