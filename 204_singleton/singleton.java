/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/singleton
@Language: Java
@Datetime: 16-08-18 06:09
*/

class Solution 
{
    private Solution()
    {
        
    }
    private static Solution instance = null;
    public static Solution getInstance() 
    {
        if(instance==null)
        {
            instance = new Solution();
        }
        return instance;
    }
};