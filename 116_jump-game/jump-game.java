/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 16-08-16 00:47
*/

public class Solution 
{
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    //dynamic programming
    /*
    public boolean canJump(int[] A) 
    {
        int n = A.length;
        boolean[] dp = new boolean[n];  //state
        
        dp[0]=true; //initailization
        for(int i=1; i<n; i++)
        {
            dp[i]=false;
            for(int j=0; j<i; j++)
            {
                if(dp[j] && A[j]+j>=i)  //function
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        
        return dp[n-1]; //answer
    }
    */
    
    //greedy
    public boolean canJump(int[] A)
    {
        int far = 0;
        for(int i=0; i<A.length && i<=far; i++)
        {
            if(A[i]+i>far)
            {
                far = A[i]+i;
            }
        }
        
        return far>=A.length-1;
    }
}
