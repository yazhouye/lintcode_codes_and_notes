/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Java
@Datetime: 16-08-21 09:31
*/

class Solution 
{
    public int maxProfit(int[] prices) 
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
}