/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 16-07-27 21:15
*/

public class Solution 
{
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) 
    {
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<=numbers.length-3; i++)
        {
            if(i>0 && numbers[i]==numbers[i-1])
            {
                continue;
            }
            
            int start = i+1;
            int end = numbers.length-1;
            while(start<end)
            {
                if(numbers[i]+numbers[start]+numbers[end]<0)
                {
                    start++;
                }
                else if(numbers[i]+numbers[start]+numbers[end]>0)
                {
                    end--;
                }
                else
                {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[start]);
                    list.add(numbers[end]);
                    result.add(list);
                   
                    start++;
                    end--;
                    while (start < end && numbers[start] == numbers[start - 1]) 
                    {
						start++;
					}
					while (start < end && numbers[end] == numbers[end + 1]) 
					{
						end--;
					}
                }
            }
        }
        
        return result;
    }
}