/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 16-07-27 17:21
*/

public class Solution 
{
    public int minSubArray(ArrayList<Integer> nums) 
    {
        //greedy
        /*
        int minSoFar=Integer.MAX_VALUE;
        int minToEnd=0;
        for(Integer item: nums)
        {
            minToEnd=Math.min(minToEnd+item, item);
            minSoFar=Math.min(minSoFar, minToEnd);
        }
        return minSoFar;
        */
        
        //prefix sum
        int sum=0;
        int maxPrefix=0;
        int min=Integer.MAX_VALUE;
        for(Integer item: nums)
        {
            sum+=item;
            min=Math.min(min, sum-maxPrefix);
            maxPrefix=Math.max(maxPrefix, sum);
        }
        return min;
    }
}
