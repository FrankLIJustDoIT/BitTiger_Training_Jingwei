public class Solution {
    public String decodeString(String s) {
        if(s==null){
            return "";
        }//corner case
        
        char[] sChar = s.toCharArray();
        
        String res = helper(sChar,new StringBuilder(),0,sChar.length);
        return res;
    }
    //decoding the string in the same level
    private String helper(char[] sChar, StringBuilder sb, int start, int end){
        if(start>=end){
            return "";
        }//base case
        
        int mark = 0;//mark the start position of a "[" in this level
        int count = 0;//repeat times
        //stack is to determine wether a pair of [] belong to this level
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=start; i<end; i++){
            if(sChar[i]=='['){
                stack.addFirst(sChar[i]);
                if(mark==0){
                    mark = i;
                }
            }else if(sChar[i]==']'){
                stack.removeFirst();
                if(stack.isEmpty()){
                    //get a pair of [] in this level, do recursion within it
                    //for a deeper level
                    String s = helper(sChar,new StringBuilder(),mark+1,i);
                    for(int j=1; j<=count; j++){
                        sb.append(s);
                    }
                    mark = 0;
                    count = 0;
                }
            }else{
                if(!stack.isEmpty()){
                    continue;
                }//do not care about content in deeper level
                if(sChar[i]>='0' && sChar[i]<='9'){
                    count = 10*count + Character.getNumericValue(sChar[i]);
                }else{
                    sb.append(sChar[i]);
                }
            }
        }
        
        return sb.toString();
    }
}