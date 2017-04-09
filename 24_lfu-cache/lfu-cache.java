/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/lfu-cache
@Language: Java
@Datetime: 16-08-21 09:04
*/

public class LFUCache 
{
    private HashMap<Integer, Integer> keyValueMap;
    private TreeMap<Integer, List<Integer>> frequencyKeysMap;
    private int capacity;
    
    public LFUCache(int capacity) 
    {
        keyValueMap = new HashMap<Integer, Integer>();
        frequencyKeysMap = new TreeMap<Integer, List<Integer>>();
        this.capacity=capacity;
    }
    
    private void eviction()
    {
        List<Integer> firstFrequencyList = frequencyKeysMap.firstEntry().getValue();
        int firstKey = firstFrequencyList.get(0);
        firstFrequencyList.remove(0);
        
        if(firstFrequencyList.size()==0)
        {
            frequencyKeysMap.remove(frequencyKeysMap.firstEntry().getKey());
        }
        
        keyValueMap.remove((Integer)firstKey);
    }

    private void increaseFrequency(int key)
    {
        int frequency=0;
        for(Map.Entry<Integer, List<Integer>> entry: frequencyKeysMap.entrySet())
        {
            for(Integer item: entry.getValue())
            {
                if(item==key)
                {
                    frequency=entry.getKey();
                    break;
                }
            }
        }
        
        frequencyKeysMap.get(frequency).remove((Integer)key);
        if(frequencyKeysMap.get(frequency).size()==0)
        {
            frequencyKeysMap.remove(frequency);
        }
        
        if(!frequencyKeysMap.containsKey(frequency+1))
        {
            frequencyKeysMap.put(frequency+1, new ArrayList<Integer>());
        }
        frequencyKeysMap.get(frequency+1).add(key);
    }

    public void set(int key, int value) 
    {
        if(keyValueMap.containsKey(key))
        {
            increaseFrequency(key);
        }
        else
        {
            if(keyValueMap.size()==capacity)
            {
                eviction();
            }
            
            if(!frequencyKeysMap.containsKey(1))
            {
                frequencyKeysMap.put(1, new ArrayList<Integer>());
            }
            frequencyKeysMap.get(1).add(key);
        }
        keyValueMap.put(key, value);
    }

    public int get(int key) 
    {
        if(keyValueMap.containsKey(key))
        {
            increaseFrequency(key);
            return keyValueMap.get(key);
        }
        else
        {
            return -1;
        }
    }
}