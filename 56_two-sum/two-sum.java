/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/two-sum
@Language: Java
@Datetime: 16-09-14 18:23
*/

public class Solution 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++)
        {
            if(map.containsKey(target-numbers[i]))
            {
                result[0]=map.get(target-numbers[i])+1;
                result[1]=i+1;
                return result;
            }
            map.put(numbers[i], i);
        }
        
        return result;
    }
}