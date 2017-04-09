/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/count-1-in-binary
@Language: Java
@Datetime: 16-08-14 05:58
*/

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int counter=0;
        while(num!=0)
        {
            counter++;
            num&=(num-1);
        }
        return counter;
    }
};