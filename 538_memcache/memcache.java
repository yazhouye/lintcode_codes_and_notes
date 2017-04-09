/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/memcache
@Language: Java
@Datetime: 16-08-14 05:10
*/

public class Memcache 
{
    class Pair
    {
        int value;
        int tte;
        public Pair(int value, int tte)
        {
            this.value=value;
            this.tte=tte;
        }
    }
    private HashMap<Integer, Pair> map;

    public Memcache() 
    {
        map = new HashMap<Integer, Pair>();
    }
    
    private void evict(int curtTime)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        for(Map.Entry<Integer, Pair> entry: map.entrySet())
        {
            if(entry.getValue().tte!=0 && entry.getValue().tte<=curtTime)
            {
                set.add(entry.getKey());
            }
        }
        
        for(Integer key: set)
        {
            map.remove(key);
        }
    }

    public int get(int curtTime, int key) 
    {
        evict(curtTime);
        if(!map.containsKey(key))
        {
            return Integer.MAX_VALUE;
        }
        return map.get(key).value;
    }

    public void set(int curtTime, int key, int value, int ttl) 
    {
        int tte = ttl == 0 ? 0 : curtTime + ttl;
        map.put(key, new Pair(value, tte));
    }

    public void delete(int curtTime, int key) 
    {
        map.remove(key);
    }
    
    public int incr(int curtTime, int key, int delta) 
    {
        evict(curtTime);
        if(!map.containsKey(key))
        {
            return Integer.MAX_VALUE;
        }
        map.get(key).value+=delta;
        return map.get(key).value;
    }

    public int decr(int curtTime, int key, int delta) 
    {
        evict(curtTime);
        if(!map.containsKey(key))
        {
            return Integer.MAX_VALUE;
        }
        map.get(key).value-=delta;
        return map.get(key).value;
    }
}