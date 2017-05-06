public class Solution {
    //use a static final int[][] so that we can use for loop in helper
    public static final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length=0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        //visited is used to save the length of the longest increasing path
        //start from each position
        int[][] visited = new int[m][n];
        int max = 1;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int len = helper(matrix,visited,i,j,m,n);
                max = Math.max(max,len);
            }
        }
        
        return max;
    }
    //every time we run helper, it computes the length of the longest increasing path start 
    //from matrix[i][j], and save the value in visieted[i][j]
    private int helper(int[][] matrix,int[][] visited,int i,int j,int m,int,n){
        if(visited[i][j]!=0){
            return visietd[i][j];
        }
        
        int max = 1;
        for(int[] d:dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x<0 || x>=m || y<0 || y>=n || matrix[x][y]<=matrix[i][j]){
                continue;
            }//controller
            int len = 1 + helper(matrix,visited,x,y,m,n);
            max = Math.max(max,len);
        }
        
        //all the four directions have tried, now we get the length of longest increasing path
        visited[i][j] = max;
        return max;
    }
}