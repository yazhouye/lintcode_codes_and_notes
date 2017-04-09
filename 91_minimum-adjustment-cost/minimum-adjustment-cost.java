/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/minimum-adjustment-cost
@Language: Java
@Datetime: 16-08-17 04:43
*/

public class Solution 
{
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) 
    {
        int[][] dp = new int[A.size()][101];
        
        for(int i=1; i<A.size(); i++)
        {
            for(int j=0; j<=100; j++)
            {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        
        for(int k=0; k<=100; k++)
        {
            dp[0][k] = Math.abs(k-A.get(0));
        }
        
        for(int i=1; i<A.size(); i++)
        {
            for(int j=0; j<=100; j++)
            {
                if(dp[i-1][j]!=Integer.MAX_VALUE)
                {
                    for(int k=0; k<=100; k++)
                    {
                        if(Math.abs(k-j)<=target)
                        {
                            dp[i][k]=Math.min(dp[i][k], dp[i-1][j]+Math.abs(k-A.get(i)));
                        }
                    }
                }
            }
        }
        
        int min=Integer.MAX_VALUE;
        for(int k=0; k<=100; k++)
        {
            min=Math.min(min, dp[A.size()-1][k]);
        }
        return min;
    }
}