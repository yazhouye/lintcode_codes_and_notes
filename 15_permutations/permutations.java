/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 16-08-09 05:55
*/

class Solution 
{
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) 
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
                    morePermutations.add(oneMorePermutation);
                }
            }
            permutations=morePermutations;
        }
        return permutations;
    }
}
