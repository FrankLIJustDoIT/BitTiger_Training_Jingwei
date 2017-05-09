    public int climbStairs_MS(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        //for a given floor n, we has two ways to approach here, one
        //is take one step from floor n-1, one if take two steps from floor n-2
        //so the total distinct ways to approach here is climb(n-1)+climb(n-2);
        return climbStairs(n - 1) + climbStairs(n - 2);
    }