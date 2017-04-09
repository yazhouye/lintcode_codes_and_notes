/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Java
@Datetime: 16-08-23 04:51
*/

public class Solution 
{
    public int longestConsecutive(int[] num) 
    {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int item: num)
        {
            set.add(item);
        }
        
        int longest=1;
        
        for(int item: num)
        {
            if(!set.contains(item))
            {
                continue;
            }
            
            set.remove(item);
            
            int left = item-1;
            while(set.contains(left))
            {
                set.remove(left);
                left--;
            }
            
            int right = item+1;
            while(set.contains(right))
            {
                set.remove(right);
                right++;
            }
            
            longest=Math.max(longest, right-left-1);
        }
        
        return longest;
    }
}