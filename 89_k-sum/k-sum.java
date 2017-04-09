/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/k-sum
@Language: Java
@Datetime: 16-08-23 07:17
*/

public class Solution 
{
    public int kSum(int A[], int k, int target) 
    {
        int[][][] dp = new int[A.length+1][k+1][target+1];
        
        for(int i=0; i<=A.length; i++)
        {
            dp[i][0][0]=1;
        }
        
        for(int i=1; i<=A.length; i++)
        {
            for(int j=1; j<=i && j<=k; j++)
            {
                for(int x=0; x<=target; x++)
                {
                    dp[i][j][x]=dp[i-1][j][x];
                    if(x-A[i-1]>=0)
                    {
                        dp[i][j][x]+=dp[i-1][j-1][x-A[i-1]];
                    }
                }
            }
        }
        
        return dp[A.length][k][target];
    }
}
