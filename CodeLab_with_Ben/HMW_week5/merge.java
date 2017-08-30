/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    class MyComparator implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            return i1.start - i2.start;
        }
    }//we firstly make a rule to sort the input list, according to the 
    //value of start, in increasing order
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        
        if(intervals == null || intervals.size() == 0){
            return list;
        }//corner case
        
        Collections.sort(intervals, new MyComparator());
        //sort the intervals
        
        int beg = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i = 0; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            //traverse the list
            
            if(cur.start <= end){
                //which means we can merge this interval into the interval before
                //this interval may totally in the interval before or partly intersect
                //with the previous interval
                //in traversing, if new interval keep intersect with previous, we keep
                //merge them
                end = Math.max(end, cur.end);
            }else{
                //if this interval cannot be merged into previous one, we save the previous
                //interval in the result list and start a new merging
                list.add(new Interval(beg, end));
                beg = cur.start;
                end = cur.end;
            }
        }
        
        //when all initial intervals in the intervals have been traversed, we save the last 
        //new interval inthe result list and then return
        list.add(new Interval(beg, end));
        
        return list;
    }
}