/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 16-03-17 22:24
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) 
    {
        int count=0, candidate=0;
        
        for(int i=0; i<nums.size(); i++)
        {
           if(count == 0)
           {
               candidate=nums.get(i);
               count=1;
           }
           else if(candidate==nums.get(i))
           {
               count++;
           }
           else
           {
               count--;
           }
        }
        
        return candidate;
    }
}