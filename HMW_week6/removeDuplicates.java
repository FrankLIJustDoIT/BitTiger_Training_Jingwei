public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }//corner case
        
        if(nums.length == 1){
            return 1;
        }//corner case
        
        int index = 0;//this is set as the secondary pointer, follow and record
        
        //i is set as primary pointer, proactively traverse the array
        for(int i = 0; i < nums.length; i++){
            //except for the first element, if nums[i] > nums[index-1] then
            //it means nums[i] is qualified to be put in numd[index]
            if(index < 1 || nums[i] > nums[index - 1]){
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}