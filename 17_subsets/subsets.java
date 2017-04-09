/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 16-08-09 05:45
*/

class Solution 
{
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) 
    {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        Arrays.sort(nums);
        for(int num: nums)
        {
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: subsets)
            {
                ArrayList<Integer> oneMoreSubset = new ArrayList<Integer>(subset);
                oneMoreSubset.add(num);
                moreSubsets.add(oneMoreSubset);
            }
            subsets.addAll(moreSubsets);
        }
        return subsets;
    }
}