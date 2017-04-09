/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 16-08-05 18:28
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution 
{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if(node==null)
        {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        
        while(queue.size()!=0)  //clone self
        {
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode neighbor: head.neighbors)
            {
                if(!map.containsKey(neighbor))
                {
                    queue.add(neighbor);
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                }
            }
        }
        
        for(Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry: map.entrySet())  //clone neighbors
        {
            for(UndirectedGraphNode neighbor: entry.getKey().neighbors)
            {
                entry.getValue().neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}