/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock
@Language: Java
@Datetime: 16-08-21 09:35
*/

public class Solution 
{
    public int maxProfit(int[] prices) 
    {
        if(prices.length==0)
        {
            return 0;    
        }
        
        int maxProfit=0;
        int minPre=prices[0];
        for(int i=1; i<prices.length; i++)
        {
            maxProfit=Math.max(maxProfit, prices[i]-minPre);
            minPre=Math.min(minPre, prices[i]);
        }
        return maxProfit;
    }
}