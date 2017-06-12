public class NumArray {
    class SegmentTreeNode{
        int beg;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;
        int sum;
        
        public SegmentTreeNode(int beg, int end){
            this.beg = beg;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    
    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        //we solve this problem by building a trie tree, so the time complexty of 
        //update and sum are all O(logn), besides we need O(n) time to build a trie tree
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int beg, int end){
        if(beg > end){
            return null;
        }
        
        SegmentTreeNode curr = new SegmentTreeNode(beg, end);
        
        if(beg == end){
            curr.sum = nums[beg];
        }else{
            int mid = (beg + end) >>> 1;
            
            curr.left = buildTree(nums, beg, mid);
            curr.right = buildTree(nums, mid + 1, end);
            
            curr.sum = curr.left.sum + curr.right.sum;
        }
        
        return curr;
    
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode root, int pos, int val){
        if(root.beg == root.end){
            root.sum = val;
            return;
        }
        
        int mid = (root.beg + root.end) >>> 1;
        if(pos <= mid){
            update(root.left, pos, val);
        }else{
            update(root.right, pos, val);
        }
        
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode root, int beg, int end){
        if(root.beg == beg && root.end == end){
            return root.sum;
        }
        
        int mid = (root.beg + root.end) >>> 1;
        if(end <= mid){
            return sumRange(root.left, beg, end);
        }else if(beg > mid){
            return sumRange(root.right, beg, end);
        }else{
            return sumRange(root.left, beg, mid) + sumRange(root.right, mid + 1, end);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */