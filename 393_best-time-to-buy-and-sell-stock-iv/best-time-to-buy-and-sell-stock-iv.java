/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iv
@Language: Java
@Datetime: 16-08-21 10:47
*/

class Solution 
{
    //ĺĺĺ DP Maximum Subarray III
    public int maxProfit(int k, int[] prices) 
    {
        if(k==0)
        {
            return 0;
        }
        
        if(k>=prices.length/2)
        {
            int profit=0;
            for(int i=0; i<prices.length-1; i++)
            {
                if(prices[i+1]>prices[i])
                {
                    profit+=prices[i+1]-prices[i];
                }
            }
            return profit;
        }
        
        int n = prices.length;
        int[][] local = new int[n][k+1];    //ending with n
        int[][] global = new int[n][k+1];   //might not ending with n
        
        for(int j=0; j<k+1; j++)
        {
            local[0][j]=0;
            global[0][j]=0;
        }
        
        for(int i=0; i<n; i++)
        {
            local[i][0]=0;
            global[i][0]=0;
        }
        
        for(int i=1; i<n; i++)
        {
            int profit = prices[i]-prices[i-1];
            for(int j=1; j<=k; j++)
            {
                local[i][j]=Math.max(local[i-1][j], global[i-1][j-1])+profit;
                global[i][j]=Math.max(global[i-1][j], local[i][j]);
            }
        }
        
        return global[n-1][k];
    }
};