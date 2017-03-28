public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums==null){ return list; }
        if(nums.length==1){ 
            list.add(nums[0]+"");
            return list;
        }
        int m=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1] != 1){
                if(i-1!=m){
                    list.add(nums[m]+"->"+nums[i-1]);
                }else{
                    list.add(nums[m]+"");
                }
                m=i;
                if(m==nums.length-1){ list.add(nums[m]+""); }
            }else{
                if(i==nums.length-1){ list.add(nums[m]+"->"+nums[i]); }
            }
        }
        return list;
    }
}