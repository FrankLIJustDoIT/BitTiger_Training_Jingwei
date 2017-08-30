public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }//corner case
        
        //map is for saving the chars of current holding substring and their right most indexs
        Map<Character, Integer> map = new HashMap<>();
        
        int beg = 0;//the secondary pointer
        int maxLen = 0;//the length of current longest substring
        
        char[] sChar = s.toCharArray();
        
        //i is the primary pointer
        for(int i = 0; i < sChar.length; i++){
            if(map.size() < 2 || (map.size() == 2 && map.containsKey(sChar[i]))){
                //which means there are less or equal to 2 different kinds of chars in the 
                //current holding substring, so we just need to add it or renew the index
                map.put(sChar[i], i);
            }else{
                //which means there is a third char, so now we end the detecting of last substring 
                //and now we start to hold a new substring
                int leftIndex = i;
                
                //we find out the left most indexes in the map
                for(int x : map.values()){
                    leftIndex = Math.min(leftIndex, x);
                }
                
                //record its next pos
                beg = leftIndex + 1;
                
                //remove the left most element in the map and add the new one
                map.remove(sChar[leftIndex]);
                map.put(sChar[i], i);
            }
            
            maxLen = Math.max(maxLen, i - beg + 1);
        }
        
        return maxLen;
    }
}