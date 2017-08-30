public class Solution {
    int len;
    public boolean wordBreak_MS(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }//corner case
        if(wordDict == null || wordDict.size()==0){
            return false;
        }//corner case
        
        len = s.length();
        //visited[i]==1 means from the i th element to end 
        //element in s (i-1 to len-1), there is no good match
        //in wordDict
        int[] visited = new int[len];
        Arrays.fill(visited, -1);//initialization

        return helper(s, wordDict, 0, visited);
    }
    //each time we run helper, we are determining wether from the pos th element to
    //the end element(pos-1 to len-1) in s have a good match in wordDict, if yes, we
    //return true, and if no, we set visited[pos] to 1 and return false
    private boolean helper(String s, List<String> wordDict, int pos, int[] visited){
        if(pos == len){
            return true;
        }//base case, which means we already find a match
        if(visited[pos] != -1){
            return false;
        }//pruning, which means this way has already been proved that have no match
        
        //iterate from pos to len
        for(int i = pos + 1; i <= len; i++){
            String temp = s.substring(pos, i);
            if(wordDict.contains(temp)){
                //if there is a partly match, we do recursion and see wether the other part
                //(i to end) can match
                if(helper(s, wordDict, i, visited)){
                    //the other part can match, we return back true
                    return true;
                }else{
                    //the other part can't match, we mark visited[i]=1
                    //and try other option
                    visited[i] = 1;
                }
            }
        }//every option has been tried and no good match found, so we mark visisted[pos]=1
        //and return false;
        visited[pos] = 1;
        return false;
    }
}