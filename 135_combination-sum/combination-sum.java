/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 16-10-29 18:20
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        
        helper(candidates, 0, target, path, result);
        
        return result;
    }
    
    //backtracking recursion
    private void helper(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> result) {
        
        if(target<0)
        {
            return;
        }
        
        if(target==0)
        {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        int previous=-1;
        for(int i=index; i<candidates.length; i++)
        {
            if(previous!=-1 && candidates[i]==previous)
            {
                continue;
            }
            
            path.add(candidates[i]);
            //can be used multiple times, so i, not i+1
            helper(candidates, i, target-candidates[i], path, result);
            path.remove(path.size()-1);
            
            previous=candidates[i];
        }
    }
}