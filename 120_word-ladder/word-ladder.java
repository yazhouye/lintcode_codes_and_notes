/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 16-08-07 20:35
*/

public class Solution 
{
    public int ladderLength(String start, String end, Set<String> dict) 
    {
        if(start.equals(end))
        {
            return 1;
        }
        
        dict.add(end);
        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        set.add(start);
        
        int level=2;
        while(queue.size()!=0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                String head = queue.poll();
                ArrayList<String> list = oneCharDiffList(head);
                for(String s: list)
                {
                    if(s.equals(end))
                    {
                        return level;
                    }
                    if(dict.contains(s) && !set.contains(s))
                    {
                        queue.add(s);
                        set.add(s);   
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
    private ArrayList<String> oneCharDiffList(String s)
    {
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<s.length(); i++)
        {
            for(char c='a'; c<='z'; c++)
            {
                String newS = s.substring(0, i)+c+s.substring(i+1, s.length()); 
                if(!newS.equals(s))
                {
                    list.add(newS);
                }
            }
        }
        return list;
    }
}