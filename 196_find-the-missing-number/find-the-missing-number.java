/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/find-the-missing-number
@Language: Java
@Datetime: 16-08-10 10:36
*/

public class Solution 
{
    public int findMissing(int[] nums) 
    {
        int sum = 0;
        for(int item: nums)
        {
            sum+=item;
        }
        
        return (1+nums.length)*nums.length/2-sum;
    }
}