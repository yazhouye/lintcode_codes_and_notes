/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/k-closest-numbers-in-sorted-array
@Language: Java
@Datetime: 16-08-10 03:54
*/

public class Solution 
{
    public int[] kClosestNumbers(int[] A, int target, int k) 
    {
        int left = 0;
        int right = A.length-1;
        int mid = 0;
        while(left<=right)
        {
            mid = left+(right-left)/2;
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
                break;
            }
        }
        
        int p1=0;
        int p2=0;
        if(A[mid]==target)
        {
            p1=mid;
            p2=mid+1;
        }
        else
        {
            p1=right;
            p2=left;
        }
        
        int[] result = new int[k];
        for(int i=0; i<k; i++)
        {
            if(p1<0)
            {
                result[i]=A[p2++];
            }
            else if(p2>A.length-1)
            {
                result[i]=A[p1--];
            }
            else
            {
                result[i]=target-A[p1]<=A[p2]-target ? A[p1--]:A[p2++];
            }
        }
        return result;
    }
}