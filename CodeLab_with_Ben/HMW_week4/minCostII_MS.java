public class Solution {
    int row;
    int col;
    public int minCostII_MS(int[][] costs) {
        if(costs==null || costs.length == 0){
            return 0;
        }//base case
        
        row = costs.length;
        col = costs[0].length;
        int[][] path = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(path[i], -1);
        }//preset, all be -1 as costs is non-negative
        
        int min = Integer.MAX_VALUE;
        
        
        for(int i = 0; i < col; i++){
            int res = helper(costs, path, 0, i);
            min = Math.min(min, res);
        }//for the first house, try each color and find the min one
        
        return min;
    }
    //each time we run helper, it computes and saves the total min cost of painting
    //from this house in this color to the remaining houses
    private int helper(int[][] costs, int[][] path, int i, int j){
        if(path[i][j] != -1){
            return path[i][j];
        }//pruning
        if(i == row - 1){
            return costs[i][j];
        }//base case
        
        int min = Integer.MAX_VALUE;
        for(int m = 0; m < col; m++){
            if(m == j){
                continue;
            }// neighbor houses cannot be painted in the same color
            int res = helper(costs, path, i + 1, m);
            min = Math.min(res, min);
        }
        
        //the total min cost is the cost of this house in this color plus 
        //the cost of remaining houses.
        //save the value in path and return
        path[i][j] = min + costs[i][j];
        
        return path[i][j];
    }
}