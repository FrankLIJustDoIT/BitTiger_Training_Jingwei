public class Solution {
    //in this solution, we solve the problem by DFS
    public List<Integer> diffWaysToCompute_DFS(String input) {
        List<Integer> res = new ArrayList<>();
        
        if(input == null || input.length() == 0){
            return res;
        }//corner case, which is also the base case when recursion
        
        if(isDigit(input)){
            res.add(Integer.parseInt(input));
            return res;
        }//if the input string is formed all by digits, we don't need to do any computation
        //but just return it
        
        for(int i = 0; i < input.length(); i++){
            char curr = input.charAt(i);
            if(Character.isDigit(curr)){
                continue;
            }//we keep finding operators from head to tail, once we find one, we do recursion 
            //to find all possible results in both sides of this current operator
            
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            
            if(curr == '+'){
                for(int l : left){
                    for(int r : right){
                        res.add(l + r);
                    }
                }
            }//try every possible pair and save all the possible results in res
            
            if(curr == '-'){
                for(int l : left){
                    for(int r : right){
                        res.add(l - r);
                    }
                }
            }
            
            if(curr == '*'){
                for(int l : left){
                    for(int r : right){
                        res.add(l * r);
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean isDigit(String input){
        return input.matches("[0-9]+");
    }
}