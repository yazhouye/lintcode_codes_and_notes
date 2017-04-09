/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 16-08-14 16:43
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution 
{
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null)
        {
            return result;    
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int level=1;
        while(queue.size()!=0)
        {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<size; i++)
            {
                TreeNode head = queue.poll();
                if(level%2==1)
                {
                    list.add(head.val);
                }
                else
                {
                    list.add(0, head.val);
                }
                if(head.left!=null)
                {
                    queue.offer(head.left);
                }
                if(head.right!=null)
                {
                    queue.offer(head.right);
                }
            }
            result.add(list);
            level++;
        }
        
        return result;
    }
}