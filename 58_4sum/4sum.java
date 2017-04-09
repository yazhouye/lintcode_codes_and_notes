/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/4sum
@Language: Java
@Datetime: 16-07-27 21:24
*/

public class Solution 
{
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(numbers);
        for(int i=0; i<=numbers.length-4; i++)
        {
            if(i!=0 && numbers[i]==numbers[i-1])
            {
                continue;
            }
            for(int j=i+1; j<=numbers.length-3; j++)
            {
                if(j!=i+1 && numbers[j]==numbers[j-1])
                {
                    continue;
                }
                
                int start = j+1;
                int end = numbers.length-1;
                while(start<end)
                {
                    if(numbers[i]+numbers[j]+numbers[start]+numbers[end]<target)
                    {
                        start++;
                    }
                    else if(numbers[i]+numbers[j]+numbers[start]+numbers[end]>target)
                    {
                        end--;
                    }
                    else
                    {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[start]);
                        list.add(numbers[end]);
                        result.add(list);
                        
                        start++;
                        end--;
                        while(start<end && numbers[start]==numbers[start-1])
                        {
                            start++;
                        }
                        while(start<end && numbers[end]==numbers[end+1])
                        {
                            end--;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}