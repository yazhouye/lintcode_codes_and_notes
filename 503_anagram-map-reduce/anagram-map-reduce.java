/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/anagram-map-reduce
@Language: Java
@Datetime: 16-08-18 05:09
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class Anagram 
{

    public static class Map 
    {
        public void map(String key, String value,
                        OutputCollector<String, String> output) 
                        {
            for(String s: value.split("\\s+"))
            {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                output.collect(String.valueOf(chars), s);
            }
        }
    }

    public static class Reduce 
    {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) 
                           {
            List<String> list = new ArrayList<String>();
            while(values.hasNext())
            {
                list.add(values.next());
            }
            output.collect(key, list);
        }
    }
}
