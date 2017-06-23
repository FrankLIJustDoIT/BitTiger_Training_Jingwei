public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 1;
        }//corner case
        
        int len = dungeon.length;
        int wid = dungeon[0].length;
        
        //we make a dp array, dp[i][j] means from here to botton right, how many health the knight
        //should at least have
        int[][] dp = new int[len][wid];
        
        dp[len - 1][wid - 1] = Math.max(1 - dungeon[len - 1][wid - 1], 1);
        
        for(int i = len - 2; i >= 0; i--){
            dp[i][wid - 1] = Math.max(dp[i + 1][wid - 1] - dungeon[i][wid - 1], 1);
        }
        
        for(int i = wid - 2; i >= 0; i--){
            dp[len - 1][i] = Math.max(dp[len - 1][i + 1] - dungeon[len - 1][i], 1);
        }
        
        
        //for example, if we want to see how many health the knight should have to choose
        //go to right to rescue the princess, we should know the amount of health required
        //to stand in the right room, taking the health he needed to stand in the current room,
        //we know dp[i][j] - (- dungeon[i][j]) >= dp[i][j + 1], so we got function below, if
        //the computed right < 0, it means the knight cannot die anyway, even if he has a negetive(right)
        //value of health he can survive, but we know when health below 0, the knight already die, so at 
        //that time, dp[i][j] = 1, the lowest health allowed to keep alive
        for(int i = len - 2; i >= 0; i--){
            for(int j = wid - 2; j >= 0; j--){
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                
                dp[i][j] = Math.min(down, right);
            }
        }
        
        return dp[0][0];
    }
}