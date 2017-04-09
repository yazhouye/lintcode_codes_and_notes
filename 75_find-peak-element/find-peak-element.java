/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 16-08-09 21:52
*/

class Solution 
{
    public int findPeak(int[] A) 
    {
        int left=1;
        int right=A.length-2;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(A[mid+1]>A[mid])
            {
                left=mid+1;
            }
            else if(A[mid-1]>A[mid])
            {
                right=mid-1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
