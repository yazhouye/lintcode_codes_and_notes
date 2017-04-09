/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/fast-power
@Language: Java
@Datetime: 16-08-15 03:11
*/

class Solution 
{
    public int fastPower(int a, int b, int n) 
    {
        if(n==0)
        {
            return 1%b;
        }
        if(n==1)
        {
            return a%b;
        }
        
        long product = fastPower(a, b, n/2);
        product=(product*product)%b;    //because (a*b)/c==(a/c)*(b/c)
        if(n%2==1)
        {
            product=(product*a)%b;
        }
        return (int)product;
    }
}