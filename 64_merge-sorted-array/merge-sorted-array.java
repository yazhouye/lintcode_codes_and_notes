/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 16-07-26 01:07
*/

class Solution 
{
    public void mergeSortedArray(int[] A, int m, int[] B, int n) 
    {
        m--;
        n--;
        int i=m+n+1;
        
        while(m>=0 && n>=0)
        {
            if(A[m]>B[n])
            {
                A[i]=A[m];
                m--;
            }
            else
            {
                A[i]=B[n];
                n--;
            }
            i--;
        }
        
        while(n>=0)
        {
            A[i]=B[n];
            n--;
            i--;
        }
    }
}