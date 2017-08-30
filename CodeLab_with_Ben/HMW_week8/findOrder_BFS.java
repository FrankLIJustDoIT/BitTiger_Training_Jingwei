public class Solution {
    public int[] findOrder_BFS(int numCourses, int[][] prerequisites) {
        int[][] map = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        
        for(int[] pair : prerequisites){
            int cur = pair[0];
            int pre = pair[1];
            inDegree[cur]++;
            map[pre][cur] = 1;
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.addLast(i);
            }
        }
        
        int[] res = new int[numCourses];
        int count = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            res[count++] = cur;
            
            for(int i = 0; i < numCourses; i++){
                if(map[cur][i] == 1){
                    inDegree[i]--;
                    if(inDegree[i] == 0){
                        queue.addLast(i);
                    }
                }
            }
        }
        
        return count == numCourses ? (res) : (new int[0]);
        
    }
}