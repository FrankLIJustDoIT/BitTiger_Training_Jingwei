public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }//corner case
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //for each cell in the board, we compute how many lives
                //around it 
                int lives = helper(board, m, n, i, j);
                
                //we assume first that all the cells will goint to die in the next state
                //and only those qualified can stay or become live at that time
                //we represent the two states by 2 bits, the least significant bit is the
                //first state and the second bit is the second state.
                if(board[i][j] == 1 && lives >= 2 && lives <= 3){
                    board[i][j] = 3;//3 is 11 in binary form which means the cell stay alive
                    //in the second state
                }
                
                if(board[i][j] == 0 && lives == 3){
                    board[i][j] = 2;//2 is 10 in binary form which means the vell become
                    //alive from die in the second state.
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>>= 1;//right shift the bits so the initial state is eliminated
                //so the cell now only contains information about the second state.
            }
        }
    }
    
    private int helper(int[][] board, int m, int n, int i, int j){
        int lives = 0;
        
        for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++){
            for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++){
                lives += board[x][y] & 1;
            }
        }
        
        lives -= board[i][j] & 1;
        
        return lives;
    }
}