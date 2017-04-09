/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 16-08-09 23:10
*/

public class Solution 
{
    public int[] searchRange(int[] A, int target) 
    {
        int left = 0;
        int right = A.length-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(target>A[mid])
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        
        int[] result = new int[2];
        if(left<A.length && A[left]==target)
        {
            result[0]=left;
        }
        else
        {
            return new int[]{-1, -1};
        }
        
        left=0;
        right=A.length-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(target<A[mid])
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        
        result[1]=right;
        return result;
    }
}
