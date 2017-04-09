/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/distinct-subsequences
@Language: Java
@Datetime: 16-07-20 22:48
*/

public class Solution 
{
    public int numDistinct(String S, String T) 
    {
        int m = S.length();
        int n = T.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(j==0)
                {
                    dp[i][j]=1;
                }
                else if(i==0)
                {
                    dp[i][j]=0;
                }
                else
                {
                    if(S.charAt(i-1)==T.charAt(j-1))
                    {
                        dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}