//a demo of my 刷题 record

import java.util.*;

public class RandomizedCollection {
    private Random rand = new Random();//initialize a random function
    //use priorityQueue because it can defautly maintain an increasing
    //order, so when we save the list index in the PQ, the biggest one
    //is always in the tail.
    Map<Integer, PriorityQueue<Integer>> valueMap;
    //this list is to maintain all the value togeter, so we can randomly
    //access any one of is in O(1) time
    List<Integer> list;
    private int count;

    /** Initialize your data structure here. */
    public RandomizedCollection() {//initialization
        this.valueMap = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isContain = valueMap.containsKey(val);
        if(!isContain){//if this value is not in the map, we make a new one
            valueMap.put(val, new PriorityQueue<Integer>());
        }
        //add the value in the list and map
        valueMap.get(val).offer(list.size());
        list.add(val);
        
        return !isContain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!valueMap.containsKey(val)){
            return false;
        }
        
        //when we get a value to delete, among all the element in the list who have this value
        //we always delete the one which locates firstly,by calling poll() we achieve it
        int aimIndex = valueMap.get(val).poll();
        //when we get the index of the first one, we delete this one in the list by copying the
        //last element in this list in this position and delete the last element
        //if the object element is already the last one, we just remove it derectly from both
        //list and map
        if(aimIndex < list.size() - 1){
            int tailValue = list.get(list.size() - 1);
            list.set(aimIndex, tailValue);
            //if it's not the last element, as we adjust the pos the original last element, we
            //have to renew the map, we delete the tail value in the PQ which must be the last 
            //pos in the list and add the new pos by offer(), as it's a PQ, it will maintain the
            //increasing order
            valueMap.get(tailValue).remove(list.size() - 1);
            valueMap.get(tailValue).offer(aimIndex);
        }
        
        //remove the originally last element
        list.remove(list.size() - 1);
        
        if(valueMap.get(val).size() == 0){
            valueMap.remove(val);
        }//if there is no longer this value in the cache, we just remove it from map
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if(list.size() == 0){
            return -1;
        }
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
