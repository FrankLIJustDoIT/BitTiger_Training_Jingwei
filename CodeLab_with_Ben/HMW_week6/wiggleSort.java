public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }//corner case
        
        //the for loop is quite easy, when it should be larger than the previous one, 
        //we swap if they are not; when it should be smaller than the previous one, 
        //we swap if they are not
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 1){
               if(nums[i-1] > nums[i]){ 
                   swap(nums, i);
               }
            }else if(i != 0 && nums[i-1] < nums[i]){
                swap(nums, i);  
            }             
        }
    }
    private void swap(int[] nums, int i){
          int tmp = nums[i];
          nums[i] = nums[i - 1];
          nums[i - 1] = tmp;
    }
}