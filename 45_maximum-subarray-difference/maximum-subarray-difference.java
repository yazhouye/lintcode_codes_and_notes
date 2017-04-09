/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/maximum-subarray-difference
@Language: Java
@Datetime: 16-07-27 22:05
*/

public class Solution 
{
    public int maxDiffSubArrays(int[] nums) 
    {
        int[] leftMax = new int[nums.length];
        int[] leftMin = new int[nums.length];
        int maxToEnd = 0;
        int minToEnd = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++)
        {
            maxToEnd=Math.max(maxToEnd+nums[i], nums[i]);
            minToEnd=Math.min(minToEnd+nums[i], nums[i]);
            maxSoFar=Math.max(maxSoFar, maxToEnd);
            minSoFar=Math.min(minSoFar, minToEnd);
            leftMax[i]=maxSoFar;
            leftMin[i]=minSoFar;
        }
        
        int[] rightMax = new int[nums.length];
        int[] rightMin = new int[nums.length];
        maxToEnd = 0;
        minToEnd = 0;
        maxSoFar = Integer.MIN_VALUE;
        minSoFar = Integer.MAX_VALUE;
        
        for(int i=nums.length-1; i>=0; i--)
        {
            maxToEnd=Math.max(maxToEnd+nums[i], nums[i]);
            minToEnd=Math.min(minToEnd+nums[i], nums[i]);
            maxSoFar=Math.max(maxSoFar, maxToEnd);
            minSoFar=Math.min(minSoFar, minToEnd);
            rightMax[i]=maxSoFar;
            rightMin[i]=minSoFar;
        }
        
        int max = 0;
        for(int i=0; i<nums.length-1; i++)
        {
            max=Math.max(max, Math.max(Math.abs(leftMax[i]-rightMin[i+1]), Math.abs(leftMin[i]-rightMax[i+1])));
        }
        return max;
    }
}

