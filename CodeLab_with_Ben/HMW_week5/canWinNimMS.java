public boolean canWinNimMS(int n){
    //the map is here for memory search
    return helper(n, new HashMap<>());
}

public boolean helper(int n, Map<Integer, Boolean> map){
    if(n <= 0){
        return false;
    }//n<=0 means my friend take all the stones left and win the game
    
    if(map.containsKey(n)){
        return map.get(n);
    }//if we dealed with n before, we just return it, this is memory search
    
    boolean canNextWin = true;
    for(int i = 1; i <= 3; i++){
        canNextWin = helper(n - i, map);
    }
    
    map.put(n, !canNextWin);
    
    return !canNextWin;
}