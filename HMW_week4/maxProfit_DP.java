public class Solution {
    public int maxProfit_DP(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }//corner case
        
        //the idea of solving this problem is that
        //from the start day to the end day, we keep finding
        //the temperal min value, and any possible max profit
        //is achieved by subtracting current price with current 
        //min value, which is absolutely always before the current
        //value, we keep finding thse temperal maximum profit from 
        //all these possible max profits and when we have done with
        //all the days, we find the final max profit
        
        int min = Integer.MAX_VALUE;
        int max = 0;// set max to 0 so that profit cannot be negative
        //which means if the price keep going down, we don't sell the
        //stoke
        
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        
        return max;
    }
}