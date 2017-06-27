public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        
        Map<Integer , Integer> frequency = new HashMap<>();
        
        for(int n : nums){
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }
        
        for(int key : frequency.keySet()){
            
            if(bucket[frequency.get(key)] == null){
                bucket[frequency.get(key)] = new ArrayList<>();
            }
            
            bucket[frequency.get(key)].add(key);
        }
        
        for(int i = nums.length; i >= 0 && res.size() < k; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        
        return res;
        
    }
}