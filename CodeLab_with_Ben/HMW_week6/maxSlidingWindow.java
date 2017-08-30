public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }//corner case
        
        int len = nums.length;
        //res is used for saving all the max values
        int[] res = new int[len - k + 1];
        
        //the head of the deque is used to hold the temp max values
        //the tail of the deque is used to make sure the elements in the deque is legal
        Deque<Integer> heap = new ArrayDeque<>();
        
        for(int i = 0; i < len; i++){
            if(!heap.isEmpty() && heap.peekFirst() == i - k){
                //which means we have already consider 3 elements so we need to
                //remove the head one
                heap.removeFirst();
            }
            while(!heap.isEmpty() && nums[heap.peekLast()] < nums[i]){
                //in this condition, to make sure we always hold the temp max value
                //in the left, we have to keep removing the tail values until nums[i]
                //reach the approaprite the pos
                heap.removeLast();
            }
            
            heap.addLast(i);
            
            if(i - k + 1 >= 0){
                //after i reach the value that i-k+1>=0, every time we traverse one element
                //right, we get a new 3-elements tuple in the sliding window, so we get a
                //new temp max and have to record it
                res[i - k + 1] = nums[heap.peekFirst()];
            }
        }
        
        return res;
    }
}