/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 16-08-09 21:15
*/

public class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int left=0;
        int right=matrix.length-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(matrix[mid][0]>target)
            {
                right=mid-1;
            }
            else if(matrix[mid][0]<target)
            {
                left=mid+1;
            }
            else
            {
                return true;
            }
        }
        
        if(right<0)
        {
            return false;
        }
        int row = right;
        left=0;
        right=matrix[0].length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(matrix[row][mid]>target)
            {
                right=mid-1;
            }
            else if(matrix[row][mid]<target)
            {
                left=mid+1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
