/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-preorder-traversal
@Language: Java
@Datetime: 16-08-10 21:39
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) 
    {
        /*
        ArrayList<Integer> list =  new ArrayList<Integer>();
        if(root==null)
        {
            return list;
        }
        
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        
        return list;
        */
        
        /*
        ArrayList<Integer> list =  new ArrayList<Integer>();
        helper(root, list);
        return list;
        */
        
        ArrayList<Integer> list =  new ArrayList<Integer>();
        if(root==null)
        {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(stack.size()!=0)
        {
            TreeNode head = stack.pop();
            list.add(head.val);
            if(head.right!=null)
            {
                stack.push(head.right);
            }
            if(head.left!=null)
            {
                stack.push(head.left);
            }
        }
        
        return list;
    }
    
    /*
    private void helper(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null)
        {
            return;
        }
        
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
    */
}