/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/first-missing-positive
@Language: Java
@Datetime: 16-08-10 13:08
*/

public class Solution 
{
    public int firstMissingPositive(int[] A) 
    {
        if (A == null) 
        {
            return 1;
        }

        for(int i=0; i<A.length; i++)
        {
            while(A[i]>0 && A[i]<=A.length && A[i]!=i+1)
            {
                if(A[A[i]-1]==A[i])
                {
                    break;
                }
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
        }
        
        for(int i=0; i<A.length; i++)
        {
            if(A[i]!=i+1)
            {
                return i+1;
            }
        }
        return A.length+1;
    }
}