/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Java
@Datetime: 16-08-17 23:49
*/

public class Solution 
{
    //fancy idea
    public int[] nextPermutation(int[] nums) 
    {
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
        {
            i--;
        }
        if(i==-1)
        {
            swap(nums, 0, nums.length-1);
        }
        else
        {
            int j=i+2;
            while(j<nums.length && nums[j]>nums[i])
            {
                j++;
            }
            j--;
            
            nums[i]^=nums[j];
            nums[j]^=nums[i];
            nums[i]^=nums[j];
            
            swap(nums, i+1, nums.length-1);
        }
        
        return nums;
    }
    
    private void swap(int[] nums, int i, int j)
    {
        while(i<j)
        {
            nums[i]^=nums[j];
            nums[j]^=nums[i];
            nums[i]^=nums[j];
            
            i++;
            j--;
        }
    }
}