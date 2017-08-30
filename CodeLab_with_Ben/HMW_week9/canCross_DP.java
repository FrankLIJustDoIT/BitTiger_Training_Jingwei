public class Solution {
    public boolean canCross_DP(int[] stones) {
        if(stones == null || stones.length == 0){
            return true;
        }
        
        //the key of the map is the stones and their corresponding value is the 
        //steps they can chose to get to any next stone
        //we use hashset because when we jump to this stone from diffrent stones, the possible
        //next steps may have some duplicates, there's no need we consider same steps for multiple
        //times, so we just use a hashset
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            map.put(stones[i], new HashSet<>());
        }
        
        map.get(stones[0]).add(1);
        
        for(int i = 0; i < stones.length; i++){
            for(int step : map.get(stones[i])){
                int reach = stones[i] + step;
                
                if(reach == stones[stones.length - 1]){
                    return true;
                }
                
                Set<Integer> set = map.get(reach);
                
                //maybe there's no such a stone, which means by jump that much we will
                //jump into the sea, so the set could be null
                if(set != null){
                    if(step - 1 > 0){
                        map.get(reach).add(step - 1);
                    }
                    map.get(reach).add(step);
                    map.get(reach).add(step + 1);   
                }
            }
        }
        
        return false;
    }
}