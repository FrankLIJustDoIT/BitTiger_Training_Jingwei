public class Solution {
    public int numSquares_DP(int n) {
        if(n == 0){
            return 0;
        }//corner case
        
        //DP[i] means the perfect squares for int i
        int[] DP = new int[n + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = 0;//preset
        
        //from i=1, we find the perfect squares for 
        //each i until i=n
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            //we try every j which can be an element to 
            //make a perfect squares
            while(i - j*j >= 0){
                //keep trying the condidates and try to
                //find a min
                min = Math.min(min, DP[i - j*j] + 1);
                j++;
            }
            DP[i] = min;
        }
        
        return DP[n];
    }
}