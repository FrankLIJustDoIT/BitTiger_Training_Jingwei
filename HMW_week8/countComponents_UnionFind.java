public class Solution {
    public int countComponents_UnionFind(int n, int[][] edges) {
        int[] parent = new int[n];
        int counter = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int[] pair: edges){
            int parentX = find(parent, pair[0]);
            int parentY = find(parent, pair[1]);
            
            if(parentX == parentY){
                continue;
            }//which means they are already marked in one component
            
            parent[parentX] = parentY;//union them in one component
            counter--;//it eaquals we delete a connection
        }
        
        return counter;
    }
    private int find(int[] parent, int i){
        while(parent[i] != i){
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        
        return i;
    }
}