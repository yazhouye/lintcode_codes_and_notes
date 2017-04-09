/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 16-08-16 01:08
*/

public class Solution 
{
    public int longestIncreasingSubsequence(int[] nums) 
    {
        int[] dp = new int[nums.length];    //state
        int max=0;
        for(int i=0; i<nums.length; i++)
        {
            dp[i]=1;    //initialization
            for(int j=0; j<i; j++)
            {
                if(nums[j]<nums[i])    //function
                {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            max=Math.max(max, dp[i]);
        }
        
        return max; //answer
    }
}
