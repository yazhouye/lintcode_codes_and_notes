/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-inorder-traversal
@Language: Java
@Datetime: 16-08-20 19:56
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
    //divide conquer
    /*
    public ArrayList<Integer> inorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(root==null)
        {
            return result;
        }
        
        //divide
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);
        
        //conquer
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        
        return result;
    }
    */
    
    //iterative HashSet
    /*
    public ArrayList<Integer> inorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null)
        {
            return result;
        }
        
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(stack.size()!=0)
        {
            TreeNode head = stack.pop();
            if(set.contains(head))
            {
               result.add(head.val);
            }
            else
            {
                set.add(head);
                
                if(head.right!=null)
                {
                    stack.push(head.right);
                }
                stack.push(head);
                if(head.left!=null)
                {
                    stack.push(head.left);
                }
            }
        }
        
        return result;
    }
    */
    
    //iterative no HashSet
    public ArrayList<Integer> inorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode current = root;
        while(current!=null || stack.size()!=0)
        {
            while(current!=null)
            {
                stack.push(current);
                current=current.left;
            }
            
            current=stack.pop();
            result.add(current.val);
            current=current.right;
        }
        
        return result;
    }
}