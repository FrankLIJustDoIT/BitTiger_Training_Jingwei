public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= 0){
            return true;
        }//corner case
        
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal){
            return false;
        }//arithmetic progression summation formula, corner case
        
        return helper(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
    }
    
    //each time we run helper(), we are determining wether a player can win the game
    //on the condition that there is total stones left and state numbers have been used
    //state here is used for recording the path, which means what numbers between 1 and n
    //have been used before, here we see it like a set of n boxs, each is labeled by its
    //index. The state starts from 0 and each time when we decide to move m stones, we make
    //a number x = 1 << m-1, which means only the m th pos in x is 1 and all other bits are
    //all 0, so when we do state | (1<<(m-1)), the m th pos in state will be set from 0 to 1
    //so we marked that m has been used. Therefore, state contains information about not only
    //what numbers has been used but also how many stones have already been removed and how 
    //many left as we know total.
    private boolean helper(int total, int n, int state, Map<Integer, Boolean> map){
        if(total <= 0){
            return false;
        }//base case, which means the other player can take away all the stones in the last 
        //round
        
        if(map.containsKey(state)){
            return map.get(state);
        }//we save the results in a map, for each state, after we get the result about wether
        //the player can win, we save the result in the map so we do pruning and memory search
        
        for(int i = 0; i < n; i++){
            if((state & (1 << i)) != 0){
                continue;
            }//by using &, if the result is 0, it means the i+1 th bit in state is still 0 so 
            //we haven't use i+1 before and it can be used now, otherwise it means we have used
            //this number before so we have to continue and try other numbers
            
            if(!helper(total - (i + 1), n, state | (1 << i), map)){
            //we try every posible i in recursion helper(), if any of it return false, it means in
            //this layer we can win the game by take away the corrsponding number of stones, so we 
            //can now mark this layer as true and return
                map.put(state, true);
                return true;
            }
        }
        
        //we try every possible i and they all return true, it means by no means the player can win
        //the game now, because no matter what movement he make, the other player can alwasy have a 
        //way the win the game, so we mark and return false;
        map.put(state, false);
        return false;
    }
}