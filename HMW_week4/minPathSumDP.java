public class Solution {
    int row;
    int col;
    public int minPathSumDP(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }//corner case
        
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                //divide into several different situations
                if(i == row - 1 && j == col - 1){
                    grid[i][j] = grid[i][j];
                }else if(i == row - 1 && j != col - 1){
                    grid[i][j] += grid[i][j + 1];
                }else if(i != row - 1 && j == col - 1){
                    grid[i][j] += grid[i + 1][j];
                }else{
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        
        return grid[0][0];
    }
}