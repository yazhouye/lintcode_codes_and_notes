/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Java
@Datetime: 16-08-07 21:10
*/

public class Solution 
{
    public List<String> stringPermutation2(String str) 
    {
        List<String> permutations = new ArrayList<String>();
        permutations.add("");
        HashSet<String> set = new HashSet<String>();
        
        for(int i=0; i<str.length(); i++)
        {
            char c = str.charAt(i);
            List<String> morePermutations = new ArrayList<String>();
            for(String s: permutations)
            {
                for(int j=0; j<=s.length(); j++)
                {
                    String newS = s.substring(0, j)+c+s.substring(j, s.length());
                    if(!set.contains(newS))
                    {
                        morePermutations.add(newS);
                        set.add(newS);
                    }
                }
            }
            set.clear();
            permutations=morePermutations;
        }
        return permutations;
    }
}