public class Solution {
    int row;
    int col;
    public int minCostII_DP(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }//corner case
        
        row = costs.length;
        col = costs[0].length;
        
        int[] pathDP = new int[col];//DP array
        int min = 0;//save the min cost when determine each house
        int secondMin = 0;//save the second min cost when determine
        
        //the first for loop determine the min cost from first house
        //to last house
        //the second for loop determin the each house, what the min
        //cost and second min cost is
        for(int i = 0; i < row; i++){
            int tempMin = min;
            int tempSecMin = secondMin;
            min = Integer.MAX_VALUE;
            secondMin = Integer.MAX_VALUE;
            for(int j = 0; j < col; j++){
                //if this color isn't the one with min cost in previous house, then we
                //can chose the min one for the previous house if we chose this color for
                //this house
                //if this color is just the cheapest one for the previous house, then we 
                //have to chose the second min one for the previous
                pathDP[j] = (pathDP[j] == tempMin ? tempSecMin : tempMin) + costs[i][j];
                if(min <= pathDP[j]){
                    //determine the second min
                    secondMin = Math.min(pathDP[j], secondMin);
                }else{
                    //determine the min
                    secondMin = min;
                    min = pathDP[j];
                }
            }
        }
        
        return min;
    }
}