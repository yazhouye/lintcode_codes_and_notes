/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 16-07-26 01:00
*/

public class Solution 
{
    public ArrayList<Integer> subarraySum(int[] nums) 
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> prefixSumMap = new HashMap<Integer, Integer>();
        prefixSumMap.put(0, -1);
        
        int prefixSum=0;
        for(int i=0; i<nums.length; i++)
        {
            prefixSum+=nums[i];
            if(prefixSumMap.containsKey(prefixSum))
            {
                result.add(prefixSumMap.get(prefixSum)+1);
                result.add(i);
                return result;
            }
            prefixSumMap.put(prefixSum, i);
        }
        
        return result;
    }
}