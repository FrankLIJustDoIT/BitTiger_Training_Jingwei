public class MedianFinder {
    //the minheap is to save the bigger half of the data from the data stream
    //they are held in ascending order so the peek value is the median value 
    //or one of the two median values
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    //the maxHeap is to save the smaller half of the data from the data stream
    //they are held in decending order so the peek value is one of the median value
    //if the minheap and maxheap are of same size
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer l1, Integer l2){
            return l2 - l1;
        }
    });

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        //we first add the new data in the bigger half and then put the min value from
        //the bigger half to the smaller half so we maintian that minheap and maxheap
        //are of the same size or minheap is one more larger than maxheap
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        //if minheap is smaller than maxheap, we put the max value in maxheap in minheap
        if(minHeap.size() < maxHeap.size()){
            minHeap.add(maxHeap.poll());
        }
    }
    
    //by maintaining these two heap, through all the data in the stream, we put the larger half
    //in a heap and held in increasing order and the smaller half in a heap and held them in
    //decreasing order, because these two heaps are same in size or larger half is one more
    //than the smaller half, so by using peek() in O(1) time we get the median value of all
    //the data.
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }else{
            return (double) minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */