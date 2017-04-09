/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/update-bits
@Language: Java
@Datetime: 16-08-15 04:00
*/

class Solution 
{
    public int updateBits(int n, int m, int i, int j) 
    {
        int max = ~0;
        if (j == 31)    //important, max
            j = max;
        else
            j = (1 << (j + 1)) - 1;
        int left = max - j;
	    int right = ((1 << i) - 1);
        int mask = left | right;
        return (n&mask)|(m<<i);
    }
}
