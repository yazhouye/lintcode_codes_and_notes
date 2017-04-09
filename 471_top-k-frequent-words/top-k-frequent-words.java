/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Java
@Datetime: 16-08-22 17:04
*/

public class Solution 
{
    /*
    class Pair
    {
        String key;
        int value;
        public Pair(String key, int value)
        {
            this.key=key;
            this.value=value;
        }
    }
    
    private Comparator<Pair> pairComparator = new Comparator<Pair>(){
        @Override
        public int compare(Pair p1, Pair p2)
        {
            if(p1.value!=p2.value)
            {
                return p1.value-p2.value;   
            }
            else
            {
                return p2.key.compareTo(p1.key);
            }
        }
    };
    
    public String[] topKFrequentWords(String[] words, int k) 
    {
        if(k==0 || k>words.length)
        {
            return new String[0];
        }
        
         HashMap<String, Integer> counter = new HashMap<String, Integer>();
         for(String s: words)
         {
             if(!counter.containsKey(s))
             {
                counter.put(s, 0);
             }
             counter.put(s, counter.get(s)+1);
         }
         
         PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, pairComparator);
         
         for(Map.Entry<String, Integer> entry: counter.entrySet())
         {
             pq.offer(new Pair(entry.getKey(), entry.getValue()));
             if(pq.size()>k)
             {
                pq.poll();
             }
         }
         
         String[] result = new String[k];
         for(int i=k-1; i>=0; i--)
         {
            result[i]=pq.poll().key;
         }
         
         return result;
    }
    */
    
    public String[] topKFrequentWords(String[] words, int k) 
    {
        if(k==0 || k>words.length)
        {
            return new String[0];
        }
        
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for(String s: words)
        {
            if(!counter.containsKey(s))
            {
                counter.put(s, 0);
            }
            counter.put(s, counter.get(s)+1);
        }
        
        HashMap<Integer, List<String>> frequencyMap = new HashMap<Integer, List<String>>();
        for(Map.Entry<String, Integer> entry: counter.entrySet())
        {
            if(!frequencyMap.containsKey(entry.getValue()))
            {
                frequencyMap.put(entry.getValue(), new ArrayList<String>());
            }
            frequencyMap.get(entry.getValue()).add(entry.getKey());
        }
        
        String[] result = new String[k];
        int j=0;
        for(int i=words.length; i>=0; i--)
        {
            if(!frequencyMap.containsKey(i))
            {
                continue;
            }
            List<String> strings = frequencyMap.get(i);
            Collections.sort(strings);
            for(String s: strings)
            {
                result[j]=s;
                j++;
                if(j==k)
                {
                    return result;
                }
            }
        }
        
        return result;
    }
}