/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/mini-cassandra
@Language: Java
@Datetime: 16-08-14 04:28
*/

/**
 * Definition of Column:
 * public class Column {
 *     public int key;
 *     public String value;
 *     public Column(int key, String value) {
 *         this.key = key;
 *         this.value = value;
 *    }
 * }
 */
public class MiniCassandra 
{
    private HashMap<String, TreeMap<Integer, String>> rawMap;

    public MiniCassandra() 
    {
        rawMap = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void insert(String raw_key, int column_key, String column_value) 
    {
        if(!rawMap.containsKey(raw_key))
        {
            rawMap.put(raw_key, new TreeMap<Integer, String>());
        }
        rawMap.get(raw_key).put(column_key, column_value);
    }

    public List<Column> query(String raw_key, int column_start, int column_end) 
    {
        List<Column> list = new ArrayList<Column>();
        if(!rawMap.containsKey(raw_key))
        {
            return list;
        }
        TreeMap<Integer, String> insideMap = rawMap.get(raw_key);
        for(Map.Entry<Integer, String> entry: insideMap.subMap(column_start, true, column_end, true).entrySet())
        {
            list.add(new Column(entry.getKey(), entry.getValue()));
        }
        return list;
    }
}