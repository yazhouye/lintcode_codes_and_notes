/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 16-08-10 03:19
*/

public class Solution 
{
    public int totalOccurrence(int[] A, int target) 
    {   
        
        if(A.length==0 || target<A[0] || target>A[A.length-1])
        {
            return 0;
        }
        
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
        
        if(A[left]!=target)
        {
            return 0;
        }
        int start = left;
        
        left = 0;
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

        int end = right;
        
        return end-start+1;
    }
}