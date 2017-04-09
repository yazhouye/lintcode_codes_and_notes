/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/maximum-product-subarray
@Language: Java
@Datetime: 16-08-21 09:21
*/

public class Solution 
{
    public int maxProduct(int[] nums) 
    {
        int minToEnd=1;
        int maxToEnd=1;
        int maxSoFar=Integer.MIN_VALUE;
        
        for(int num: nums)
        {
            if(num>0)
            {
                maxToEnd=Math.max(maxToEnd*num, num);
                minToEnd=minToEnd*num;
            }
            else if(num<0)
            {
                int oMinToEnd=minToEnd;
                minToEnd=Math.min(maxToEnd*num, num);
                maxToEnd=oMinToEnd*num;
            }
            else
            {
                minToEnd=1;
                maxToEnd=1;
            }
            maxSoFar=Math.max(maxSoFar, maxToEnd);
        }
        
        return maxSoFar;
    }
}