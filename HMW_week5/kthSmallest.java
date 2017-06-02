public class Solution {
    //the basic idea of solving this problem is binary search
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int small = matrix[0][0];
        int big = matrix[len - 1][len - 1];
        
        while(small <= big){
            //each time we determine a mid value and use helper to see how many
            //elements in the matrix is less than or equal to the mid value
            int mid = small + (big - small) / 2;
            int count = helper(matrix, mid);
            
            //count < k means the kth smallest value must bigger than this mid, so we 
            //use the bigger half and find a new mid to have another try
            if(count < k){
                small = mid + 1;
            }else{
                //otherwise we use the smaller half
                big = mid - 1;
            }
        }
        
        return small;
    }
    //so now helper() is used to determine how many elements in the matrix is less than or 
    //equal to mid, we solve it by traverse through from the bottom left to top right pos
    private int helper(int[][] matrix, int mid){
        int count = 0;
        int x = 0;
        int y = matrix.length - 1;
        while(x < matrix.length && y >= 0){
            if(matrix[x][y] > mid){
                //this element is bigger than mid, we can't count it so we y-- and try again
                //in the next round
                y--;
            }else{
                //this element is smaller than or equal to mid, so we can count it and all
                //other elements above in this colume as they are sorted in ascending order
                count += y + 1;
                //now that we have already know the number of element can be counted in this
                //colume, we make x++ and try another colume
                //because the elements in each row are sorted in order, we don't need to concern
                //about elements below in the new colume as they are must bigger than mid
                x++;
            }
        }
        
        return count;
    }
}