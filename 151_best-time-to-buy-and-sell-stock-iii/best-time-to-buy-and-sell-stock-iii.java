/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 16-08-21 09:45
*/

class Solution 
{
    public int maxProfit(int[] prices) 
    {
        if(prices.length==0 || prices.length==1)
        {
            return 0;
        }
        
        int[] leftMaxProfit = new int[prices.length];
        int minPrefix=prices[0];
        int max=0;
        for(int i=1; i<leftMaxProfit.length; i++)
        {
            if(prices[i]-minPrefix>max)
            {
                max=prices[i]-minPrefix;
            }
            leftMaxProfit[i]=max;
            minPrefix=Math.min(minPrefix, prices[i]);
        }
        
        int[] rightMinProfit = new int[prices.length];
        int maxPrefix=prices[prices.length-1];
        max=0;
        for(int i=rightMinProfit.length-2; i>=0; i--)
        {
            if(maxPrefix-prices[i]>max)
            {
                max=maxPrefix-prices[i];
            }
            rightMinProfit[i]=max;
            maxPrefix=Math.max(maxPrefix, prices[i]);
        }
        
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++)
        {
            if(i==0)
            {
                maxProfit=Math.max(maxProfit, rightMinProfit[i]);
            }
            else if(i==prices.length-1)
            {
                maxProfit=Math.max(maxProfit, leftMaxProfit[i]);
            }
            else
            {
                maxProfit=Math.max(maxProfit, leftMaxProfit[i]+rightMinProfit[i]);   
            }
        }
        return maxProfit;
    }
};