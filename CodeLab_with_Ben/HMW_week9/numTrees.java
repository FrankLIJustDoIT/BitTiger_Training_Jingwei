public class Solution {
    //we solve this problem by dp
    public int numTrees(int n) {
        //dp[i] represents when there are numbers from 1~i, how many BSTs
        //they can build, by bottom up we find the case of n numbers
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;//base case, which means when one side of a temp root has
        //no node or just one node, apprantly there's only one way we can arrange
        //this subtree
        
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                //when there's i nodes, picking out a root j, as there must be 1~(j-1) in the left side 
                //and (i+1)~n in the right side
                //the number of diffrent BSTs is computed by dp[j - 1] * dp[i - j]
                dp[i] += dp[j - 1] * dp[i - j]; 
            }
        }
        
        return dp[n];
    }
}