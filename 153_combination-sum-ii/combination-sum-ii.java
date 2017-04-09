/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 16-10-29 18:24
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        
        helper(num, 0, target, path, result);
        
        return result;
    }
    
    //backtracking recursion
    private void helper(int[] num, int startIndex, int target, List<Integer> path, List<List<Integer>> result) {
        
        if(target<0) {
            return;
        }
        
        if(target==0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        int previous = -1;
        for(int i=startIndex; i<num.length; i++) {
            if(previous!=-1 && num[i]==previous) {
                continue;
            }
            
            path.add(num[i]);
            helper(num, i+1, target-num[i], path, result);
            path.remove(path.size()-1); //backtracking
            
            previous=num[i];
        }
    }
}