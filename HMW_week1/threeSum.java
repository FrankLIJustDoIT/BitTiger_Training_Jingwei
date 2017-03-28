public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if(nums==null || nums.length<3){ return resList; }
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){ break; }
            if(i>0 && nums[i]==nums[i-1]){ continue; }
            int mid = i+1;
            int last = nums.length-1;
            while(mid<last){
                int sum = nums[i]+nums[mid]+nums[last];
                if(sum==0){
                    resList.add(Arrays.asList(nums[i],nums[mid],nums[last]));
                    while(mid<last && nums[mid]==nums[mid+1]){ mid++; }
                    while(mid<last && nums[last]==nums[last-1]){ last--; }
                    mid++;
                    last--;
                }else if(sum>0){
                    while(mid<last && nums[last]==nums[last-1]){ last--; }
                    last--;
                }else{
                    while(mid<last && nums[mid]==nums[mid+1]){ mid++; }
                    mid++;
                }
            }
        }
        return resList;
    }
}