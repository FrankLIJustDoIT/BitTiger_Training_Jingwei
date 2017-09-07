class Solution {
    private boolean[] occupiedCols;
    private boolean[] occupiedDiag1s;
    private boolean[] occupiedDiag2s;
    
    //we use dfs and memory search to solve this question
    public int totalNQueens(int n) {
        occupiedCols = new boolean[n];//whether this col has been used
        occupiedDiag1s = new boolean[2*n];//whether this bottom left to top right diag has been used
        occupiedDiag2s = new boolean[2*n];//whether this botton right tot top left diag has been used
        
        return helper(0, 0, n);
    }
    private int helper(int row, int count, int n){
        for(int col = 0; col < n; col++){
            if(occupiedCols[col]){
                continue;
            }
            
            //the coordinate of points on the same left-down right-up diag has constant value on row-col+n
            int diag1 = row - col + n;
            if(occupiedDiag1s[diag1]){
                continue;
            }
            
            //the coordinate of points on the same left-up right-down diag has constant value on row+col
            int diag2 = row + col;
            if(occupiedDiag2s[diag2]){
                continue;
            }
            
            if(row == n - 1){
                count++;//base case
            }else{
                occupiedCols[col] = true;
                occupiedDiag1s[diag1] = true;
                occupiedDiag2s[diag2] = true;
                
                count = helper(row + 1, count, n);
                
                //this way has been tried, should try other way, so convert the marks back
                occupiedCols[col] = false;
                occupiedDiag1s[diag1] = false;
                occupiedDiag2s[diag2] = false;
            }
        }
        
        return count;
    }
}