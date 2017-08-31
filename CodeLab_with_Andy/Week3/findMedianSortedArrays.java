public class Solution {
    //the main idea is like what we do in the merge step of merge-sort
    //as the two arrays are all already sorted
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int m = 0;
        int n = 0;
        int i = 0;
        while(m < nums1.length && n < nums2.length){
            nums[i++] = (nums1[m] >= nums2[n]) ? nums2[n++] : nums1[m++];
        }
        
        while(m < nums1.length){
            nums[i++] = nums1[m++];
        }
        
        while(n < nums2.length){
            nums[i++] = nums2[n++];
        }
        return nums.length % 2 == 0 ? (double)(nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2 : nums[nums.length / 2];
    }
}