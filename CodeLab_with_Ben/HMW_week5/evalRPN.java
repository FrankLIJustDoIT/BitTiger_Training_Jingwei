public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }//corner case
        
        //we maka a stack here for computing so that the two integers which locate 
        //closest before the operator could be easily output for computing
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        //we traverse through the tokens from head to tail, if we meet an integer we 
        //put it in the stack, if we meet an operator, we output the peek two integer
        //in the stack for computing and save the result in the stack
        for(String s : tokens){
            switch(s){
                case "+" :
                    stack.addFirst(stack.removeFirst() + stack.removeFirst());
                    break;
                case "-" :
                    stack.addFirst(-stack.removeFirst() + stack.removeFirst());
                    break;
                case "*" :
                    stack.addFirst(stack.removeFirst() * stack.removeFirst());
                    break;
                case "/" :
                    int temp = stack.removeFirst();
                    stack.addFirst(stack.removeFirst() / temp);
                    break;
                default:
                    stack.addFirst(Integer.parseInt(s));
                    
            }
        }
        
        //now there is only one element in the stack and that is just our final result
        //of the reverse polish notation
        return stack.removeFirst();
    }
}