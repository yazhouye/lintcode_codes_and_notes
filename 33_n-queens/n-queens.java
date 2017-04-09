/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Java
@Datetime: 16-08-07 05:21
*/

class Solution 
{
    public ArrayList<ArrayList<String>> solveNQueens(int n) 
    {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        List<Integer> positions = new ArrayList<Integer>();
        helper(positions, n, result);
        return result;
    }
    
    private void helper(List<Integer> positions, int n, ArrayList<ArrayList<String>> result)
    {
        if(positions.size()==n)
        {
            result.add(draw(positions));
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
    
    private ArrayList<String> draw(List<Integer> positions)
    {
        ArrayList<String> result = new ArrayList<String>();
        
        for(int i=0; i<positions.size(); i++)
        {
            String s = "";
            for(int j=0; j<positions.size(); j++)
            {
                if(j==positions.get(i))
                {
                    s+="Q";
                }
                else
                {
                    s+=".";
                }
            }
            result.add(s);
        }
        return result;
    }
}