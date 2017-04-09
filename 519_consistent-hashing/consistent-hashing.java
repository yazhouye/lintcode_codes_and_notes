/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/consistent-hashing
@Language: Java
@Datetime: 16-08-12 22:16
*/

public class Solution 
{
    public List<List<Integer>> consistentHashing(int n) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> initialList = new ArrayList<Integer>();
        initialList.add(0);
        initialList.add(359);
        initialList.add(1);
        result.add(initialList);
        
        for(int i=1; i<n; i++)
        {
            int maxIndex=0;
            for(int j=0; j<i; j++)
            {
                if(result.get(j).get(1)-result.get(j).get(0)>result.get(maxIndex).get(1)-result.get(maxIndex).get(0) || (result.get(j).get(1)-result.get(j).get(0)==result.get(maxIndex).get(1)-result.get(maxIndex).get(0) && result.get(j).get(2)<result.get(maxIndex).get(2)))
                {
                    maxIndex=j;
                }
            }
            int x=result.get(maxIndex).get(0);
            int y=result.get(maxIndex).get(1);
            result.get(maxIndex).set(1, (x+y)/2);
            List<Integer> list = new ArrayList<Integer>();
            list.add((x+y)/2+1);
            list.add(y);
            list.add(i+1);
            result.add(list);
        }
        return result;
    }
}