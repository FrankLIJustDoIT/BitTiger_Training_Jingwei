public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, res, 0, 0, new char[]{'(', ')'});
        
        return res;
    }
    
    //with the helper(), we are gonna solving this problem by dfs, in each recursion level, 
    //we try to find all possible position where we can get rid off the corresponding char
    //to make the s.substring(last_i, i) have valid parentheses
    private void helper(String s, List<String> res, int last_i, int last_j, char[] pair){
        for(int i = last_i, stack = 0; i < s.length(); i++){
            if(s.charAt(i) == pair[0]){
                stack++;
            }
            if(s.charAt(i) == pair[1]){
                stack--;
            }
            
            if(stack >= 0){
                continue;
            }//once stack < 0, it means we find out one redundant ')', so in s.substring(last_i, i+1),
            //we rip off any ')' can make this part be parentheses valid, 
            
            for(int j = last_j; j <= i; j++){
                //because in a series of consecutive ')', we rip off any one get the same result, so
                //we restrict to remove only the first ')'
                if(s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])){
                    //now from 0 to i, we got a good one and we continue to solve the remain substring
                    //we record the last removal pos because if we always start from begin in deeper recursion
                    //level to find the pos to rip off element, we got a risk to rip one element for multiple 
                    //times and so that cause duplicate element, for example : ()k))), obviously the i will be 3,
                    //the first time we remove the first ')', get (k))), j=1 and i=3, and then we get (k)) and 
                    //we finally get (k), return back, same procedure, we get ()k,
                    //however if we don't have a j, when we got a (k) and return back to try another removal pos, 
                    //which should be the next ')', just where ths i is, we get ()k)), now i=3 but we still start
                    //from '(', so again we remove the first ')' and get (k)), so we finally get another (k), so
                    //a duplicate happend, that is the reason why we only remove the elements after the last removal
                    //position
                    helper(s.substring(0, j) + s.substring(j + 1), res, i, j, pair);
                }
            }
            
            //because we do recursion to solve the remain invalid problems, so by now ,all things finished, we just return
            return;
        }
        
        //reach here means no problem was found in this substring, or the last removal pos is s.length() - 1, so in this 
        //recursion level we don't even go into the for cycle, anyway, no invalid ')' now, but there still be invalid '('
        //the way we solve it is by reverse the string and do a helper() again, because in this way, the valid '(' should 
        //after the valid ')', so we can reuse or code.
        String reverse = new StringBuilder(s).reverse().toString();
        
        if(pair[0] == '('){
            //which means we haven't test '(', we need to do it
            helper(reverse, res, 0, 0, new char[]{')', '('});
        }else{
            //pair[0] == ')', it means we already test '(', the reversed one now is just our final result
            res.add(reverse);
        }
    }
}