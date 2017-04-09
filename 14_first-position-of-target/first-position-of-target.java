/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 16-08-09 21:19
*/

class Solution 
{
    public int binarySearch(int[] nums, int target) 
    {
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(nums[mid]<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        
        return (left<nums.length && nums[left]==target) ? left:-1;
    }
}