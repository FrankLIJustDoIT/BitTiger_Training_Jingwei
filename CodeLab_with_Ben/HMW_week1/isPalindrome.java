public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()<1){ return true; }
        int m = 0;
        int n = s.length()-1;
        while(m<n){
            if(!Character.isLetterOrDigit(s.charAt(m))){ m++; }
            else if(!Character.isLetterOrDigit(s.charAt(n))){ n--; }
            else{
                if(Character.toLowerCase(s.charAt(m))!=Character.toLowerCase(s.charAt(n))){
                    return false;
                }
                m++;
                n--;
            }
        }
        return true;
    }
}