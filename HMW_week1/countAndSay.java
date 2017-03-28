public class Solution {
    public String countAndSay(int n) {
        if(n<=0){ return null; }
        StringBuilder sb = new StringBuilder("1");
        for(int m=2; m<=n; m++){
            int count=1;
            StringBuilder prev = sb;
            sb = new StringBuilder();
            char c = prev.charAt(0);
            for(int i=1; i<prev.length(); i++){
                if(c==prev.charAt(i)){ count++; }
                else{
                    sb.append(count).append(c);
                    count=1;
                    c=prev.charAt(i);
                }
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }
}