/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/trailing-zeros
@Language: Java
@Datetime: 16-08-01 19:08
*/

class Solution 
{
    public long trailingZeros(long n) 
    {
        long sum = 0;
        while(n!=0)
        {
            sum += n/5;
            n/=5;
        }
        
        return sum;
    }
};
