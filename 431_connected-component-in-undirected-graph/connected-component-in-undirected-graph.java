/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/connected-component-in-undirected-graph
@Language: Java
@Datetime: 16-08-05 16:57
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution 
{
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) 
    {
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(UndirectedGraphNode node: nodes)
        {
            if(!set.contains(node))
            {
                bfs(node, set, result);
            }
        }
        return result;
    }
    
    private void bfs(UndirectedGraphNode node, HashSet<UndirectedGraphNode> set, List<List<Integer>> result)
    {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        List<Integer> list = new ArrayList<Integer>();
        list.add(node.label);
        set.add(node);
        
        while(queue.size()!=0)
        {
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode neighbor: head.neighbors)
            {
                if(!set.contains(neighbor))
                {
                    queue.add(neighbor);
                    set.add(neighbor);
                    list.add(neighbor.label);
                }
            }
        }
        Collections.sort(list);
        result.add(list);
    }
}