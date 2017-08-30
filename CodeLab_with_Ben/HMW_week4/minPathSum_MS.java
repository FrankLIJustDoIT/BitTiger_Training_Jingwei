public class Solution {
    int row;
    int col;
    public int minPathSum_MS(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }//corner case
        
        row = grid.length;
        col = grid[0].length;
        int[][] count = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(count[i], -1);
        }//preset, because non-negative, so -1
        
        return helper(grid, count, 0, 0);
        
        
    }
    //each time when helper run, it computes the min sum from this point to right bottom
    private int helper(int[][] grid, int[][] count, int i, int j){
        if(count[i][j] != -1){
            return count[i][j];
        }//pruning, memorized
        
        int min = Integer.MAX_VALUE;
        if(i + 1 < row){
            min  = Math.min(min, helper(grid, count, i + 1, j));
        }
        if(j + 1 < col){
            min = Math.min(min, helper(grid, count, i, j + 1));
        }
        
        //the min sum of a point is the min one of the sums of its two next points
        //plus the value of this point. if already bottom right, which is also the 
        //base case, return bottom right only
        count[i][j] = (min == Integer.MAX_VALUE) ? grid[i][j] : min + grid[i][j];
        
        return count[i][j];

    }
}
