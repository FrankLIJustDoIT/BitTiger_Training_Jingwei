public class Solution {
    public int findMin_Binary(int[] nums) {
        //though there could be duplicates in the nums, we can still use binary search
        int end = nums.length - 1;
        int start = 0;
        
        while(start <= end){
            int mid = (start + end) >>> 1;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else if(nums[mid] < nums[end]){
                end = mid;
            }else{
                //the existance of possible duplicates make it possible that nums[mid]=nums[end],
                //and in this condition we can't determine whether the pivot is in the left half
                //or right half of mid, but one thing is for sure in both condition, that from mid
                //to end or from 0 to mid + end, the elements are all the same, so we can just end--
                //which will makes no difference on the result, because we just delete a duplicate
                //element but not the pivot.
                end--;
            }
        }
        
        return nums[start];
    }
}