/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 16-08-10 05:47
*/

public class Solution 
{
    //same as Partition Array
    public int removeElement(int[] A, int elem) 
    {
        int p1=0;
        int p2=A.length-1;
        while(p1<=p2)
        {
            while(p1<=p2 && A[p1]!=elem)
            {
                p1++;
            }
            while(p1<=p2 && A[p2]==elem)
            {
                p2--;
            }
            if(p1<p2)
            {
                A[p1]=A[p2];
                p1++;
                p2--;   
            }
        }
        return p1;
    }
}
