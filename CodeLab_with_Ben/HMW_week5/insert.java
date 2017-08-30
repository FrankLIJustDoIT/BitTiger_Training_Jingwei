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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null){
            return intervals;
        }//corner case
        
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }//corner case;
        
        int beg = newInterval.start;
        int end = newInterval.end;
        int mark = 0;//used to mark the position we locate the start
        //and end point of newInterval
        
        //traverse through the intervals
        for(int i = 0; i < intervals.size(); i++){
            Interval curInter = intervals.get(i);//get the current interval
            if(newInterval.start > curInter.end){
            //which means this interval can't be merged so we add it to res directly
                res.add(curInter);
                if(i == intervals.size() - 1){
                    res.add(newInterval);
                    return res;
                }
                continue;
            }
            //which means this interval should be merged, we need to determine
            //the start point of the incoming new interval
            beg = Math.min(newInterval.start, curInter.start);
            mark = i;//mark the start position
            break;
        }
        
        //continue traversing
        for(int i = mark; i < intervals.size(); i++){
            Interval curInter = intervals.get(i);
            
            if(newInterval.end > curInter.end){
                //which means this interval is totally in the new merged interval
                if(i == intervals.size() - 1){
                    res.add(new Interval(beg, end));
                    return res;
                }
                continue;
            }else{
                if(newInterval.end < curInter.start){
                    //which means this interval is just after the last interval which 
                    //should be merged
                    end = newInterval.end;
                    mark = i;
                }else{
                    //which means this interval is just the last interval which should
                    //be merged
                    end = curInter.end;
                    mark = i + 1;
                }
                //make the new merged interval and add it to the res
                res.add(new Interval(beg, end));
                break;
            }
        }
        
        //continue traversing if necessary and these remain intervals is beyond
        //the merging area and we add them into the res directly
        for(int i = mark; i < intervals.size(); i++){
            res.add(intervals.get(i));
        }
        
        return res;
    }
}