/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 16-08-16 01:03
*/

public class Solution 
{
    public int jump(int[] A) 
    {
        //dp
        
        int[] dp = new int[A.length];
        dp[0]=0;
        for(int i=1; i<A.length; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(j+A[j]>=i)
                {
                    dp[i]=dp[j]+1;  //greedy dp[j] must be sorted in ascending order
                    break;
                }
            }
        }
        return dp[A.length-1];
        
        
        //greedy
        /*
        int far=0;
        int counter=0;
        for(int i=0; i<A.length && far<A.length-1; i++)
        {
            if(i+A[i]>far)
            {
                far=i+A[i];
                counter++;
            }
        }
        return counter;
        */
    }
}
