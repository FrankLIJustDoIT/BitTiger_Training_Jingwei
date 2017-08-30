public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, new String(), 0);
        
        return res;
    }
    //each time we run helper(), we are determining which parenthesis, ( or )
    //should be added to the str so far
    private void helper(List<String> list, int n, String str, int counter){
        if(str.length() == 2 * n && counter == 0){
            list.add(new String(str));
            return;
        }//in this condition, we have successfully get a permutation of ( )
        //so we add it to the list
        
        if(counter < 0 || counter > n || str.length() > 2 * n){
            return;
        }//corner case
        
        if(counter > 0 && counter < n){
            //in this condition, there is still at least 1 single ( left in the
            //str, so there's no matter we add ( or ), 
            helper(list, n, str + "(", counter + 1);
            helper(list, n, str + ")", counter - 1);
        }else if(counter == 0){
            //now there's nothing or just paired () in the list, so we can just
            //add ( in the str
            helper(list, n, str + "(", counter + 1);
        }else if(counter == n){
            //this condition we put all ( in the str before any  ) be put into, so
            //we can only add ) in it
            helper(list, n, str + ")", counter - 1);
        }
        
        return;
    }
}