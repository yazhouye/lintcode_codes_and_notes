/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 16-08-10 10:06
*/

public class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
        if(nums==null || nums.length==0)
        {
            return 0;            
        }
        
        int p1=0;
        for(int p2=1; p2<nums.length; p2++)
        {
            if(nums[p2]!=nums[p1])
            {
                nums[++p1]=nums[p2];
            }
        }
        return p1+1;
    }
}