/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 16-08-09 22:57
*/

public class Solution 
{
    public int search(int[] A, int target) 
    {
        int left = 0;
        int right = A.length-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(A[mid]==target)
            {
                return mid;
            }
            
            if(A[mid]<A[right])
            {
                if(A[mid]<target && target<=A[right])
                {
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
            else
            {
                if(A[left]<=target && target<A[mid])
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
