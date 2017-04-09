/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/valid-palindrome
@Language: Java
@Datetime: 16-07-25 03:24
*/

public class Solution 
{
    public boolean isPalindrome(String s) 
    {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(!isvalid(s.charAt(i)))
            {
                i++;
                continue;
            }
            if(!isvalid(s.charAt(j)))
            {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) 
            {
                return false;
            } else 
            {
                i++;
                j--;
            }
        }
        return true;
    }
    
    private boolean isvalid (char c) 
    {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}