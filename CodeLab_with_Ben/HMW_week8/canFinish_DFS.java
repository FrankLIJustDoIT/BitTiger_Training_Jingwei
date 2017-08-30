public class Solution {
    //we solve this problem by build a directed graph and see whether there
    //is a circle within it, is so, then it's impossible to finish all the
    //courses
    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] pair : prerequisites){
            graph.get(pair[1]).add(pair[0]);
        }//build graph
        
        //this array is for recording a path
        boolean[] visited = new boolean[numCourses];
        
        //every course could be the prerequist for other courses, we try them
        //one by one, if start from every course we can't find a circle, it means
        //we can finish all the courses
        //it may have multiple lists, but we are still capable of finishing all of them
        //anyway, as long as there's no circles
        for(int i = 0; i < numCourses; i++){
            if(findCircle(graph, visited, i)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean findCircle(List<List<Integer>> graph, boolean[] visited, int course){
        if(visited[course] == true){
            return true;
        }//base case, which means in this path this course has been visited, there's a circle
        //in other words
        
        //in DFS way
        visited[course] = true;
        for(int m : graph.get(course)){
            if(findCircle(graph, visited, m)){
                return true;
            }
        }
        visited[course] = false;
        
        return false;
    }
}