public class Solution {
    public int countComponents_DFS(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pair : edges){
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }
        
        boolean[] isVisited = new boolean[n];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                //for one valid node, we just exhausted all the nodes which connected
                //directly or through other nodes with it, they are one component
                helper(graph, isVisited, i);
                count++;
            }
        }
        
        return count;
    }
    private void helper(List<List<Integer>> graph, boolean[] isVisited, int curNode){
        for(int nextNode : graph.get(curNode)){
            if(!isVisited[nextNode]){
                //keep exhausting
                isVisited[nextNode] = true;
                helper(graph, isVisited, nextNode);
            }
        }
    }
}