/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 16-08-17 03:31
*/

public class Solution 
{
    public int backPack(int m, int[] A) 
    {
        boolean[] dp = new boolean[m+1];
        dp[0]=true;
        
        for(int i=0; i<A.length; i++)
        {
            for(int j=m; j-A[i]>=0; j--)
            {
                if(dp[j-A[i]])
                {
                    dp[j]=true;
                }
            }
        }
        
        for(int j=m; j>=0; j--)
        {
            if(dp[j])
            {
                return j;
            }
        }
        return 0;
    }
}