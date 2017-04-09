/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/rate-limiter
@Language: Java
@Datetime: 16-08-21 05:52
*/

public class RateLimiter 
{
    //applicable for unsorted timestamp
    /*
    private HashMap<String, HashMap<Integer, Integer>> map = new HashMap<String, HashMap<Integer, Integer>>();
    
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment)
    {
        if(!map.containsKey(event))
        {
            map.put(event, new HashMap<Integer, Integer>());
        }
        HashMap<Integer, Integer> subMap = map.get(event);
        
        if(!subMap.containsKey(timestamp))
        {
            subMap.put(timestamp, 0);
        }
        
        int second = 0;
        switch(rate.split("/")[1])
        {
            case "s":
                second = 1;
                break;
            case "m":
                second = 1 * 60;
                break;
            case "h":
                second = 1 * 60 * 60;
                break;
            case "d":
                second = 1 * 60 * 60 * 24;
                break;
        }
        
        int counter = 0;
        int limit = Integer.parseInt(rate.split("/")[0]);
        for(int i=timestamp; i>timestamp-second && i>0; i--)
        {
            if(subMap.containsKey(i))
            {
                counter += subMap.get(i);   
            }
            if(counter>=limit)
            {
                return true;
            }
        }
        
        if(increment)
        {
            subMap.put(timestamp, subMap.get(timestamp)+1);
        }
        
        return false;
    }
    */
    
    //applicable for non-descending timestamp
    private HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment)
    {
        int second = 1;
        switch(rate.split("/")[1])
        {
            case "m":
                second = 1 * 60;
                break;
            case "h":
                second = 1 * 60 * 60;
                break;
            case "d":
                second = 1 * 60 * 60 * 24;
                break;
        }
        int firstTimestamp = timestamp - second + 1;
        
        int limit = Integer.parseInt(rate.split("/")[0]);
        
        if(!map.containsKey(event))
        {
            map.put(event, new ArrayList<Integer>());
        }
        
        boolean result = checkTimes(map.get(event), firstTimestamp) >= limit;
        
        if(increment && !result)
        {
            map.get(event).add(timestamp);
        }
        
        return result;
    }
    
    private int checkTimes(List<Integer> timestampList, int firstTimestamp)
    {
        int left = 0;
        int right = timestampList.size()-1;

        while(left<=right)
        {
            int mid = (left+right)/2;
            if(timestampList.get(mid)>=firstTimestamp)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        
        return timestampList.size()-1-left+1;
    }
}