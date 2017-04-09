/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 16-08-09 21:46
*/

public class Solution 
{
    public int findMin(int[] num) 
    {
        int left = 0;
        int right = num.length-1;
        /*
        int min = Integer.MAX_VALUE;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            min=Math.min(min, num[mid]);
            if(num[mid]<num[right])
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return min;
        */
        
        int rightMost = num[num.length-1];
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(num[mid]<rightMost)
            {
                right=mid-1;
            }
            else if(num[mid]>rightMost)
            {
                left=mid+1;
            }
            else
            {
                return rightMost;
            }
        }
        return num[left];
    }
}