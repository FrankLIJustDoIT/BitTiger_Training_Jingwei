public class LRUCache {
    //LRU cache
    //to solve this problem, we design a double linkedList, with attribute
    //key and value, with double linkedlist, we can add, remove element
    //in O(1) time
    //the node which is called most recently will be reset in the first 
    //postion(after head) in the list
    class Node{
        Node next;
        Node pre;
        int val;
        int key;
        
        //the reason why we need a key in the Node structure is that 
        //through key we can delete a node in O(1) time
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.pre = null;
        }
    }
    
    //the key of a node is the key in the map and the node itself is the value 
    //in the map, so that we can access or add a node which has key and value 
    //in O(1) time
    private Map<Integer, Node> map;
    private Node head;//dummy head
    private Node tail;//dummy tail, for the use of O(1) time add or remove
    private int capacity;
    
    public LRUCache(int capacity){//initialization
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;//link the tail with head
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }//not found
        
        //because this node is just called,so we draw it out and reset it
        //just behind the dummy head
        Node node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        
        moveToHead(node);
        
        return node.val;
    }

    public void moveToHead(Node node){
        node.pre = this.head;//make the new link
        node.next = this.head.next;
        
        this.head.next = node;
        node.next.pre = node;
    }
    
    public void put(int key, int value){
        if(get(key) != -1){//call the get() function
            map.get(key).val = value;
            return;
        }//if the node(key) already exist, we just move the node to the head and
        //reset its value
        
        if(map.size() == this.capacity){
            map.remove(tail.pre.key);
            tail = tail.pre;
            tail.next = null;
            
            tail.key = -1;
            tail.val = -1;
        }//if we already reached the capacity and have to add a new node, we just
        //remove the tail node because this one must be the least recent called
        
        Node newNode = new Node(key,value);//add new node and locate it at the head
        map.put(key,newNode);
        moveToHead(newNode);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */