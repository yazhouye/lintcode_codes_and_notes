/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/lru-cache
@Language: Java
@Datetime: 16-08-21 08:48
*/

public class Solution 
{
    private List<Integer> keyList;
    private HashMap<Integer, Integer> keyValueMap;
    private int capacity;
    
    public Solution(int capacity) 
    {
        keyList = new ArrayList<Integer>();
        keyValueMap = new HashMap<Integer, Integer>();
        this.capacity = capacity;
    }

    private void moveToTail(int key)
    {
        keyList.remove((Integer)key);
        keyList.add(key);
    }

    public int get(int key) 
    {
        if(keyValueMap.containsKey(key))
        {
            moveToTail(key);
            return keyValueMap.get(key);
        }
        else
        {
            return -1;
        }
    }

    public void set(int key, int value) 
    {
        if(keyValueMap.containsKey(key))
        {
            moveToTail(key);
        }
        else
        {
            keyList.add(key);
            if(keyList.size()>capacity)
            {
                keyValueMap.remove(keyList.get(0));
                keyList.remove(0);
            }
        }
        keyValueMap.put(key, value);
    }
}