public class Solution {
    class Node{
        char val;
        int counter;
        
        public Node(char val){
            this.val = val;
            this.counter = 0;
        }//bind character and frequency together
    }
    public String frequencySort(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        Map<Character, Node> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            Node node = map.getOrDefault(c, new Node(c));
            node.counter++;
            map.put(c, node);
        }//count the frequency of each char
        
        List<Node> list = new ArrayList<>(map.values());
        
        Collections.sort(list, (l, r) ->{
            return r.counter - l.counter;
        });//then do sorting on it in descending order
        
        StringBuilder sb = new StringBuilder();
        
        for(Node cur : list){
            for(int i = 0; i < cur.counter; i++){
                sb.append(cur.val);
            }
        }
        
        return sb.toString();
    }
}