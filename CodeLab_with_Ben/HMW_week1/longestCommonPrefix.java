public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length<1){ return ""; }
        String prev = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(prev)!=0){
                prev = prev.substring(0,prev.length()-1);
            }
        }
        return prev;
    }
}