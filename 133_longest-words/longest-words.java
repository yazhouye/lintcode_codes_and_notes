/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/longest-words
@Language: Java
@Datetime: 15-07-18 23:38
*/

class Solution 
{
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) 
    {
        ArrayList<String> longesWords = new ArrayList<String>();
        
        int maxLength=0;
        
        for(String s: dictionary)
        {
            if(s.length()==maxLength)
            {
                longesWords.add(s);
            }
            else if(s.length()>maxLength)
            {
                maxLength=s.length();
                longesWords.clear();
                longesWords.add(s);
            }
        }
        
        return longesWords;
    }
};
