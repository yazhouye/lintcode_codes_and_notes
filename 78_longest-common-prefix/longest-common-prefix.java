/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/longest-common-prefix
@Language: Java
@Datetime: 16-08-09 06:18
*/

public class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        if(strs==null || strs.length==0)
        {
            return "";
        }
        if(strs.length==1)
        {
            return strs[0];
        }
        
        for(int i=0; i<strs[0].length(); i++)   //compare i char of each string with i char of first string
        {
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++)
            {
                if(i>strs[j].length()-1 || strs[j].charAt(i)!=c)
                {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}