/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Java
@Datetime: 16-08-21 09:50
*/

class Solution 
{
    public void sortColors(int[] nums) 
    {
        int left=0;
        int mid=0;
        int right=nums.length-1;
        
        while(mid<=right)
        {
            if(nums[mid]==0)
            {
                if(left!=mid)
                {
                    nums[left]^=nums[mid];
                    nums[mid]^=nums[left];
                    nums[left]^=nums[mid];
                }
                left++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else if(nums[mid]==2)
            {
                if(mid!=right)  //bit swap doesn't work for i, j, if i and j are same variable
                {
                    nums[right]^=nums[mid];
                    nums[mid]^=nums[right];
                    nums[right]^=nums[mid];
                }
                right--;
            }
        }
    }
}