/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/classical-binary-search
@Language: Java
@Datetime: 16-08-10 03:38
*/

public class Solution 
{
    public int findPosition(int[] nums, int target) 
    {
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(nums[mid]<target)
            {
                left=mid+1;
            }
            else if(nums[mid]>target)
            {
                right=mid-1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}