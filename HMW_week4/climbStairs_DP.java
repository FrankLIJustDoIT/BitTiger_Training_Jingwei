public class Solution {
    public int climbStairs_DP(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        //for a given floor n, we has two ways to approach here, one
        //is take one step from floor n-1, one if take two steps from floor n-2
        //so the total distinct ways to approach here is climb(n-1)+climb(n-2);
        int[] climbDP = new int[n + 1];
        climbDP[0] = 1;
        climbDP[1] = 1;
        
        for(int i = 2; i <= n; i++){
            climbDP[i] = climbDP[i - 1] + climbDP[i - 2];
        }
        
        return climbDP[n];
    }
}