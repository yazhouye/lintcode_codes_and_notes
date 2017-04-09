/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/wildcard-matching
@Language: Java
@Datetime: 16-08-17 05:19
*/

public class Solution 
{
    public boolean isMatch(String s, String p) 
    {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        for(int i=0; i<=s.length(); i++)
        {
            for(int j=0; j<=p.length(); j++)
            {
                if(i==0 && j==0)    //initialize
                {
                    dp[i][j]=true;
                }
                else if(i==0)   //initialize
                {
                    if(p.charAt(j-1)=='*')
                    {
                        dp[i][j]=dp[i][j-1]; 
                    }
                    else
                    {
                        dp[i][j]=false;
                    }
                }
                else if(j==0)   //initialize
                {
                    if(s.charAt(i-1)=='*')
                    {
                        dp[i][j]=dp[i-1][j]; 
                    }
                    else
                    {
                        dp[i][j]=false;
                    }
                }
                else    //function
                {
                    if(s.charAt(i-1)=='?' || p.charAt(j-1)=='?')
                    {
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else if(s.charAt(i-1)=='*')
                    {
                        dp[i][j]=dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1];
                    }
                    else if(p.charAt(j-1)=='*')
                    {
                        dp[i][j]=dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
                    }
                    else
                    {
                        dp[i][j]=dp[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1);
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}