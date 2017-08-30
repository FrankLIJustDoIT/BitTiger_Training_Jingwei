public class Solution {
    public List<Integer> countSmaller_List(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            return res;
        }
        
        for(int i = nums.length - 1; i >= 0; i--){
            int index = findIndex(path, nums[i]);
            res.add(index);
            //for arraylist, add(index, x) is insert, that's the key
            //every time we get an index, it means up to now, how many numbers right before numbers[i] are 
            //smaller than nums[i]
            path.add(index, nums[i]);
        }
        
        Collections.reverse(res);
        
        return res;
    }
    
    private int findIndex(List<Integer> path, int target){
        if(path == null || path.size() == 0){
            return 0;
        }
        
        int beg = 0;
        int end = path.size() - 1;
        
        if(path.get(beg) >= target){
            return 0;
        }else if (path.get(end) < target){
            return end + 1;
        }
        
        //this is a typical binary search, searching for the right position
        //that target should be insert into
        while(beg <= end){
            int mid = (beg + end) >>> 1;
            
            if(path.get(mid) < target){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return beg;
    }
}
