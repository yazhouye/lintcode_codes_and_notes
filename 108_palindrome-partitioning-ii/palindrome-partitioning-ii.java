/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning-ii
@Language: Java
@Datetime: 16-08-16 20:47
*/

public class Solution 
{
    private boolean[][] getIsPalindrome(String s)
    {
        boolean[][] result = new boolean[s.length()][s.length()];
        
        for(int i=s.length()-1; i>=0; i--)  //dp: O(n^2)
        {
            for(int j=i; j<s.length(); j++)
            {
                if(j==i)
                {
                    result[i][j]=true;
                }
                else if(j==i+1)
                {
                    result[i][j]=s.charAt(i)==s.charAt(j);
                }
                else
                {
                    result[i][j]=result[i+1][j-1] && s.charAt(i)==s.charAt(j);   
                }
            }
        }
        
        return result;
    }
    
    public int minCut(String s) 
    {
        int[] dp = new int[s.length()];
        
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        for(int i=0; i<s.length(); i++)
        {
            dp[i]=i+1;
            for(int j=i-1; j>=-1; j--)
            {
                if(j==-1)
                {
                    if(isPalindrome[j+1][i])
                    {
                        dp[i]=1;
                    }
                }
                else
                {
                    if(isPalindrome[j+1][i])
                    {
                        dp[i]=Math.min(dp[i], dp[j]+1);
                    }
                }
            }
        }
        
        return dp[s.length()-1]-1;
    }
};