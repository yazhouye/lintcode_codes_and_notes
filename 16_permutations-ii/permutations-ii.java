/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 16-08-09 05:57
*/

class Solution 
{
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) 
    {
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        if(nums==null)
        {
            return permutations;
        }
        permutations.add(new ArrayList<Integer>());
        
        for(Integer num: nums)
        {
            ArrayList<ArrayList<Integer>> morePermutations = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> permutation: permutations)
            {
                for(int i=0; i<=permutation.size(); i++)
                {
                    ArrayList<Integer> oneMorePermutation = new ArrayList<Integer>(permutation);
                    oneMorePermutation.add(i, num);
                    if(!morePermutations.contains(oneMorePermutation))
                    {
                        morePermutations.add(oneMorePermutation);   
                    }
                }
            }
            permutations=morePermutations;
        }
        return permutations;
    }
}
