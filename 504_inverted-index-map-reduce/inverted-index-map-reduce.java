/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/inverted-index-map-reduce
@Language: Java
@Datetime: 16-08-18 05:33
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
public class InvertedIndex 
{

    public static class Map 
    {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) 
                        {
            for(String s: value.content.split("\\s+"))
            {
                output.collect(s, value.id);
            }
        }
    }

    public static class Reduce 
    {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) 
                           {
            List<Integer> list = new ArrayList<Integer>();
            while(values.hasNext())
            {
                int next = values.next();
                if(!list.contains(next))
                {
                    list.add(next);   
                }
            }
            output.collect(key, list);
        }
    }
}
