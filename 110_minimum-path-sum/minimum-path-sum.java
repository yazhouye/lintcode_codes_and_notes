/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/minimum-path-sum
@Language: Java
@Datetime: 16-07-20 06:25
*/

public class Solution 
{
    public int minPathSum(int[][] grid) //state
    {
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(i==0 && j==0)
                {
                    continue;
                }
                else if(i==0)
                {
                    grid[i][j]+=grid[i][j-1];   //initialization
                }
                else if(j==0)
                {
                    grid[i][j]+=grid[i-1][j];   //initialization
                }
                else
                {
                    grid[i][j]+=Math.min(grid[i][j-1], grid[i-1][j]);   //function
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];   //answer
    }
}
