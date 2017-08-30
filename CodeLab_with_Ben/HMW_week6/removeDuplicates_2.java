public class Solution {
    public int removeDuplicates_2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }//corner case
        
        if(nums.length <= 2){
            return nums.length;
        }//corner case
        
        int index = 0;//the secondary pointer
        
        for(int i = 0; i < nums.length; i++){
            //except for index<2, nums[i]>nums[index-2] means nums[i]
            //can be put in nums[index]
            if(index < 2 || nums[i] > nums[index - 2]){
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}