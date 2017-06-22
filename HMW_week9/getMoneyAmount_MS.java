public class Solution {
    private int[][] map;
    public int getMoneyAmount_MS(int n) {
        map = new int[n + 1][n + 1];//dp array, also like memory search
        
        return miniMax(1, n);
    }
    
    private int miniMax(int beg, int end){
        if(beg >= end){
            return 0;
        }//base case
        
        if(map[beg][end] != 0){
            return map[beg][end];
        }//if we have already compute same condition, just return it
        
        int res = Integer.MAX_VALUE;
        
        for(int i = beg; i <= end; i++){
            //from beg to end, we keep trying each number, and for each choice, compute the maximum money
            //we need to guarantee we can continue the game if we are wrong
            int cur = i + Math.max(miniMax(i + 1, end), miniMax(beg, i - 1));
            
            //for all those choice and money needed to guarantee the choice, we pick the one which is cheapest
            //and that should be our choice, it make sense in a real game
            res = Math.min(res, cur);
        }
        
        map[beg][end] = res;
        
        return res;
    }
}