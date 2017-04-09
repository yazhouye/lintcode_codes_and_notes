/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 16-07-20 06:19
*/

public class Solution 
{
    public int climbStairs(int n) 
    {
        int[] dp = new int[2];    //state
        dp[0]=1;    //initialization
        for(int i=1; i<=n; i++)
        {
            int pre1 = (i-1)%2 >= 0 ? dp[(i-1)%2] : 0;
            int pre2 = (i-2)%2 >= 0 ? dp[(i-2)%2] : 0;
            
            dp[i%2] = pre1 + pre2;  //function
        }
        
        return dp[n%2];   //answer
    }
}