/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Java
@Datetime: 16-08-20 20:01
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null)
        {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode previous=null;
        TreeNode current=null;
        
        while(stack.size()!=0)
        {
            current = stack.peek();
            if(previous==null || current==previous.left || current==previous.right)
            {
                if(current.left!=null)
                {
                    stack.push(current.left);
                }
                else if(current.right!=null)
                {
                    stack.push(current.right);
                }
                else
                {
                    result.add(current.val);
                    stack.pop();
                }
            }
            else if(previous==current.left)
            {
                if(current.right!=null)
                {
                    stack.push(current.right);
                }
                else
                {
                    result.add(current.val);
                    stack.pop();
                }
            }
            else if(previous==current.right)
            {
                result.add(current.val);
                stack.pop();
            }
            previous = current;
        }
        
        return result;
    }
}