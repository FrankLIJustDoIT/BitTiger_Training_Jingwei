public class Solution {
    public int maxEnvelopes_DP(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }//corner case
        
        Arrays.sort(envelopes, (int[] l1, int[] l2) -> {
            if(l1[0] == l2[0]){
                return l2[1] - l1[1];
            }else{
                return l1[0] - l2[0];
            }
        });//lambda expression, for the width, we sort them in ascending 
        //order, while if two envelopes got same width, we sort their height is 
        //descending order, so that we can just need to count the longest
        //increasing line in the height line
        
        int len = envelopes.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        
        for(int i = 0; i < len; i++){
            int maxVal = 0;
            for(int j = 0; j < i; j++){
               if(envelopes[j][1] < envelopes[i][1]){
                   maxVal = Math.max(maxVal, dp[j]);
               }
            }
            
            dp[i] = maxVal + 1;
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}