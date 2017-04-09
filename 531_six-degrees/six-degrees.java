/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Java
@Datetime: 16-08-05 00:21
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution 
{
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) 
                          {
        if(s==t)
        {
            return 0;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        queue.add(s);
        set.add(s);
        
        int level=1;
        while(queue.size()!=0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                UndirectedGraphNode head = queue.poll();
                for(UndirectedGraphNode neighbor: head.neighbors)
                {
                    if(neighbor==t)
                    {
                        return level;
                    }
                    if(!set.contains(neighbor))
                    {
                        queue.add(neighbor);
                        set.add(neighbor);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}