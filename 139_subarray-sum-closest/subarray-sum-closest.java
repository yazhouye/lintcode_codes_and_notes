/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/subarray-sum-closest
@Language: Java
@Datetime: 16-07-26 20:17
*/

public class Solution 
{
    public int[] subarraySumClosest(int[] nums) 
    {
        int[] prefix = new int[nums.length+1];
        prefix[0]=0;
        HashMap<Integer, Integer> prefixMap = new HashMap<Integer, Integer>();
        prefixMap.put(0, -1);
        
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++)
        {
            prefix[i+1]=prefix[i]+nums[i];
            if(prefixMap.containsKey(prefix[i+1]))
            {
                result[0]=prefixMap.get(prefix[i+1])+1;
                result[1]=i;
                return result;
            }
            prefixMap.put(prefix[i+1], i);
        }
        
        Arrays.sort(prefix);
        
        int min = prefix[prefix.length-1] - prefix[0];
        int prefix1 = prefix[0];
        int prefix2 = prefix[prefix.length-1];
        for(int i=0; i<prefix.length-1; i++)
        {
            if(prefix[i+1]-prefix[i]<min)
            {
                min=prefix[i+1]-prefix[i];
                prefix1=prefix[i];
                prefix2=prefix[i+1];
            }
        }
        
        result[0]=prefixMap.get(prefix1);
        result[1]=prefixMap.get(prefix2);
        Arrays.sort(result);
        result[0]++;
        return result;
    }
}
