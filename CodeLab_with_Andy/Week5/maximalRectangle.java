public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0; 
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int maxArea = 0;
        int[] store = new int[rowLen + 1];
        store[rowLen] = 0;
        for(int col = 0; col < colLen; col++){
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for(int i = 0; i <= rowLen; i++){
                if(i < rowLen){
                    if(matrix[i][col] == '1'){
                        store[i]++;
                    }else{
                        store[i] = 0;
                    }                    
                }
                
                while(!stack.isEmpty() && store[i] < store[stack.peekLast()]){
                    int top = store[stack.removeLast()];
                    int area = top * (stack.isEmpty() ? i : (i - stack.peekLast() - 1));
                    maxArea = Math.max(maxArea,area);
                }
                stack.addLast(i);
            }
        }
        return maxArea;
        
    }
}