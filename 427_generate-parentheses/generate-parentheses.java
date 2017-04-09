/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/generate-parentheses
@Language: Java
@Datetime: 16-08-05 22:40
*/

public class Solution 
{
    public ArrayList<String> generateParenthesis(int n) 
    {
        ArrayList<String> result = new ArrayList<String>();
        helper("", n, n, result);
        return result;
    }
    
    private void helper(String s, int leftNumber, int rightNumber, ArrayList<String> result)
    {
        if(leftNumber==0 && rightNumber==0)
        {
            result.add(new String(s));
            return;
        }
        
        if(leftNumber>0)
        {
            helper(s+"(", leftNumber-1, rightNumber, result);
        }
        if(rightNumber>0 && rightNumber>leftNumber)
        {
            helper(s+")", leftNumber, rightNumber-1, result);
        }
    }
}