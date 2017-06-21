public class Solution {
    public int numDecodings_DP(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }//corner case
        
        int len = s.length();
        //here we use the idea of dynamic programming, dp[i] means form i to the end, how many ways we can chose
        //to decode the numbers
        int[] dp = new int[len + 1];
        
        dp[len] = 1;//base case, if the last two digits < 26, then decode this two digits together should be count
        //as one way
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        
        for(int i = len - 2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                continue;
            }//if it's a 0, we can't decode it, so we just leave the dp[i] be 0 as there should be just
            //one way to decode substring(i-1,i+1)
            
            int sub = Integer.parseInt(s.substring(i, i + 2));
            if(sub > 26){
                dp[i] = dp[i + 1];
            }else{
                dp[i] = dp[i + 1] + dp[i + 2];
            }
        }
        
        return dp[0];
    }
}