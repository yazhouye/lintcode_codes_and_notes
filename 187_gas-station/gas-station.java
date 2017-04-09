/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/gas-station
@Language: Java
@Datetime: 16-08-17 20:20
*/

public class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        //brute force O(n^2)
        int remain=0;
        for(int index=0; index<gas.length; index++)
        {
            remain=0;
            int i=index;
            while(i/gas.length==0 || (i/gas.length==1 && i%gas.length<index))
            {
                remain+=gas[i%gas.length]-cost[i%gas.length];
                if(remain<0)
                {
                    break;
                }
                i++;
            }
            if(i/gas.length==1 && i%gas.length==index)
            {
                return index;
            }
        }
        
        return -1;
        
        //greedy
        /*
        int index = 0;
        int remain = 0;
        int sum = 0;
        for(int i=0; i<gas.length; i++)
        {
            sum+=gas[i]-cost[i];
            
            remain+=gas[i]-cost[i];
            if(remain<0)
            {
               remain=0;
               index=i+1;
            }
        }
        
        return sum >= 0 ? index : -1;
        */
    }
}