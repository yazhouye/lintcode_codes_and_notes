/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/closest-number-in-sorted-array
@Language: Java
@Datetime: 16-08-10 03:30
*/

public class Solution 
{
    public int closestNumber(int[] A, int target) 
    {
        if(A.length==0)
        {
            return -1;
        }
        
        int left=0;
        int right=A.length-1;
        
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(A[mid]<target)
            {
                left=mid+1;
            }
            else if(A[mid]>target)
            {
                right=mid-1;
            }
            else
            {
                return mid;
            }
        }
        
        if(left==A.length)
        {
            return right;
        }
        if(right==-1)
        {
            return left;
        }
        
        return target-A[right]<=A[left]-target ? right:left;
    }
}