/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/last-position-of-target
@Language: Java
@Datetime: 16-08-10 03:36
*/

public class Solution 
{
    public int lastPosition(int[] nums, int target) 
    {
        int left = 0;
        int right = nums.length-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(nums[mid]>target)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        
        return (right<0 || nums[right]!=target) ? -1:right;
    }
}