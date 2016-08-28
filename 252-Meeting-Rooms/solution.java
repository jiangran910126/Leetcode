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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length==0) return true;
        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                return a.start-b.start;
            }
        });
        int start=intervals[0].start,end=intervals[0].end;
        for(int i=1;i<intervals.length;i++){
            int tmps=intervals[i].start,tmpe=intervals[i].end;
            if(end>tmps) return false;
            start=tmps;
            end=tmpe;
        }
        return true;
    }
}