/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Java
@Datetime: 16-07-29 01:09
*/

public class Solution 
{
    public void heapify(int[] A) 
    {
        for(int i=A.length/2-1; i>=0; i--)
        {
            moveDown(A, i);
        }
    }
    
    private void moveDown(int[] A, int index)
    {
        while(index*2+1<A.length)
        {
            if(index*2+2>=A.length)
            {
                if(A[index]<=A[index*2+1])
                {
                    break;  //!!!must break
                }
                else
                {
                    int temp = A[index];
                    A[index] = A[index*2+1];
                    A[index*2+1] = temp;
                    index=index*2+1;
                }
            }
            else
            {
                if(A[index]<=A[index*2+1] && A[index]<=A[index*2+2])
                {
                    break;  //!!!must break
                }
                else
                {
                    int minIndex = A[index*2+1]<=A[index*2+2] ? (index*2+1):(index*2+2);
                    int temp = A[index];
                    A[index] = A[minIndex];
                    A[minIndex] = temp;
                    index=minIndex;
                }
            }
        }
    }
}