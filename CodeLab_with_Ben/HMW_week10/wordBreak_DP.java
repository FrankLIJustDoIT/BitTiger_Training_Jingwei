public class Solution {
    public boolean wordBreak_DP(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }//corner case
        
        //here we use dp array, dp[i] means whether s.substring(0,i)
        //can be matched by the strings in wordDict
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j <= i; j++){
                //for each sustring(0,i), we try each intermediate j, 
                //see whether substring(j,i) can be matched with wordDict
                //as we already matched substring(0,j)
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}