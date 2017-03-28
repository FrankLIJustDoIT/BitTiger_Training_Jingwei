public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalLen = m+n-1;
        int len1 = m-1;
        int len2 = n-1;
        while(len1>=0 && len2>=0){
            nums1[totalLen--] = nums1[len1]>=nums2[len2]?nums1[len1--]:nums2[len2--];
        }
        
        while(len2>=0){
            nums1[totalLen--]=nums2[len2--];
        }
    }
}