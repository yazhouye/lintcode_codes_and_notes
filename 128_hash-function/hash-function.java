/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 16-08-21 19:53
*/

class Solution 
{
    public int hashCode(char[] key,int HASH_SIZE) 
    {
        long hashCode = 0;
        
        for(char c: key)
        {
            hashCode=(hashCode*33+(int)c)%HASH_SIZE;
        }
        
        return (int)hashCode;
    }
};