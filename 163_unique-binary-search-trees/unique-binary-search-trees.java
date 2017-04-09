/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/unique-binary-search-trees
@Language: Java
@Datetime: 16-08-15 04:36
*/

public class Solution 
{
    public int numTrees(int n) 
    {
        int[] dp = new int[n+1];
        dp[0]=1;
        if(n==0)
        {
            return dp[0];    
        }
        
        dp[1]=1;
        
        for(int i=2; i<=n; i++)
        {
            for(int j=0; j<i; j++)
            {
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}