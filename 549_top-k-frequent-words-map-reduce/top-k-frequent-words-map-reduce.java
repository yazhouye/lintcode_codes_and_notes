/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words-map-reduce
@Language: Java
@Datetime: 16-08-18 06:05
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class TopKFrequentWords 
{

    public static class Map 
    {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) 
                        {
            for(String s: value.content.split("\\s+"))
            {
                output.collect(s, 1);
            }
        }
    }

    public static class Reduce 
    {
        class Pair 
        {
            String key;
            int value;
    
            Pair(String key, int value) 
            {
                this.key = key;
                this.value = value;
            }
        }
        
        private PriorityQueue<Pair> pq;
        private int k;
        private Comparator<Pair> pairComparator = new Comparator<Pair>() 
        {
            @Override
            public int compare(Pair left, Pair right) 
            {
                if (left.value != right.value) {
                    return left.value - right.value;
                }
                return right.key.compareTo(left.key);
            }
        };
        
        public void setup(int k) 
        {
            this.k=k;
            pq=new PriorityQueue<Pair>(k, pairComparator);
        }   

        public void reduce(String key, Iterator<Integer> values) 
        {
            int sum = 0;
            while(values.hasNext())
            {
                sum+=values.next();
            }
            Pair pair = new Pair(key, sum);
            pq.add(pair);
            
            if(pq.size()>k)
            {
                pq.poll();
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) 
        {
            List<Pair> pairs = new ArrayList<Pair>();
            while (!pq.isEmpty()) 
            {
                pairs.add(pq.poll());
            }
            
            for(int i=pairs.size()-1; i>=0; i--)
            {
                output.collect(pairs.get(i).key, pairs.get(i).value);
            }
        }
    }
}