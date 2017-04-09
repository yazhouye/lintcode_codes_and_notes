/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/merge-intervals
@Language: Java
@Datetime: 16-08-11 00:28
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution 
{
    public List<Interval> merge(List<Interval> intervals) 
    {
        if (intervals == null || intervals.size() <= 1) 
        {
            return intervals;
        }
        
        Collections.sort(intervals, intervalComparator);
        
        List<Interval> result = new ArrayList<Interval>();
        
        int rangeStart=intervals.get(0).start;
        int rangeEnd=intervals.get(0).end;
        
        for(int i=1; i<intervals.size(); i++)
        {
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;
            if(currentStart<=rangeEnd)
            {
                rangeEnd = Math.max(rangeEnd, currentEnd);
            }
            else
            {
                result.add(new Interval(rangeStart, rangeEnd));
                rangeStart = currentStart;
                rangeEnd = currentEnd;
            }
        }
        result.add(new Interval(rangeStart, rangeEnd));
        return result;
    }

    private Comparator<Interval> intervalComparator = new Comparator<Interval>()
    {
        @Override
        public int compare(Interval i1, Interval i2)
        {
            return i1.start-i2.start;
        }
    };
}