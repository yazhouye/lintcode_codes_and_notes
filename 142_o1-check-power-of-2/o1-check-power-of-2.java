/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/o1-check-power-of-2
@Language: Java
@Datetime: 16-08-10 18:24
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) 
    {
        return n > 0 && (n & (n-1)) == 0 ? true : false;
    }
};