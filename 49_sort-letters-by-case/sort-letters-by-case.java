/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/sort-letters-by-case
@Language: Java
@Datetime: 16-07-27 21:35
*/

public class Solution 
{
    public void sortLetters(char[] chars) 
    {
        int start = 0;
        int end = chars.length-1;
        
        while(start<end)
        {
            while(start<end && chars[start]>='a' && chars[start]<='z')
            {
                start++;
            }
            while(start<end && chars[end]>='A' && chars[end]<='Z')
            {
                end--;
            }
            
            if(start<end)
            {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;   
            }
        }
    }
}
