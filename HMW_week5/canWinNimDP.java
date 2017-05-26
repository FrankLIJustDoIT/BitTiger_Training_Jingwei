//if next layer has a chance to lose, then current layer has a chance to win
public boolean canWinNim(int n){
    return canWinNimDP(n);
}

public boolean canWinNimDP(int n){
    if(n <= 3){
        return true;
    }//base&corner case, when there is <=3 stones left, it's obvious that
    //I will win the game
    
    boolean[] dp = new boolean[4];//build dp array
    dp[0] = false;//when there's no stone left, it means I lose the game
    dp[1] = true;//i win
    dp[2] = true;//i win
    dp[3] = true;//i win
    
    //when we decide whether I can win when there's n stones left, we have a look at
    //cases after this round, we see wether i can win when there're n-1, n-2 and n-3 
    //stones left to my friend, because each time i and my friend can take 1 or 2 or 
    //3 stones,which means when i deal with n stones, in the next round my friend 
    //should deal with n-1 or n-2 or n-3 stones, if in any of the three situations
    //ha can win, it means I will lose the game, if for every situations he will
    //always lose, it means I will win for n stones
    while(int i = 4; i <= n; i++){
        dp[i % 4] = !(dp[(i - 1) % 4] && dp[(i - 2) % 4] && dp[(i - 3) % 4]);
    }
    
    return dp[n % 4];
}