/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/tiny-url-ii
@Language: Java
@Datetime: 16-07-13 22:48
*/

public class TinyUrl2 
{
    private HashMap<String, String> lts;
    private HashMap<String, String> stl;
    private int sequentialID;
    private String shortPrefix;
    
    public TinyUrl2()
    {
        sequentialID = 0;
        shortPrefix = "http://tiny.url/";
        lts = new HashMap<String, String>();
        stl = new HashMap<String, String>();
    }
    
    public String createCustom(String long_url, String short_url) 
    {
        if(lts.containsKey(long_url) && !lts.get(long_url).equals(short_url))
        {
            return "error";
        }
        
        if(stl.containsKey(short_url) && !stl.get(short_url).equals(long_url))
        {
            return "error";
        }
        
        if(stl.containsKey(short_url))
        {
            return shortPrefix+short_url;
        }
        
        lts.put(long_url, short_url);
        stl.put(short_url, long_url);
        return shortPrefix+short_url;
    }

    public String longToShort(String long_url) 
    {
        if(lts.containsKey(long_url))
        {
            return shortPrefix + lts.get(long_url);
        }
        
        String short_url = idToShortUrl(sequentialID++);
        lts.put(long_url, short_url);
        stl.put(short_url, long_url);
        return shortPrefix + short_url;
    }
    
    private String idToShortUrl(int id)
    {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String short_url = "";
        while (id > 0) 
        {
            short_url = chars.charAt(id % 62) + short_url;
            id = id / 62;
        }
        while (short_url.length() < 6) 
        {
            short_url = "0" + short_url;
        }
        return short_url;
    }

    public String shortToLong(String short_url) 
    {
        return stl.get(short_url.substring(shortPrefix.length()));
    }
}