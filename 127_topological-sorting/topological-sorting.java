/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 16-08-22 17:46
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution 
{
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) 
    {
        HashMap<DirectedGraphNode, Integer> indegreeMap = new HashMap<DirectedGraphNode, Integer>();
        
        for(DirectedGraphNode node: graph)
        {
            if(!indegreeMap.containsKey(node))
            {
                indegreeMap.put(node, 0);
            }
            for(DirectedGraphNode neighbor: node.neighbors)
            {
                if(!indegreeMap.containsKey(neighbor))
                {
                    indegreeMap.put(neighbor, 1);
                }
                else
                {
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor)+1);
                }
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        for(DirectedGraphNode node: graph)
        {
            if(indegreeMap.get(node)==0)
            {
                queue.add(node);
            }
        }
        
        while(queue.size()!=0)
        {
            DirectedGraphNode head = queue.poll();
            result.add(head);
            for(DirectedGraphNode neighbor: head.neighbors)
            {
                indegreeMap.put(neighbor, indegreeMap.get(neighbor)-1);
                if(indegreeMap.get(neighbor)==0)
                {
                    queue.add(neighbor);
                }
            }
        }
        
        return result;
    }
}