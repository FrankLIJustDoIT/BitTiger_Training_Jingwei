public class LoadLimit{
    
    //cArray is used to save the timestamp of hit, we use it as a circular
    //array so that we can limit the number of hits 
    private int[] cArray;
    private int beg;//beg points to the timestamp of the least recent used hit
    private int end;//end points to the next position of the most recent used hit
    boolean isFull;//determine if the circular array is already full
    private int timeLimit;
    private int hitLimit;
    
    public LoadLimit(int timeLimit, int hitLimit){//initialization
        this.cArray = new int[hitLimit];//the length of cArray is hitLimit, is saves timestamps
        this.hitLimit = hitLimit;
        this.timeLimit = timeLimit;
        this.beg = 0;
        this.end = 0;
    }
    
    public boolean hit(int timestamp){
        if(isFull){
            //now beg == end
            int begTime = cArray[beg];//get the time of first hit in the time limit
            if(timestamp - begTime >= timeLimit){
                //if already beyond time limit, we just modify the first hit by the
                //most recent one and move pointers beg and end, still full now
                cArray[end] = token;
                end = (end + 1) % hitLimit;
                beg = end;
                isFull = true;
                return true;
            }else{
                //if still within the time limit but hit is already full, it means
                //there are too many hits in the time limit, we can't hit any more
                //so return false
                return false;
            }
        }else{
            //if not full, things are easy, we just put the recent hit in the end pos
            //and move end pointer to the next position
            if(beg == end){//empty
                cArray[end] = token;
                end = (end + 1) % hitLimit;
            }else{
                cArray[end] = token;
                end = (end + 1) % hitLimit;
                if(begin == end){//if now full
                    isFull = true;
                }
            }
            return true;
        }
    }
    
    public boolean digest(){
        if(isFull){
            //if already full, we just digest the first hit and move beg one step
            //forward because the next hit is now the first hit in this time limit
            cArray[beg] = null;
            beg = (beg + 1) % hitLimit;
            isFull = false;//now it's not full
            return true;
        }else{
            if(beg == end){//if empty, nothing to digest
                return false;
            }else{//if not full, just move 
                cArray[beg] == null;
                beg = (beg + 1) % hitLimit;
            }
        }
    }
}