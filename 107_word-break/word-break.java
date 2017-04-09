/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 16-07-21 21:14
*/

public class Solution 
{
    public boolean wordBreak(String s, Set<String> dict) 
    {
        if(s.length()==0)
        {
            return true;
        }
        
        int maxLength=0;
        for(String item: dict)
        {
            maxLength=Math.max(maxLength, item.length());
        }
        
        boolean[] dp = new boolean[s.length()]; //state
        
        for(int i=1; i<=s.length(); i++)
        {
            for(int j=i-1; j>=0 && i-j<=maxLength; j--)    //function
            {
                if(j==0)
                {
                    if(dict.contains(s.substring(j,i)))
                    {
                        dp[i-1]=true;
                        break;
                    }
                }
                else
                {
                    if(dp[j-1] && dict.contains(s.substring(j,i)))
                    {
                        dp[i-1]=true;
                        break;
                    }
                }
            }
        }
        
        return dp[s.length()-1];    //answer
    }
}