/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 16-07-20 08:19
*/

public class Solution 
{
    //1. recursion: traverse
    /*
    private int min = Integer.MAX_VALUE;
    public int minimumTotal(int[][] triangle) 
    {
        helper(triangle, 0, 0, 0);
        return min;
    }
    private void helper(int[][] triangle, int y, int x, int sum)
    {
        if(y==triangle.length)
        {
            min=Math.min(min, sum);
            return;
        }
        
        helper(triangle, y+1, x, sum+triangle[y][x]);
        helper(triangle, y+1, x+1, sum+triangle[y][x]);
    }
    */
    
    //2. recursion: divide conquer
    /*
    public int minimumTotal(int[][] triangle)
    {
        return helper(triangle, 0, 0);
    }
    private int helper(int[][] triangle, int y, int x)
    {
        if(y==triangle.length-1)
        {
            return triangle[y][x];
        }
        
        //divide
        int left = helper(triangle, y+1, x);
        int right = helper(triangle, y+1, x+1);
        
        //conquer
        return triangle[y][x]+Math.min(left, right);
    }
    */
    
    //3. recursion: divide conquer and DP
    /*
    private Integer[][] dp;
    public int minimumTotal(int[][] triangle)
    {
        dp = new Integer[triangle.length][triangle.length];
        return helper(triangle, 0, 0);
    }
    private int helper(int[][] triangle, int y, int x)
    {
        if(dp[y][x]!=null)
        {
            return dp[y][x];
        }
        
        if(y==triangle.length-1)
        {
            dp[y][x]=triangle[y][x];
            return triangle[y][x];
        }
        
        //divide
        int left = helper(triangle, y+1, x);
        int right = helper(triangle, y+1, x+1);
        
        //conquer
        dp[y][x]=triangle[y][x]+Math.min(left, right);
        return triangle[y][x]+Math.min(left, right);
    }
    */
    
    //4. iteration: top to down DP 
    /*
    public int minimumTotal(int[][] triangle)
    {
        int[][] dp = new int[triangle.length][triangle.length];
        for(int i=0; i<triangle.length; i++)
        {
            for(int j=0; j<=i; j++)
            {
                if(i==0)
                {
                    dp[i][j]=triangle[i][j];
                }
                else
                {
                    if(j==0)
                    {
                        dp[i][j]=triangle[i][j]+dp[i-1][j];
                    }
                    else if(j==i)
                    {
                        dp[i][j]=triangle[i][j]+dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j]=triangle[i][j]+Math.min(dp[i-1][j], dp[i-1][j-1]);
                    }
                }
            }
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0; i<triangle.length; i++)
        {
            min=Math.min(min, dp[triangle.length-1][i]);
        }
        return min;
    }
    */
    
    //5. iteration: bottom to up DP
    public int minimumTotal(int[][] triangle)
    {
        int[][] dp = new int[triangle.length][triangle.length];
        
        for(int i=triangle.length-1; i>=0; i--)
        {
            for(int j=0; j<=i; j++)
            {
                if(i==triangle.length-1)
                {
                    dp[i][j]=triangle[i][j];
                }
                else
                {
                    dp[i][j]=triangle[i][j]+Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}
