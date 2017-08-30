public class Solution {
    public boolean validTree_BFS(int n, int[][] edges) {
        if(n < 0){
            return false;
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pair : edges){
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }
        
        boolean[] isVisited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.addLast(0);
        
        while(!queue.isEmpty()){
            int curNode = queue.removeFirst();
            if(isVisited[curNode]){
                return false;
            }
            
            isVisited[curNode] = true;
            for(int nextNode : graph.get(curNode)){
                if(isVisited[nextNode]){
                    continue;
                }
                queue.addLast(nextNode);
            }
        }
        
        for(boolean m : isVisited){
            if(!m){
                return false;
            }
        }
        
        return true;
    }
}