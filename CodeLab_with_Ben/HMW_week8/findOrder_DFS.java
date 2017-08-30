public class Solution {
    private int index;
    public int[] findOrder_DFS(int numCourses, int[][] prerequisites) {
        //the global variable index is used for put the course
        //into the result array, because the dfs will end at the course
        //which isn't prerequisit of any other course, so this kind of 
        //course should be put in the last pos of result, and bottom-up
        //we settle each course
        this.index = numCourses - 1;
        
        int[] result = new int[numCourses];
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] pair : prerequisites){
            graph.get(pair[1]).add(pair[0]);
        }//in the same way we build the graph
        
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(findCircle(graph, visited, result, i)){
                return new int[0];
            }
        }
        
        return result;
    }
    
    private boolean findCircle(List<List<Integer>> graph, int[] visited, int[] result, int course){
        if(visited[course] == -1){
            return true;
        }
        
        if(visited[course] == 1){
            return false;
        }
        
        visited[course] = -1;//mark -1 as this course has been visited but not added into the result yet
        for(int next : graph.get(course)){
            if(findCircle(graph, visited, result, next)){
                return true;
            }
        }
        visited[course] = 1;//mark 1 as this course has been added into the result, so next we meet this 
        //course, we know this path works, so just return false anyway
        result[index--] = course;//add the course into the result array
        
        return false;
    }
}