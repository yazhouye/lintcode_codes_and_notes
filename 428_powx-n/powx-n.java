/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/powx-n
@Language: Java
@Datetime: 16-09-03 17:16
*/

public class Solution 
{
    public double myPow(double x, int n) 
    {
        if(n>=0)
        {
            return helper(x, n);
        }
        else
        {
            return 1/helper(x, -n);
        }
    }
    
    private double helper(double x, int n)
    {
        if(n==0)
        {
            return 1;
        }
        else if(n==1)
        {
            return x;
        }
        
        double half = myPow(x, n/2);
        if(n%2==0)
        {
            return half*half;
        }
        else
        {
            return half*half*x;
        }
    }
}