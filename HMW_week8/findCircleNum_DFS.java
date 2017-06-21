public class Solution {
    public int findCircleNum_DFS(int[][] M) {
        int len = M.length;
        int count = 0;
        //isVisited is used for recording whether a student has been taken
        //into consideration
        boolean[] isVisited = new boolean[len];
        
        for(int student = 0; student < len; student++){
            //have a look at each student, if one has already be looked when we were
            //looking at some other student, then we jumped this guy
            if(!isVisited[student]){
                dfsHelper(M, isVisited, student);
                //everytime we finish a looking, it means a circle has been recongnized
                count++;
            }
        }
        
        return count;
    }
    
    private void dfsHelper(int[][] M, boolean[] isVisited, int studentI){
        //for a student, we traverse all other student and see who has a friendship with 
        //this guy, once we find one out, we then turn to look for this student's friends
        for(int studentJ = 0; studentJ < M.length; studentJ++){
            if(M[studentI][studentJ] == 1 && !isVisited[studentJ]){
                isVisited[studentJ] = true;
                dfsHelper(M, isVisited, studentJ);
            }
        }
    }
}