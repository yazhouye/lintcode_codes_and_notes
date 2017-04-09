/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/single-number
@Language: Java
@Datetime: 16-08-17 05:38
*/

public class Solution 
{
    public int singleNumber(int[] A) 
    {
        int mark=0;
        for(int i: A)
        {
            mark^=i;
        }
        return mark;
    }
}