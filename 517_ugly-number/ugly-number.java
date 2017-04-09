/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/ugly-number
@Language: Java
@Datetime: 16-07-28 21:33
*/

public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        /*
        if(num<=0) {
            return false;
        }
        
        if(num==1) {
            return true;
        }
        
        return (num%2==0 && isUgly(num/2))||(num%3==0 && isUgly(num/3))||(num%5==0 && isUgly(num/5));
        */
        
        
        if(num<=0) {
            return false;
        }
        
        while(num>=2 && num%2==0) {num/=2;}
        while(num>=3 && num%3==0) {num/=3;}
        while(num>=5 && num%5==0) {num/=5;}
        
        return num==1;
        
    }
}