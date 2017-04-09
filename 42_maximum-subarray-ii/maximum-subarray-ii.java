/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/maximum-subarray-ii
@Language: Java
@Datetime: 16-08-21 10:02
*/

public class Solution 
{
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) 
    {
        int maxToEnd = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        int[] left = new int[nums.size()];
        for(int i=0; i<nums.size(); i++)
        {
            maxToEnd = Math.max(maxToEnd+nums.get(i), nums.get(i));
            maxSoFar = Math.max(maxSoFar, maxToEnd);
            
            left[i]=maxSoFar;
        }
        
        maxToEnd = 0;
        maxSoFar = Integer.MIN_VALUE;
        
        int[] right = new int[nums.size()];
        for(int i=nums.size()-1; i>=0; i--)
        {
            maxToEnd = Math.max(maxToEnd+nums.get(i), nums.get(i));
            maxSoFar = Math.max(maxSoFar, maxToEnd);
            
            right[i]=maxSoFar;
        }
        
        int maxTwoSub = Integer.MIN_VALUE;
        for(int i=0; i+1<nums.size(); i++)
        {
            maxTwoSub = Math.max(maxTwoSub, left[i]+right[i+1]);
        }
        
        return maxTwoSub;
    }
}

