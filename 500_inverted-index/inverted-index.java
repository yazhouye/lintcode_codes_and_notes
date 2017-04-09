/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/inverted-index
@Language: Java
@Datetime: 16-07-25 19:56
*/

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution 
{
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) 
    {
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        
        for(Document document: docs)
        {
            for(String s: document.content.split("\\s+"))
            {
                if(!result.containsKey(s))
                {
                    List<Integer> list = new ArrayList<Integer>();
                    result.put(s, list);
                }
                if(!result.get(s).contains(document.id))
                {
                    result.get(s).add(document.id);
                }
            }
        }
        
        return result;
    }
}