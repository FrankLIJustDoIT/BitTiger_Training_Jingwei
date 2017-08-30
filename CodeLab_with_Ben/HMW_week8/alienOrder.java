public class Solution {
    public String alienOrder(String[] words) {
        //here map is used to save the chars which we are sure that should
        //behind some key char
        Map<Character, Set<Character>> map = new HashMap<>();
        //here the degree is used to save the number of chars which we are 
        //sure that should be set in front of some key char
        Map<Character, Integer> degree = new HashMap<>();
        
        String res = "";
        if(words == null || words.length == 0){
            return res;
        }//corner case
        
        for(String s : words){
            for(char c : s.toCharArray()){
                degree.put(c,0);
            }
        }//at first we should figure out how many kinds of diffrent chars
        //in the words
        
        //from the first word to the final word, we compare them one by one
        //and for each comparing pair, we compare each corresponding chars
        //from head to tail, until one gets end
        for(int i = 0; i < words.length - 1; i++){
            String curr = words[i];
            String next = words[i + 1];
            int len = Math.min(curr.length(), next.length());
            for(int j = 0; j < len; j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                //if the two chars are same, obviously we see no comparing result
                //but when they are diffrent, then we know c1 should be superior than
                //c2, and based on this conclusion, we adjust map and degree
                if(c1 != c2){
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(c1)){
                        set = map.get(c1);
                    }
                    
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1,set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        Deque<Character> queue = new ArrayDeque<>();
        for(char c : degree.keySet()){
            //if a char has noting behind it surely, it means it should be put in 
            //the top part, so we directly add them in queue
            if(degree.get(c) == 0){
                queue.addLast(c);
            }
        }
        
        while(!queue.isEmpty()){
            char c = queue.removeFirst();
            res += c;//add to the res string
            if(map.containsKey(c)){
                for(char c2 : map.get(c)){
                    //everytime a pair of relation was found, we delete it from degree
                    //if degree.get(c2) == 0, it means no more chars should be put in
                    //front of c2, so it could be the next char to be added in res, so 
                    //we add it to the queue
                    degree.put(c2, degree.get(c2) - 1);
                    if(degree.get(c2) == 0){
                        queue.addLast(c2);
                    }
                }
            }
        }
        
        //if res.length() < degree.size(), it means there is some error happens, some char
        //which should be put in queue cannot do it, more than one relationship are found 
        //to one pair of chars
        return (res.length() < degree.size()) ? "" : res;
    }
}