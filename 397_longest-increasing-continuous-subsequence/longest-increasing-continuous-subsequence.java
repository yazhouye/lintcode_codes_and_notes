/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence
@Language: Java
@Datetime: 15-11-20 20:09
*/

public class Solution 
{

    public int longestIncreasingContinuousSubsequence(int[] A) 
    {
        if(A.length==0) return 0;
        
        int maxLength=1;
        
        for(int right=0,left=0;right<A.length-1;)
        {
            if(A[right+1]>=A[right])
            {
                right++;
                if(right==A.length-1)
                maxLength=Math.max(maxLength,right-left+1);
            }
            else
            {
                maxLength=Math.max(maxLength,right-left+1);
                left=right+1;
                right++;
            }
        }
        
        for(int right=0,left=0;right<A.length-1;)
        {
            if(A[right+1]<=A[right])
            {
                right++;
                if(right==A.length-1)
                maxLength=Math.max(maxLength,right-left+1);
            }
            else
            {
                maxLength=Math.max(maxLength,right-left+1);
                left=right+1;
                right++;
            }
        }
        
        return maxLength;
    }
}
