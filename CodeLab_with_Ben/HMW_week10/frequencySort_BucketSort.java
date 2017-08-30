public class Solution {
    public String frequencySort_BucketSort(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(char curr : s.toCharArray()){
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }//count the frequency of each character
        
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        
        for(char curr : map.keySet()){
            int counter = map.get(curr);
            if(bucket[counter] == null){
                bucket[counter] = new ArrayList<>();
            }
            
            bucket[counter].add(curr);
        }//we use bucket sort here, we make an array of arraylist, characters of the same freqeuncy are
        //added into the same list
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = s.length(); i >= 0; i--){
            if(bucket[i] == null){
                continue;
            }
            
            for(char curr : bucket[i]){
                for(int j = 0; j < i; j++){
                    sb.append(curr);
                }
            }
        }
        
        return sb.toString();
    }
}