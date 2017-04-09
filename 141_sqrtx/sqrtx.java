/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 16-08-10 12:33
*/

class Solution 
{
    public int sqrt(int x) 
    {
        long left = 1;
        long right = x;
        while(left<=right)
        {
            long mid = left+(right-left)/2;
            if(mid*mid>x)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return (int)right;
    }
}