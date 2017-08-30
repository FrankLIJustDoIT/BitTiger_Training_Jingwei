public class Solution {
    public boolean wordBreak_DFS(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }//corner case
        
        return helper(s, 0, wordDict);
    }
    
    //for each recursion level of helper() with index, we compute if s.substring(index) can 
    //be matched using words in wordDict
    private boolean helper(String s, int index, List<String> wordDict){
        if(index == s.length() || wordDict.contains(s.substring(index))){
            return true;
        }//base case
        
        for(int i = index + 1; i < s.length(); i++){
            if(wordDict.contains(s.substring(index, i)) && helper(s, i, wordDict)){
                return true;
            }//recursion formula
        }
        
        return false;
    }
}