/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/max-tree
@Language: Java
@Datetime: 16-08-22 17:23
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
    public TreeNode maxTree(int[] A) 
    {
        Stack<TreeNode> descendingStack = new Stack<TreeNode>();
        
        for(int item: A)
        {
            TreeNode current = new TreeNode(item);
            if(descendingStack.size()==0 || item<descendingStack.peek().val)
            {
                descendingStack.push(current);
            }
            else
            {
                TreeNode pre = descendingStack.pop();
                while(descendingStack.size()!=0 && item>descendingStack.peek().val)
                {
                    descendingStack.peek().right=pre;
                    pre=descendingStack.pop();
                }
                current.left=pre;
                descendingStack.push(current);
            }
        }
        
        while(descendingStack.size()>1)
        {
            TreeNode head = descendingStack.pop();
            descendingStack.peek().right=head;
        }
        
        return descendingStack.peek();
    }
}