public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length < 1){
            return false; 
        }//corner case
        
        //basic idea is still binary search
        int start=0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = (start + end) >>> 1;//avoid stack overflow
            if(nums[mid] == target){ 
                return true; 
            }//base case
            
            //if left half sorted or right half unsorted
            //just nums[start]<nums[mid] may neglect that from start to mid are all same value
            //while let nums[start]==nums[mid] may mistakely include that from mid to end 
            //and start are all same value.
            //so for the situation that mid is in the left of the pivot, it should be like this
            if(nums[start] < nums[mid] || nums[mid] > nums[end]){
                if(target > nums[mid] || target < nums[start]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else if(nums[mid] < nums[end] || nums[start] > nums[mid]){
                if(target < nums[mid] || target > nums[end]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                //this situation means nums[start]=nums[mid]=nums[end]
                //the mid could be in either left or right side of the pivot
                //end-- or start++ to make the loop can continue
                end--;
            }
        }
        return false;
    }
}