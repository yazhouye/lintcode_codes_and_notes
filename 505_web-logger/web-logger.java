/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/web-logger
@Language: Java
@Datetime: 16-08-21 05:42
*/

public class WebLogger 
{
    private LinkedList<Integer> hits;
    public WebLogger() 
    {
        hits = new LinkedList<Integer>();
    }

    public void hit(int timestamp) 
    {
        hits.add(timestamp);
    }

    public int get_hit_count_in_last_5_minutes(int timestamp) 
    {
        while(hits.size()!=0 && hits.getFirst()<=timestamp-300)
        {
            hits.removeFirst();
        }
        return hits.size();
    }
}