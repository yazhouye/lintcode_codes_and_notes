/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 16-07-27 17:31
*/

class Solution 
{
    public int[] mergeSortedArray(int[] A, int[] B) 
    {
        int[] result = new int[A.length+B.length];
        
        int p = result.length-1;
        int pA = A.length-1;
        int pB = B.length-1;
        
        while(pA>=0 || pB>=0)
        {
            if(pA<0)
            {
                result[p--] = B[pB--];
            }
            else if(pB<0)
            {
                result[p--] = A[pA--];
            }
            else
            {
                if(A[pA]<=B[pB])
                {
                    result[p--] = B[pB--];
                }
                else
                {
                    result[p--] = A[pA--];
                }
            }
        }
        
        return result;
    }
}