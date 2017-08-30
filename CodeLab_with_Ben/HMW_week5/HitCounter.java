public class HitCounter{
    //times[i] means the value of timestamp within the 5 min which %300 = i
    private int[] times;
    //hits[i] means the number of hits received in times[i];
    private int[] hits;
    public HitCounter(){
        //because we just concern about the time within 5 min 
        //so we just need a 300 length arrray
        times = new int[300];
        hits = new int[300];
    }  
    
    public void hit(int timestamp){
        int index = timestamp % 300;
        //!= means times[i] is just beyond the 5 min limit, so we drop it 
        //and replace this position with the new hit
        if(times[index] != timestamp){
            times[index] = timestamp;
            hits[index] = 1;
        }else{
            //== means this hit is still within the 5 min limit so it means
            //multi-hit in the same time so we just need to ++;
            hits[index]++;
        }
    }
    
    public int getHits(int timestamp){
        int total = 0;
        //traverse through the whole hits[]
        for(int i = 0; i < 300; i++){
            //<300 meanst hits[i] is within the 5 min limit, so we can add
            //hits[i] to the total count
            if(timestamp - times[i] < 300){
                total += hits[i];
            }
        }
        
        return total;
    }
}