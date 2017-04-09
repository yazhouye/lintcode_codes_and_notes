/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/kth-largest-element
@Language: Java
@Datetime: 16-07-26 21:16
*/

class Solution 
{
    public int kthLargestElement(int k, int[] nums) 
    {
        return helper(nums.length-k, nums, 0, nums.length-1);
    }
    
    private int helper(int index, int[] nums, int left, int right)
    {
        if(left==right)
        {
            return nums[left];
        }
        
        int position = partition(nums, left, right);
        if(position==index)
        {
            return nums[position];
        }
        else if(position<index)
        {
            return helper(index, nums, position, right);
        }
        else
        {
            return helper(index, nums, left, position-1);
        }
    }
    
    private int partition(int[] nums, int left, int right)
    {
        int pivot = nums[(left+right)/2];

        while(left<=right)
        {
            while(left<=right && nums[left]<pivot)
            {
                left++;
            }
            while(left<=right && nums[right]>pivot)
            {
                right--;
            }
            if(left<=right)
            {
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right--;
            }
        }
        return left;
    }
};