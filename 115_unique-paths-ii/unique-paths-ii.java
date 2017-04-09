/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 16-08-15 23:24
*/

public class Solution 
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)   //state
    {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(obstacleGrid[i][j]==1)
                {
                    continue;
                }
    
                if(i==0 && j==0)
                {
                    obstacleGrid[i][j]=-1;
                }
                else if(i==0)
                {
                    obstacleGrid[i][j]=obstacleGrid[i][j-1]; //initialization
                }
                else if(j==0)
                {
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]; //initialization
                }
                else
                {
                    if(obstacleGrid[i-1][j]!=1)
                    {
                        obstacleGrid[i][j]+=obstacleGrid[i-1][j];   //function
                    }
                    if(obstacleGrid[i][j-1]!=1)
                    {
                        obstacleGrid[i][j]+=obstacleGrid[i][j-1];   //function
                    }
                }
            }
        }
        
        if(obstacleGrid[m-1][n-1]==1)
        {
            return 0;   //answer
        }
        else
        {
            return -obstacleGrid[m-1][n-1];    //answer
        }
    }
}