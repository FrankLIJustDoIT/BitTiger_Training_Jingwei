public class Solution {
    //this is a union-find solution
    public boolean validTree_UnionFind(int n, int[][] edges) {
        int[] parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }//initialize the parent array
        
        for(int i = 0; i < edges.length; i++){
            //find the parents of both elements of a connection
            int parentX = find(parents, edges[i][0]);
            int parentY = find(parents, edges[i][1]);
            
            if(parentX == parentY){
                return false;
            }//this two elements have a connection between and they have same parent
            //this means there is a circle because we initialize parents[i] = i, and
            //if find() return not i, it means their is already a link from the parent 
            //to this node, however these two nodes are linked and have same parent 
            //means there is another link to the parent, so a circle is found
            
            parents[parentX] = parentY;
            //if they have diffrent parent now, as they are connected, we union their parent
        }
        
        //if no circle was found and all the nodes are connected together with no seperate part
        //this is a tree we are for sure
        return edges.length == n - 1;
    }
    private int find(int[] parents, int i){
        while(parents[i] != i){
            parents[i] = parents[parents[i]];
            i = parents[i];
        }// it is finding the (temp) root
        
        return i;
    }
}