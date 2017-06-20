public class Solution {
    public boolean validTree_BFS_2(int n, int[][] edges) {
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
        
        //0 is not visited, 1 is is queue, -1 is out queue
        int[] isVisited = new int[n];
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.addLast(0);
        isVisited[0] = 1;
        
        while(!queue.isEmpty()){
            int curNode = queue.removeFirst();
            
            for(int nextNode : graph.get(curNode)){
                if(isVisited[nextNode] == 1){
                    return false;
                }
                
                if(isVisited[nextNode] == -1){
                    continue;
                }
                queue.addLast(nextNode);
                isVisited[nextNode] = 1;
            }
            isVisited[curNode] = -1;
        }
        
        for(int m : isVisited){
            if(m == 0){
                return false;
            }
        }
        
        return true;
    }
}