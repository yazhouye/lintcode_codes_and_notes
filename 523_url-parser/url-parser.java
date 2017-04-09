/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/url-parser
@Language: Java
@Datetime: 16-08-19 17:45
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser 
{
    private static final String HTML_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*\"?'?([^\"'>\\s]*)"; //regular expression
    
    public List<String> parseUrls(String content) 
    {
        List<String> links = new ArrayList<String>();
        Pattern pattern = Pattern.compile(HTML_HREF_TAG_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        String url;
        while (matcher.find()) 
        {
            url = matcher.group(1);
            if (url.length() == 0 || url.startsWith("#"))
                continue;
            links.add(url);
        }
        return links;
    }
}
