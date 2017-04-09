/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/data-stream-median
@Language: Java
@Datetime: 16-04-02 21:17
*/

public class Solution 
{
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) 
    {
        PriorityQueue<Integer> descendingQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> ascendingQueue = new PriorityQueue<Integer>();
        
        int[] medianNums = new int[nums.length];
        
        int median = nums[0];
        medianNums[0] = median;
        
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]<=median)
            {
                descendingQueue.add(-nums[i]);  //negative reverse order
            }
            else                
            {
                ascendingQueue.add(nums[i]);
            }
            
            if(descendingQueue.size() > ascendingQueue.size())
            {
                ascendingQueue.add(median);
                median = -descendingQueue.poll();
            }
            else if(descendingQueue.size() + 1 < ascendingQueue.size())
            {
                descendingQueue.add(-median);
                median = ascendingQueue.poll();
            }
            
            medianNums[i]=median;
        }
        
        return medianNums;
    }
}