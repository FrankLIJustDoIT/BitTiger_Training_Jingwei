public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            return res;
        }//corner case
        
        //because 1 <= nums[i] <= n, so in our traversing we can reverse nums[nums[i] - 1], so that if nums[i]
        //is duplicate, we can detect it by finding out that nums[nums[i]-1] < 0
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                res.add(index + 1);
            }
            
            nums[index] = -nums[index];
        }
        
        return res;
    }
}