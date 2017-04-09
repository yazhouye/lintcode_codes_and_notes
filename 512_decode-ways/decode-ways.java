/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/decode-ways
@Language: Java
@Datetime: 16-08-16 21:53
*/

public class Solution 
{
    public int numDecodings(String s) 
    {
        if(s.length()==0)
        {
            return 0;
        }
        
        int[] dp = new int[s.length()]; //state
        
        for(int i=0; i<s.length(); i++)
        {
            dp[i]=0;    //initialization
            if(i==0)
            {
                if(s.charAt(i)>='1' && s.charAt(i)<='9')
                dp[i]+=1;   //f
            }
            else
            {
                if(s.charAt(i)>='1' && s.charAt(i)<='9')
                dp[i]+=dp[i-1]; //f

                if((s.charAt(i-1)=='1') || (s.charAt(i-1)=='2'&&s.charAt(i)>='0'&&s.charAt(i)<='6'))
                dp[i]+= i-2>=0 ? dp[i-2]:1; //f
            }
        }
        
        return dp[s.length()-1];
    }
}