public class Solution {
    public boolean PredictTheWinner_recursion(int[] nums) {
        return playerOne(nums, 0, nums.length - 1, 0, 0);
    }//solve this question using the idea of recursion
    
    private boolean playerOne(int[] nums, int beg, int end, int sumOne, int sumTwo){
        if(beg > end){
            return sumOne >= sumTwo;
        }
        
        //once a choice of the two can lead to the other player fail, we say this player
        //will win the game
        return !(  playerTwo(nums, beg + 1, end, sumOne + nums[beg], sumTwo) 
                    && playerTwo(nums, beg, end - 1, sumOne + nums[end], sumTwo)  );
    }
    
    private boolean playerTwo(int[] nums, int beg, int end, int sumOne, int sumTwo){
        if(beg > end){
            return sumTwo > sumOne;
        }
        
        return !(  playerOne(nums, beg + 1, end, sumOne, sumTwo + nums[beg])
                    && playerOne(nums, beg, end - 1, sumOne, sumTwo + nums[end])  );
    }
}