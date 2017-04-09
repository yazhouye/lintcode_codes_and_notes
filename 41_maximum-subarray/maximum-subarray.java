/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 16-08-20 19:40
*/

public class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        /*
        int sum=0;
        int max=Integer.MIN_VALUE;
        int minPrefix=0;
        for(int num: nums)
        {
            sum+=num;
            max=Math.max(max, sum-minPrefix);
            minPrefix=Math.min(minPrefix, sum);
        }
        
        return max;
        */
        
        int maxSoFar=Integer.MIN_VALUE;
        int maxToEnd=0;
        for(int num: nums)
        {
            maxToEnd=Math.max(maxToEnd+num, num);
            maxSoFar=Math.max(maxSoFar, maxToEnd);
        }
        return maxSoFar;
    }
}