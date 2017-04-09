/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-08-10 04:49
*/

public class Solution 
{
    public boolean search(int[] A, int target) 
    {
        return helper(A, target, 0, A.length-1);
    }
    
    private boolean helper(int[] A, int target, int left, int right)
    {
        if(left>right)
        {
            return false;
        }
        
        int mid = left+(right-left)/2;
        if(A[mid]==target)
        {
            return true;
        }
        
        if(A[left]<A[mid])
        {
            if(A[left]<=target && target<A[mid])
            {
                return helper(A, target, left, mid-1);
            }
            else
            {
                return helper(A, target, mid+1, right);
            }
        }
        else if(A[left]>A[mid])
        {
            if(A[mid]<target && target<=A[right])
            {
                return helper(A, target, mid+1, right);
            }
            else
            {
                return helper(A, target, left, mid-1);
            }
        }
        else
        {
            return helper(A, target, mid+1, right) || helper(A, target, left, mid-1);
        }
    }
}
