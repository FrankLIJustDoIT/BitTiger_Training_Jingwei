public class Solution {
    public int maxProfit_MS(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }//corner case
        
        //the idea of solving this problem is that
        //from the start day to the end day, we keep finding
        //the temperal min value, and any possible max profit
        //is achieved by subtracting current price with current 
        //min value, which is absolutely always before the current
        //value, we keep finding the temperal maximum profit from 
        //all these possible max profits and when we have done with
        //all the days, we find the final max profit
        
        int len = prices.length;
        System.out.println(len);
        //each position in max is used to save the current max profit
        //so far
        int[] max = new int[len];
        max[0] = 0;
        
        helper(prices, max, len - 1);
        
        return max[len - 1];
    }
    private int helper(int[] prices, int[] max, int pos){
        if(pos == 0){
            return prices[0];
        }
        int min = Math.min( helper(prices, max, pos - 1), prices[pos] );
        max[pos] = Math.max( max[pos - 1], prices[pos] - min );
        return min;
    }
}