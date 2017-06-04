public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }//corner case
        
        int beg = 0;//secondary pointer
        int maxLen = 0;//max length of substring
        char[] sChar = s.toCharArray();
        int[] map = new int[256];//map is used for save the right most index
        //of a character
        
        //i is the primary pointer, traverse through the sChar
        for(int i = 0; i < sChar.length; i++){
            if(map[sChar[i]] == 0){
                //which means this char is first appreared in the array, so we 
                //just increase the lenth of current hold substring by 1 and see 
                //whether we can make it be of a new maxLen 
                maxLen = Math.max(maxLen, i - beg + 1);
            }else{
                //which means this char has already appeared before, so we maybe have to
                //start hold a new substring, we make it by finding the next pos 
                //of this char when the last time it appreared, if this index is before
                //the current beg, which means we don't have to care about it and just 
                //increase. If the index is after the current beg, which means we have
                //to start a new substring, and the new beg is just after this char when
                //it appreared last time
                beg = Math.max(beg, map[sChar[i]]);
                maxLen = Math.max(maxLen, i - beg + 1);
            }
            
            //record the (new) next pos of this char
            map[sChar[i]] = i + 1;
        }
        
        return maxLen;
    }
}