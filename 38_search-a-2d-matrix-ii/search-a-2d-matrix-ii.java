/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix-ii
@Language: Java
@Datetime: 16-08-10 05:19
*/

public class Solution 
{
    public int searchMatrix(int[][] matrix, int target) 
    {
        if(matrix.length==0)
        {
            return 0;    
        }
        
        int y=0;
        int x=matrix[0].length-1;
        int counter=0;
        while(y<=matrix.length-1 && x>=0)
        {
            if(matrix[y][x]<target)
            {
                y++;
            }
            else if(matrix[y][x]>target)
            {
                x--;
            }
            else
            {
                counter++;
                y++;
                x--;
            }
        }
        return counter;
    }
}
