/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/backpack-ii
@Language: Java
@Datetime: 16-08-17 03:38
*/

public class Solution 
{
    public int backPackII(int m, int[] A, int V[]) 
    {
        int[] dp = new int[m+1];
        for(int j=0; j<=m; j++)
        {
            dp[j]=0;
        }
        
        for(int i=0; i<A.length; i++)
        {
            for(int j=m; j-A[i]>=0; j--)
            {
                dp[j]=Math.max(dp[j], dp[j-A[i]]+V[i]);
            }
        }
        
        return dp[m];
    }
}