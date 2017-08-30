public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        
        if(words == null || words.length == 0){
            return res;
        }//corner case
        
        Arrays.sort(words, (l, r) -> {
            return l.length() - r.length();
        });//we at first sort the words in ascending order, according to 
        //the length of each word
        
        Set<String> dict = new HashSet<>();
        dict.add(words[0]);
        
        //as the first one is the shortest one, it cannot be formed by other word in the words, so
        //we can just start from the second one
        for(int i = 1; i < words.length; i++){
            if(wordBreak(words[i], dict)){
                res.add(words[i]);
            }//we traverse each word in the words, see if it can be comprised by words in the dict so far
            //which contains must only words shorter than this one.
            dict.add(words[i]);//add it to the dict any way
        }
        
        return res;
        
    }
    
    private boolean wordBreak(String s, Set<String> dict){
        int len = s.length();
        
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        
        for(int i = 1; i <= len; i++){
            for(int j = 0; j <= i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    } 
}