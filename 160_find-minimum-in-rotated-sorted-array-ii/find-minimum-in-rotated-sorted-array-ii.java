/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-08-10 05:14
*/

public class Solution 
{
    /*
    public int findMin(int[] num) 
    {
        helper(num, 0, num.length-1);
        return min;
    }
    private int min=Integer.MAX_VALUE;
    private void helper(int[] num, int left, int right)
    {
        if(left>right)
        {
            return;    
        }
        
        int mid=left+(right-left)/2;
        min=Math.min(min, num[mid]);
        if(num[mid]<num[right])
        {
            helper(num, left, mid-1);
        }
        else if(num[mid]>num[right])
        {
            helper(num, mid+1, right);
        }
        else
        {
            helper(num, left, mid-1);
            helper(num, mid+1, right);
        }
    }
    */
    
    public int findMin(int[] num)
    {
        int left=0;
        int right=num.length-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(num[mid]==num[right])
            {
                right--;
            }
            else if(num[mid]<num[right])
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return num[left];
    }
}