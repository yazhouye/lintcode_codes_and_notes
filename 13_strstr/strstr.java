/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 16-08-09 05:23
*/

class Solution 
{
    public int strStr(String source, String target) 
    {
        if(source==null || target==null)
        {
            return -1;
        }
        
        for(int i=0; i+target.length()<=source.length(); i++)
        {
            for(int j=0; j<=target.length(); j++)
            {
                if(j==target.length())
                {
                    return i;
                }
                if(source.charAt(i+j)!=target.charAt(j))
                {
                    break;
                }
            }
        }
        return -1;
    }
}