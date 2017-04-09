/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/maximum-subarray-iii
@Language: Java
@Datetime: 16-07-29 10:57
*/

public class Solution 
{
    //划分型 DP Best Time to Buy and Sell Stock IV
    public int maxSubArray(int[] nums, int k) 
    {
        int n = nums.length;
        
        if(n<k)
        {
            return 0;
        }
        
        int[][] globalMax = new int[n+1][k+1];
        int[][] localMax = new int[n+1][k+1];
        
        for(int i=0; i<=n; i++)
        {
            globalMax[i][0]=0;
            localMax[i][0]=0;
        }
        
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=k && j<=i; j++)
            {
                if(j==i)    //!!!really important
                {
                    localMax[i][j]=globalMax[i-1][j-1]+nums[i-1];
                    globalMax[i][j]=localMax[i][j];
                }
                else
                {
                    localMax[i][j]=Math.max(localMax[i-1][j], globalMax[i-1][j-1])+nums[i-1];
                    globalMax[i][j]=Math.max(globalMax[i-1][j], localMax[i][j]);  
                }
            }
        }
        
        return globalMax[n][k];
    }
}
