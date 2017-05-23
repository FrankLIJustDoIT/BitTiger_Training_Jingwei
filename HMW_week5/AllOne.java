public class AllOne {
    private Map<String, Integer> map;
    private Map<String, Node> nodeMap;
    private Node head;
    private Node tail;

    /** Initialize your data structure here. */
    public AllOne() {
        this.map = new HashMap<>();
        this.nodeMap = new HashMap<>();
        this.head = new Node(0);
        this.tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!map.containsKey(key)){
            map.put(key, 1);
            moveToHead(key);
        }else{
            map.put(key, map.get(key) + 1);
            increaseCount(key);          
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            int cur = map.get(key);
            if(cur == 1){
                map.remove(key);
                Node node = nodeMap.get(key);
                node.keys.remove(key);
                nodeMap.remove(key);
                
                if(node.keys.size() == 0){
                    removeNode(node);
                }
            }else{
                map.put(key, cur - 1);
                decreaseCount(key);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey(){
        String str = "";
        if(tail.prev.count != head.count){
            for(String s : tail.prev.keys){
                str = s;
                break;
            }
        }
        return str;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        String str = "";
        if(head.next.count != tail.count){
            for(String s : head.next.keys){
                str = s;
                break;
            }
        }
        return str; 
    }
    
    private void moveToHead(String key){
        if(head.next.count == 1){
            head.next.keys.add(key);
        }else{
            
            Node node = new Node(1);
            node.keys.add(key);
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        
        nodeMap.put(key, head.next);
    }
    
    private void increaseCount(String key){
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        
        if(node.next == tail){
            //addNode(node);
            Node temp = new Node(node.count + 1);
            temp.keys.add(key);
            temp.prev = tail.prev;
            temp.next = tail;
            tail.prev = temp;
            temp.prev.next = temp;
        }else if(node.next.count == node.count + 1){
            node.next.keys.add(key);
        }else{
            Node temp = new Node(node.count + 1);
            temp.keys.add(key);
            temp.next = node.next;
            temp.prev = node;
            node.next = temp;
            temp.next.prev = temp;
            //addNode(node);
        }
        
        nodeMap.put(key,node.next);
        
        if(node.keys.size() == 0){
            removeNode(node);
        }
        
    }
    
    private void decreaseCount(String key){
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        
        if(node.prev == head){
            Node temp = new Node(node.count - 1);
            temp.next = head.next;
            temp.prev = head;
            head.next = temp;
            temp.next.prev = temp;
            temp.keys.add(key);
            
        }else if(node.count == node.prev.count + 1){
            node.prev.keys.add(key);
        }else{
            Node temp = new Node(node.count - 1);
            temp.keys.add(key);
            
            temp.prev = node.prev;
            temp.next = node;
            node.prev = temp;
            temp.prev.next = temp;
        }
        
        nodeMap.put(key, node.prev);
        
        if(node.keys.size() == 0){
            removeNode(node);
        }
    }
    
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    class Node{
        public int count;
        public List<String> keys;
        public Node prev;
        public Node next;
        public Node(int count){
            this.count = count;
            this.keys = new ArrayList<>();
            this.prev = null;
            this.next = null;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */