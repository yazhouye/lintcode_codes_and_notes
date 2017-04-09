/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/flip-bits
@Language: Java
@Datetime: 16-08-14 06:01
*/

class Solution 
{
    public static int bitSwapRequired(int a, int b) 
    {
        int count = 0;  
        for (int c = a ^ b; c != 0; c&=c-1) 
        {
            count++;
        }
        return count;
    }
}
