/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Java
@Datetime: 16-07-21 23:11
*/

public class Solution 
{
    public int longestCommonSubstring(String A, String B) 
    {
        int[][] dp = new int[A.length()][B.length()];   //state, common substring ending with i,j
        int longest=0;
        for(int i=0; i<A.length(); i++)
        {
            for(int j=0; j<B.length(); j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=A.charAt(i)==B.charAt(j) ? 1 : 0;
                }
                else
                {
                    dp[i][j]=A.charAt(i)==B.charAt(j) ? dp[i-1][j-1]+1 : 0;
                }
                longest = Math.max(longest, dp[i][j]);
            }
        }
        
        return longest;
    }
}