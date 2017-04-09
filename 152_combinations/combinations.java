/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 16-08-17 10:20
*/

public class Solution 
{
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for(int i=1; i<=k; i++)
        {
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            HashSet<List<Integer>> newSet = new HashSet<List<Integer>>();
            for(List<Integer> list: result)
            {
                for(int j=1; j<=n; j++)
                {
                    if(list.contains(j))
                    {
                        continue;
                    }
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(j);
                    Collections.sort(newList);
                    if(!newSet.contains(newList))
                    {
                        newSet.add(newList);
                        newResult.add(newList);
                    }
                }
            }
            newSet.clear();
            result=newResult;
        }
        
        return result;
    }
}