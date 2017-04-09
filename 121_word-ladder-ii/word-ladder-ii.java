/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Java
@Datetime: 16-08-23 08:11
*/

public class Solution 
{
    public List<List<String>> findLadders(String start, String end, Set<String> dict) 
    {
        dict.add(end);
        HashMap<String, Integer> levelMap = bfs(start, end, dict);
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(start);
        dfs(start, end, list, result, dict, levelMap);
        return result;
    }
    
    private void dfs(String current, String end, List<String> list, List<List<String>> result, Set<String> dict, HashMap<String, Integer> levelMap)  //non-recursive method is not applicable
        /*!!!!! important
        *difference between normal DFS and recursion backtracking DFS
        *normal DFS: traverse each node, get each node once
        *recursion backtracking DFS: traverse each path, get each node multiple times
        */
    {
        if(current.equals(end))
        {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        ArrayList<String> neighhourList = oneCharDiffList(current);
        for(String neighhour: neighhourList)
        {
            if(dict.contains(neighhour) && levelMap.get(neighhour)==levelMap.get(current)+1)
            {
                list.add(neighhour);    //backtracking
                dfs(neighhour, end, list, result, dict, levelMap);
                list.remove(list.size()-1); //backtracking
            }
        }
    }
    
    private HashMap<String, Integer> bfs(String start, String end, Set<String> dict)
    {
        HashMap<String, Integer> levelMap = new HashMap<String, Integer>();
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        queue.add(start);
        set.add(start);
        int level=1;
        
        while(queue.size()!=0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                String head = queue.poll();
                levelMap.put(head, level);
                ArrayList<String> list = oneCharDiffList(head);
                for(String s: list)
                {
                    if(dict.contains(s) && !set.contains(s))
                    {
                        queue.add(s);
                        set.add(s);
                    }
                }
            }
            level++;
        }
        
        return levelMap;
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