public class Solution {
    public int countComponents_BFS(int n, int[][] edges) {
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
                count++;
                Deque<Integer> queue = new ArrayDeque<>();
                queue.addLast(i);
                
                while(!queue.isEmpty()){
                    int curNode = queue.removeFirst();
                    isVisited[curNode] = true;
                    
                    for(int next : graph.get(curNode)){
                        if(!isVisited[next]){
                            queue.addLast(next);
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
}