/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/string-to-integer-ii
@Language: Java
@Datetime: 16-08-09 18:22
*/

public class Solution 
{
    public int atoi(String str) 
    {
        if(str==null || str.length()==0)
        {
            return 0;
        }
        
        str=str.trim();
        int i=0;
        char flag='+';
        if(str.charAt(i)=='-')
        {
            flag='-';
            i++;
        }
        else if(str.charAt(i)=='+')
        {
            i++;
        }
        
        double result = 0;
        while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9')
        {
            result=result*10+(str.charAt(i)-'0');
            i++;
        }
        
        if (flag == '-')
        {
            result = -result;
        }
        
	    if (result > Integer.MAX_VALUE)
	    {
	        return Integer.MAX_VALUE;
	    }
 
	    if (result < Integer.MIN_VALUE)
	    {
	        return Integer.MIN_VALUE;   
	    }
		    
        return (int)result;
    }
}