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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new ArrayList<>();
        if(intervals.size()==0) return res;
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                if(a.start!=b.start) return a.start-b.start;
                return a.end-b.end;
            }
        });
        int start=intervals.get(0).start,end=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            int tmps=intervals.get(i).start;
            int tmpe=intervals.get(i).end;
            if(tmps<=end&&tmpe>end){
                end=tmpe;
            }
            else if(tmps>end){
                res.add(new Interval(start,end));
                start=tmps;
                end=tmpe;
            }
        }
        res.add(new Interval(start,end));
        return res;
    }
}