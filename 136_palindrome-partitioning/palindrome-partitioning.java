/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Java
@Datetime: 16-08-05 00:53
*/

public class Solution 
{
    private boolean isPalindrome(String s)
    {
        for(int i=0, j=s.length()-1; i<j; i++, j--)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }
    
    public List<List<String>> partition(String s) 
    {
        List<List<String>> result = new ArrayList<List<String>>();
        
        for(int i=1; i<=s.length(); i++)
        {
            if(isPalindrome(s.substring(0, i)))
            {
                if(i==s.length())
                {
                    List<String> list = new ArrayList<String>();
                    list.add(s);
                    result.add(list);
                }
                else
                {
                    List<List<String>> preResult = partition(s.substring(i, s.length()));
                    for(List<String> list: preResult)
                    {
                        list.add(0, s.substring(0, i));
                        result.add(list);
                    }   
                }
            }
        }
        return result;
    }
}