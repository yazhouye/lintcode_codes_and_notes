/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/word-count-map-reduce
@Language: Java
@Datetime: 16-08-18 05:04
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class WordCount 
{

    public static class Map 
    {
        public void map(String key, String value, OutputCollector<String, Integer> output) 
        {
            for(String s: value.split("\\s+"))
            {
                output.collect(s, 1);   
            }
        }
    }

    public static class Reduce 
    {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) 
                           {
            int sum = 0;
            while(values.hasNext())
            {
                sum+=values.next();
            }
            output.collect(key, sum);
        }
    }
}
