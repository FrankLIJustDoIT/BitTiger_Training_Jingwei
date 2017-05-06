public class Solution {
    public static final int[][] dircs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return matrix;
        }//corner case
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        //visited is to mark the position which is not 0
        // and has already been traversed
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false){
                    helper(matrix,i,j,m,n,visited);
                }
            }
        }
        
        return matrix;
    }
    //each iteration of helper, we find the value to be fill into the current position
    //which is also the closed distence to a 0 from this position
    private void helper(int[][] matrix, int i, int j, int m, int n, boolean[][] visited){
        if(matrix[i][j] == 0){
            return;
        }//base case
        
        visited[i][j] = true;
        int min = Integer.MAX_VALUE;
        
        for(int[] dirc : dircs){

            int x = i+dirc[0];
            int y = j+dirc[1];
            if(x < 0 || x >= m || y < 0 || y >= n){
                continue;
            }//base case

            if(matrix[x][y] != 0 && visited[x][y] == false){
                helper(matrix, x, y, m, n,visited);
            }
            int len = 1 + matrix[x][y];
            min = Math.min(min,len);
        }
        
        matrix[i][j] = min;
        return;
    }
}