/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 16-08-10 04:41
*/

public class Solution 
{
    public int woodCut(int[] L, int k) 
    {
        if(L.length==0)
        {
            return 0;
        }
        
        int maxLength=0;
        for(int item: L)
        {
            maxLength=Math.max(maxLength, item);
        }
        
        int left=1;
        int right=maxLength;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(number(L, mid)<k)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return right;
    }
    
    private int number(int[] L, int length)
    {
        int counter=0;
        for(int item: L)
        {
            counter+=item/length;
        }
        return counter;
    }
}