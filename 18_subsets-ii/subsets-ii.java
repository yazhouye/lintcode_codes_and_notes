/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 16-08-09 05:50
*/

class Solution 
{
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) 
    {
        int[] nums = new int[S.size()];
        for(int i=0; i<S.size(); i++)
        {
            nums[i]=S.get(i);
        }
        
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        
        for(int num: nums)
        {
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: subsets)
            {
                ArrayList<Integer> oneMoreSubet = new ArrayList<Integer>(subset);
                oneMoreSubet.add(num);
                if(!subsets.contains(oneMoreSubet))
                {
                    moreSubsets.add(oneMoreSubet);
                }
            }
            subsets.addAll(moreSubsets);
        }
        return subsets;
    }
}
