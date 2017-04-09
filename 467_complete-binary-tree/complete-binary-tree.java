/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/complete-binary-tree
@Language: Java
@Datetime: 16-08-11 19:04
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
    /*
    class TreeType
    {
        int height;
        boolean isCompleteTree;
        boolean isFullTree;
        public TreeType(int height, boolean isCompleteTree, boolean isFullTree)
        {
            this.height=height;
            this.isCompleteTree=isCompleteTree;
            this.isFullTree=isFullTree;
        }
    }
    
    public boolean isComplete(TreeNode root) 
    {
        return helper(root).isCompleteTree;
    }
    
    private TreeType helper(TreeNode root)
    {
        if(root==null)
        {
            return new TreeType(0, true, true);
        }
        
        TreeType left = helper(root.left);
        TreeType right = helper(root.right);

        if(left.height==right.height)
        {
            if(left.isFullTree && right.isCompleteTree)
            {
                return new TreeType(left.height+1, true, right.isFullTree);   
            }
            else
            {
                return new TreeType(-1, false, false);
            }
        }
        else if(left.height==right.height+1)
        {
            if(left.isCompleteTree && right.isFullTree)
            {
                return new TreeType(left.height+1, true, false);   
            }
            else
            {
                return new TreeType(-1, false, false);
            }
        }
        else
        {
            return new TreeType(-1, false, false);
        }
    }
    */
    
    public boolean isComplete(TreeNode root)
    {
        if(root==null)
        {
            return true;
        }
        
        TreeNode current = root;
        int rightLevel=0;
        while(current!=null)
        {
            rightLevel++;
            current=current.right;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i=1;
        while(i<rightLevel)
        {
            int size = queue.size();
            for(int j=0; j<size; j++)
            {
                TreeNode head = queue.poll();
                if(head.left==null)
                {
                    return false;
                }
                queue.offer(head.left);
                if(head.right==null)
                {
                    return false;
                }
                queue.offer(head.right);
            }
            i++;
        }
        
        ArrayList<TreeNode> lastLevel = new ArrayList<TreeNode>();
        while(queue.size()!=0)
        {
            lastLevel.add(queue.peek().left);
            lastLevel.add(queue.peek().right);
            queue.poll();
        }
        
        boolean hasNull=false;
        for(TreeNode node: lastLevel)
        {
            if(node!=null && (node.left!=null || node.right!=null))
            {
                return false;
            }
            if(node==null)
            {
                hasNull=true;
            }
            else
            {
                if(hasNull)
                {
                    return false;
                }
            }
        }
        return true;
    }
}