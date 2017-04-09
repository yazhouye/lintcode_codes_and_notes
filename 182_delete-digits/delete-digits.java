/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/delete-digits
@Language: Java
@Datetime: 16-08-17 08:15
*/

public class Solution 
{
    public String DeleteDigits(String A, int k) 
    {
        for (int i = 0; i < k; i++) 
        {
            for (int j = 0; j < A.length(); j++) 
            {
                if (j == A.length() - 1 || A.charAt(j) > A.charAt(j+1)) //important: function
                {
                    A = remove(A, j);
                    break;
                }
            }
        }
        
        int i=0;
        while(i<A.length() && A.charAt(i)=='0')
        {
            i++;
        }
        
        return A.substring(i, A.length());
    }
    
    private String remove(String A, int index)
    {
        return A.substring(0, index)+A.substring(index+1, A.length());
    }
}