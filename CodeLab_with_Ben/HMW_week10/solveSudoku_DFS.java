public class Solution {
    public void solveSudoku_DFS(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }//corner case
        
        helper(board);
    }
    
    private boolean helper(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                //traverse every pos, find '.'
                if(board[i][j] == '.'){
                    for(char curr = '1'; curr <= '9'; curr++){
                        if(isValid(board, i, j, curr)){
                            //if it is now avaliable to fill curr in, we fill it in
                            board[i][j] = curr;
                            
                            //if when board[i][j] is filled with curr we can finally get the correct result
                            //then it means this pos shoud be filled with curr, otherwise we just have to refill
                            //it with '.' and try other choices
                            if(helper(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    
                    //all choices failed, return false;
                    return false;
                }
            }
        }
        
        //no wrong happened, we return true
        return true;
    }
    
    private boolean isValid(char[][] board, int x, int y, char curr){
        for(int i = 0; i < board.length; i++){
            if(board[x][i] == curr || board[i][y] == curr){
                return false;
            }
        }//at first we try the whole column and row the y and x in, see whether
        //there is any duplicates
        
        //the 9 * 9 cells can be divided into 9 small 3*3 parts, we find the left top
        //cell of the samll part where the cell[x,y] located in
        int row = x / 3 * 3;
        int col = y / 3 * 3;
        
        for(int i = 0; i < board.length / 3; i++){
            for(int j = 0; j < board.length / 3; j++){
                if(board[row + i][col + j] == curr){
                    return false;
                }//try every cell in these 9 cells, see whether there's any duplicates
            }
        }
        
        //no duplicates in all cases, so we can return true
        return true;
    }
}