/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/k-sum-ii
@Language: Java
@Datetime: 16-08-23 07:23
*/

public class Solution 
{
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(A, k, target, A.length-1, list, result);
        return result;
    }
    
    private void helper(int[] A, int k, int target, int endIndex, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result)
    {
        if(k==0 && target==0) //contains endIndex==-1
        {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        if(endIndex<0)
        {
            return;
        }
        
        helper(A, k, target, endIndex-1, list, result);
        if(target-A[endIndex]>=0)
        {
            list.add(A[endIndex]);
            helper(A, k-1, target-A[endIndex], endIndex-1, list, result);
            list.remove(list.size()-1);
        }
    }
}