/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/n-queens-ii
@Language: Java
@Datetime: 16-08-07 04:59
*/

class Solution 
{
    public int totalNQueens(int n) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> positions = new ArrayList<Integer>();
        helper(positions, n, result);
        return result.size();
    }
    
    private void helper(List<Integer> positions, int n, List<List<Integer>> result)
    {
        if(positions.size()==n)
        {
            result.add(new ArrayList<Integer>(positions));
            return;
        }
        
        for(int i=0; i<n; i++)
        {
            if(!isValid(positions, i))
            {
                continue;
            }
            positions.add(i);
            helper(positions, n, result);
            positions.remove(positions.size()-1);
        }
    }
    
    private boolean isValid(List<Integer> positions, int position)
    {
        for(int i=0; i<positions.size(); i++)
        {
            if(position==positions.get(i))
            {
                return false;
            }
            if(positions.size()-i==Math.abs(position-positions.get(i)))
            {
                return false;
            }
        }
        return true;
    }
}

