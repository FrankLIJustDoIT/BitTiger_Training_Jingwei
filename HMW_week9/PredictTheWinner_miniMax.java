public class Solution {
    public boolean PredictTheWinner_miniMax(int[] nums) {
        //for player one, if his biggest difference could >= 0, then we say he's gonna win the game
        return miniMax(nums, 0, nums.length - 1) >= 0;
    }//solve this question using the idea of miniMax
    
    private int miniMax(int[] nums, int beg, int end){
        if(beg == end){
            return nums[beg];
        }
        
        //everytime we run miniMax, we compute which of his choice could make the 
        //profit between his score and the other guy's score become biggest, and we return the biggest
        //value
        //the value of this player's choice gain this time, subtract the amount of biggest profit the other player can
        //gain because of this choice, is just how much the profit this player can gain this time, 
        //we pick the biggest and return.
        return Math.max(nums[beg] - miniMax(nums, beg + 1, end), nums[end] - miniMax(nums, beg, end - 1));
    }
}