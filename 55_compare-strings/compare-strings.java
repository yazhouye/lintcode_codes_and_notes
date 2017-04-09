/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 15-07-19 00:58
*/

public class Solution 
{
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) 
    {
        int[] aCount = new int[26];
        int[] bCount = new int[26];
        
        for(int i=0, j=0; i<A.length() || j<B.length(); i++, j++)
        {
            if(i>=A.length())
            {
                bCount[B.charAt(j)-'A']++;
            }
            else if(j>=B.length())
            {
                aCount[A.charAt(i)-'A']++;
            }
            else
            {
                aCount[A.charAt(i)-'A']++;
                bCount[B.charAt(j)-'A']++;
            }
        }
        
        for(int i=0; i<26; i++)
        {
            if(aCount[i]<bCount[i])
            return false;
        }
        
        return true;
    }
}
