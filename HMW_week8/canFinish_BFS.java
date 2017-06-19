public class Solution {
    //we can also solve this problem by BFS idea, which means we count
    //all the courses which have no prerequisites and traverse each
    public boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }//corner case
        
        //the map is for saving all prerequsite pairs, in the way we can
        //access them in O(1) time
        int[][] map = new int[numCourses][numCourses];
        //the inDegree is for count the indegree of each course, some courses
        //may have more than one prerequsite(indegree)
        int[] inDegree = new int[numCourses];
        
        for(int[] pair : prerequisites){
            int cur = pair[0];
            int pre = pair[1];
            inDegree[cur]++;
            map[pre][cur] = 1;
        }
        
        //we first put all no-prerequisite courses in the queue
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.addLast(i);
            }
        }
        
        int count = 0;
        //traverse the graph from each no-indegree course
        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            count++;//every time we traverse a course, we count it
            
            //see if this course is the prerequisite of any courses
            for(int i = 0; i < numCourses; i++){
                if(map[cur][i] == 1){
                    //if so, we see if this course has just one indegree
                    //right now
                    inDegree[i]--;
                    if(inDegree[i] == 0){
                        //if so, add it to the tail of the queue
                        queue.addLast(i);
                    }
                }
            }
        }
        
        //if count != numCourses, it means there is a circle in the graph, because by this 
        //bfs strategy, every element in the circle cannot be traversed, the fact is every time we meet the circle-making
        //point, as it always has a indegree which from the circle which we cannot delete, we can't enter the circle, so
        //all the courses in the circle cannot be accessed.
        return count == numCourses;
    }
}