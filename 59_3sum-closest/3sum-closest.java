/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/3sum-closest
@Language: Java
@Datetime: 16-03-20 22:29
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) 
    {
        Arrays.sort(numbers);
        
        int closest = Integer.MAX_VALUE/2; // otherwise it will overflow for opeartion (closet-target)
        
        for(int i=0; i<numbers.length; i++)
        {
            int m = i+1;
            int n = numbers.length-1;
            
            while(m<n)
            {
                int sum = numbers[i] + numbers[m] + numbers[n];
                
                if(Math.abs(sum-target) < Math.abs(closest-target))
                {
                    closest = sum;
                }
                
                if(sum<target)
                {
                    m++;
                }
                else if(sum>target)
                {
                    n--;
                }
                else
                {
                    return target;   
                }
            }
        }
        
        return closest;
    }
}
