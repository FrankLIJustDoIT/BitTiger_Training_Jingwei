public class LFUCache {
    private Node head = null;
    private int cap = 0;
    //value hashmap is for saving the key and value so we 
    //can access the value by key in O(1) time
    private HashMap<Integer, Integer> valueHash = null;
    //node hash is for saving the key and node, so we can
    //access the node we set in O(1) time, then by using
    //the node we can do other operation
    private HashMap<Integer, Node> nodeHash = null;
    
    public LFUCache(int capacity) {
        this.cap = capacity;//initialization
        valueHash = new HashMap<Integer, Integer>();
        nodeHash = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (valueHash.containsKey(key)) {
        //if the key is already in the map, we just increase its
        //frequence and return its value
            increaseCount(key);
            return valueHash.get(key);
        }
        //otherwise we return -1
        return -1;
    }
    
    public void put(int key, int value) {
        if(cap == 0){
            return;
        }//base case
        if (valueHash.containsKey(key)) {
            //if the key is already in the map, we just renew its
            //new value
            valueHash.put(key, value);
        } else {
            //otherwise if we still have space,we can add it to value
            //map first
            if (valueHash.size() < cap) {
                valueHash.put(key, value);
            } else {
                //if we have no enough space, we just remove a LFU one
                //first and then we get space and the new key can be put
                //into it
                removeOld();
                valueHash.put(key, value);
            }
            //as long as it's a new key, we need to new a new head for this
            //key so it can be added into the double linkedlist system for
            //maintaining
            addToHead(key);
        }
        //as long as put() was invoked, we need to increase the key's 
        //frequence
        increaseCount(key);
    }
    
    private void addToHead(int key) {
        if (head == null) {
            //head==null means there's no key in the cache,so when we need
            //to add one, we are about to establish the double linked list 
            //system, in this step, we mark the key's frequence with 0
            head = new Node(0);
            head.keys.add(key);
        } else{
            //this situation means when we try to put in a key, there is 
            //already at least 1 value in the cache,we have head node
            //in this condition we still need a new node as the new key
            //is about to input, and because it's a new node, it must have
            //the lowest frequency, so we set is as the head node first anyway
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        }//put the new key in the nodehash map
        nodeHash.put(key, head);      
    }
    
    //increaseCount() is for increase the frequency of a value
    //in the cache, which is actually implemented by adjusting the
    //the node in the linkedlist
    private void increaseCount(int key) {
        //get the node from node map
        Node node = nodeHash.get(key);
        //now that we are gonna adjust the key's position in the
        //linkedlist, we at first delete its original position
        node.keys.remove(key);
        
        if (node.next == null) {
            //node.next==null means this node is currently already
            //one of the most frequent nodes,so now it's gonna become
            //the only most frequent one, so we new a new node with
            //count++, and link it as the new tail node
            node.next = new Node(node.count+1);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if (node.next.count == node.count+1) {
            //if there is already some node in the cache which have one more
            //frequency in the list, then we don't need bother to new a new 
            //node, we just add the key in the keys of node.next
            node.next.keys.add(key);
        } else {
            //if there is a gap between this node and next node
            //then we have to new a new node otherwise
            //we have no where to locate the key
            //we new a node with count+1 and link it between
            Node tmp = new Node(node.count+1);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }

        nodeHash.put(key, node.next);//add or renew the key in the node map
        //if the original node has a 0 size keys, this means there is currently
        //no node in the cache with this frequency, so we have no reason to
        //preserve it, we can just remove it
        if (node.keys.size() == 0) remove(node);
    }
    
    private void removeOld() {
        if (head == null){
            return;
        }
        int old = 0;
        //the LFU one must be in the keys of head node
        //this is just O(1) time, because keys is implemented by linkedhashset
        //so when we traverse elements in the keys, it is in the same order with
        //its input order, so we can realize that if more than one value have LFU，
        //we delete the LRU one, because the LRU one must be the one input most
        //early into the head node
        for (int n: head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) remove(head);
        nodeHash.remove(old);//delete it totally
        valueHash.remove(old);
    }
    
    private void remove(Node node) {
        if (node.prev == null) {
            //if the node is head node, we just make the next node the new 
            //head node
            head = node.next;
        } else {
            //otherwise we relink the pre
            node.prev.next = node.next;
        } 
        if (node.next != null) {
            //if the node is not the tail node,we relink the next
            node.next.prev = node.prev;
        }
    }
    
    class Node {
        public int count = 0;
        //the keys is for save the frequent of each key
        //in each node,keys with the same count are saved using linked
        //hashset, this can keep the input order
        public LinkedHashSet<Integer> keys = null;
        public Node prev = null, next = null;
        
        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<Integer>();
            prev = next = null;
        }
    }
 
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */