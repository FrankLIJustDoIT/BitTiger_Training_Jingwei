public class Solution {
    //to solve this problem we first traverse the nums and compute the sum of all the elements
    //in the range 0~i, 0<=i<length and save the result in sums, then when we want to get the 
    //sum from i~j, 0<=i<=j<length, we just let sums[j+1] - sums[i+1]
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for(int i = 0; i < n; i++){
            sums[i + 1] = sums[i] + nums[i];
        }
        
        return countWithMergeSort(sums, 0, n + 1, lower, upper);
    }
    
    //we use merge sort as the main idea to solve this problem, every time we run countWithMergeSort(),
    //we are computing the number of valid range sgms in [start, end), we at first compute the mid point
    //and then do recursion in computinf the number of valid sums in [start,mid) and [mid, end), then we
    //concern about range sum situations that their start index lies in [start, mid) and the end index lies
    //in[mid, end).
    private int countWithMergeSort(long[] sums, int start, int end, int lower, int upper){
        if(end - start <= 1){
            return 0;
        }
        
        int mid = (start + end) >>> 1;
        
        int count = countWithMergeSort(sums, start, mid, lower, upper) 
                    + countWithMergeSort(sums, mid, end, lower, upper);
                    
        //we sort the value in sums in[start, end), which means when we finished the resursion
        //in the left and right side, these two sides are sorted, so that we can find lowerPointer
        //and upperPointer by simply try the indexs one by one, and the values between them is just
        //the valid range sums
        //because the sorted results are always for the convenience of the computation of upper layer
        //so it makes no negative influence on the meaning of result, we don't need to know what exactly
        //the range sums is anyway, we just need to know it exists, upper/lowerPointer always locates after
        //i in the original sums array anyway.
        long[] cache = new long[end - start]; 
        int lowerPointer = mid;
        int upperPointer = mid;
        int sortPointer = mid;
        
        for(int i = start, j = 0; i < mid; i++, j++){
            while(lowerPointer < end && sums[lowerPointer] - sums[i] < lower){
                lowerPointer++;
            }
            
            while(upperPointer < end && sums[upperPointer] - sums[i] <= upper){
                upperPointer++;
            }
            
            //we sort the values by using a cache array, it's like we sort a pile
            //of poker cards, we always put the smaller one first in the cache
            while(sortPointer < end && sums[sortPointer] < sums[i]){
                cache[j++] = sums[sortPointer++];
            }
            cache[j] = sums[i];
            
            count += upperPointer - lowerPointer;
        }
        
        //cover the old values in sums by new values in cache
        System.arraycopy(cache, 0, sums, start, sortPointer - start);
        return count;
    }
}