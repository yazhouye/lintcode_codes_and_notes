/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Java
@Datetime: 16-08-11 19:21
*/

public class Solution 
{
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t)
    {
       if(s.length()!=t.length()) return false;
       
       int[] sCount = new int[256];
       int[] tCount = new int[256];
       
       for(int i=0; i<s.length(); i++)
       {
           sCount[s.charAt(i)]++;
           tCount[t.charAt(i)]++;
       }
       
       for(int i=0; i<256; i++)
       {
           if(sCount[i]!=tCount[i])
           return false;
       }
       
       return true;
    }
};
