/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Java
@Datetime: 16-08-11 04:54
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null)
        {
            return result;
        }
        
        //bfs
        /*
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.size()!=0)
        {
            int size=queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<size; i++)
            {
                TreeNode head = queue.poll();
                list.add(head.val);
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
        }
        return result;
        */
        
        //dfs
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        HashMap<TreeNode, Integer> levelMap = new HashMap<TreeNode, Integer>();
        levelMap.put(root, 0);
        while(stack.size()!=0)
        {
            TreeNode head = stack.pop();
            int level = levelMap.get(head);
            if(level==result.size())
            {
                result.add(new ArrayList<Integer>());
            }
            result.get(level).add(head.val);
            if(head.right!=null)
            {
                stack.push(head.right);
                levelMap.put(head.right, level+1);
            }
            if(head.left!=null)
            {
                stack.push(head.left);
                levelMap.put(head.left, level+1);
            }
        }
        return result;
    }
}