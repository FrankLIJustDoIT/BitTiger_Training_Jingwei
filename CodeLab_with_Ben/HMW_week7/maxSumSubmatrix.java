public class Solution {
    //we just think about the case of row = 1, in this condition to solve this problem
    //we should sum up all the 0~i, which 0<=i<=col-1, and save them, during which we keep looking for
    //the smallest sum res we saved which makes nums[i] - target < res, or nums[i]-res<target, so then
    //by keep finding the max of nums[i] - res, we can find the one which is closest to target, for example
    //that res is sum of 0~j, then sum of j~i is just what we want
    
    //in this 2D question, we just sum up from col j to col 0, and for each col, we treat it just like the
    //1-D solution,this is as the whole the same idea
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0){
            return 0;
        }//corner case
        
        int col = matrix[0].length;
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < col; i++){
            int[] array = new int[row];
            
            // sum from row j to row i
            for(int j = i; j >= 0; j--){
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                
                //traverse every column and sum up
                for(int k = 0; k < row; k++){
                    array[k] = array[k] + matrix[k][j];
                    val = val + array[k];
                    //use  TreeMap to binary search previous sum to get possible result 
                    Integer subres = set.ceiling(val - target);
                    if(subres != null){
                        res = Math.max(res, val - subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}