public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        //if there is a pair of duplicates, when we keep traking x = nums[nums[x] - 1], we 
        //can build a ring, because there are at least 2 x point to the same next index, so the 
        //problem becomes find the ring in a linked list
        
        //we start from index n because nums[n-1] <= n-1, so we can always start tracking,
        //if we start from other index, there is possible that nums[i-1] == i, so we will keep
        //only track this nums[i-1]
        int slow = n;
        int fast = n;
        
        do{
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        }while(slow != fast);
        
        slow = n;
        
        while(slow != fast){
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        
        return fast;
    }
}