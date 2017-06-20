public class Solution {
    public boolean validTree_DFS(int n, int[][] edges)  {
        if(n < 0){
            return false;
        }//corner case
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pair : edges){
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }//here we build a graph, because it's a undirected graph, so we just save each connection
        //from both sides
        
        boolean[] isVisited = new boolean[n];
        //use for recording the nodes we have visited
        
        //because it's a undirected graph, so we can just start from any point in the graph, and if
        //any circle is founded out, it means this is not tree
        if(findCircle(graph, isVisited, 0, -1)){
            return false;
        }
        
        //maybe there are multiple parts in the graph which are disconnected from each other, in this
        //condition it is still not a tree
        for(boolean m : isVisited){
            if(!m){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean findCircle(List<List<Integer>> graph, boolean[] isVisited, int curNode, int preNode){
        if(isVisited[curNode]){
            return true;
        }
        
        isVisited[curNode] = true;
        for(int nextNode : graph.get(curNode)){
            if(nextNode == preNode){
                continue;
            }//jump the pre node is necessary, as we saved both sides of a connection
            
            if(findCircle(graph, isVisited, nextNode, curNode)){
                return true;
            }
        }
        //here we don't need to mark the isVisited back to false again because here we are finding a tree
        
        return false;
    }
}