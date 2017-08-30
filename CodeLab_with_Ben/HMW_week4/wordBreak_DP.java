public class Solution {
    public boolean wordBreak_DP(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }//corner case
        if(wordDict == null || wordDict.size()==0){
            return false;
        }//corner case

        int len = s.length();
        //match[i] represents whether some elements in wordDict
        //can match s.substring(0, i), once an option is found,
        //we set match[i] to true;
        //match[0] is the base case, so match[len] but not match[len-1]
        //is the final result we need
        boolean[] match = new boolean[len + 1];
        match[0] = true;//base case
        
        for(int i = 1; i <= len; i++){
            //from 1st char to len th char in s
            for(int j = 0; j < i; j++){
                //j increased from 0 to i, if match[j] is true, which means
                //the first  j th(0 to j-1) char in s can match, and wordDict 
                //contains substring(j,i) (j to i-1), then we say we find an 
                //option and we can set match[i]=true
                if( match[j] && wordDict.contains( s.substring(j,i) ) ){
                    match[i] = true;
                    break;
                }
            }
        }
        
        return match[len];
    }
}