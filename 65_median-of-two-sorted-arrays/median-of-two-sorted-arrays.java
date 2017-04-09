/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/median-of-two-sorted-arrays
@Language: Java
@Datetime: 16-08-21 01:27
*/

class Solution 
{
    public double findMedianSortedArrays(int[] A, int[] B) 
    {
        int n = A.length+B.length;
        if(n%2==0)
        {
            return (findKth(A, 0, B, 0, n/2)+findKth(A, 0, B, 0, n/2+1))/2.0;
        }
        else
        {
            return findKth(A, 0, B, 0, n/2+1);
        }
    }
    
    private int findKth(int[] A, int indexA, int[] B, int indexB, int k)
    {
        if(indexA>A.length-1)
        {
            return B[indexB+k-1];
        }
        if(indexB>B.length-1)
        {
            return A[indexA+k-1];
        }
        
        if(k==1)
        {
            return Math.min(A[indexA], B[indexB]);
        }
        
        if(indexA+k/2-1>A.length-1)
        {
            return findKth(A, indexA, B, indexB+k/2, k-k/2);
        }
        if(indexB+k/2-1>B.length-1)
        {
            return findKth(A, indexA+k/2, B, indexB, k-k/2);
        }
        
        if(A[indexA+k/2-1]<B[indexB+k/2-1])
        {
            return findKth(A, indexA+k/2, B, indexB, k-k/2);
            ///!!! not indexA+k/2-1, discard A[indexA+k/2-1]
        }
        else
        {
            return findKth(A, indexA, B, indexB+k/2, k-k/2);
        }
    }
}
