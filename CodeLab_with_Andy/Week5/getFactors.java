class Solution {
    //the main idea is dfs + memory search
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> resList = new ArrayList<>();
        helper(resList, new ArrayList<Integer>(), 2, n);
        
        return resList;
    }
    
    private void helper(List<List<Integer>> resList, List<Integer> path, int start, int n){
        if(n <= 1){
            if(path.size() > 1){
                //the target number itself can't be counted as a path
                resList.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        for(int i = start; i <= n; i++){
            if(n % i == 0){
                path.add(i);
                //i is recorded to avoid duplicate solution
                helper(resList, path, i, n / i);
                path.remove(path.size() - 1);
            }
        }
        
    }
}