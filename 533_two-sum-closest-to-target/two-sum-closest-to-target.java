/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/two-sum-closest-to-target
@Language: Java
@Datetime: 16-08-20 19:42
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        int start=0;
        int end=nums.length-1;
        while(start<end)
        {
            if(nums[start]+nums[end]<target)
            {
                min=Math.min(min, target-(nums[start]+nums[end]));
                start++;
            }
            else if(nums[start]+nums[end]>target)
            {
                min=Math.min(min, nums[start]+nums[end]-target);
                end--;
            }
            else
            {
                return 0;
            }
        }
        
        return min;
    }
}