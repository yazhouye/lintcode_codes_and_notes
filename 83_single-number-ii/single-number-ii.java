/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/single-number-ii
@Language: Java
@Datetime: 16-08-23 08:20
*/

public class Solution 
{
    public int singleNumberII(int[] A) 
    {
        if (A == null || A.length == 0) 
        {
            return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) 
        {
            for(int item: A) 
            {
                bits[i] += item >> i & 1;
                bits[i] %= 3;
            }

            result |= (bits[i] << i);
        }
        return result;
    }
}