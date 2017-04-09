/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/typeahead
@Language: Java
@Datetime: 16-08-19 18:51
*/

public class Typeahead 
{
    private HashMap<String, List<String>> substringMap;
    
    // @param dict A dictionary of words dict
    public Typeahead(Set<String> dict) 
    {
        substringMap = new HashMap<String, List<String>>();
        
        for(String s: dict)
        {
            for(int i=0; i<s.length(); i++)
            {
                for(int j=i+1; j<=s.length(); j++)
                {
                    String key = s.substring(i, j);
                    if(!substringMap.containsKey(key))
                    {
                        substringMap.put(key, new ArrayList<String>());
                        substringMap.get(key).add(s);
                    }
                    else
                    {
                        List<String> list = substringMap.get(key);
                        if(!list.get(list.size()-1).equals(s))
                        {
                            list.add(s);
                        }
                    }
                }
            }
        }
    }

    // @param str: a string
    // @return a list of words
    public List<String> search(String str) 
    {
        if (!substringMap.containsKey(str)) 
        {
            return new ArrayList<String>();
        } 
        else 
        {
            return substringMap.get(str);
        }
    }
}