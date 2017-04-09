/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/insert-node-in-a-binary-search-tree
@Language: Java
@Datetime: 16-08-11 22:09
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
    public TreeNode insertNode(TreeNode root, TreeNode node) 
    {
        //divide conquer
        /*
        if(root==null)
        {
            return node;
        }
        
        //divide
        if(node.val<root.val)
        {
            root.left=insertNode(root.left, node);
        }
        else if(root.val<node.val)
        {
            root.right=insertNode(root.right, node);
        }
        //conquer
        return root;
        */
        
        //non-recursive
        if(root==null)
        {
            return node;
        }
        
        TreeNode current = root;
        while(true)
        {
            if(node.val<current.val)
            {
                if(current.left==null)
                {
                    current.left=node;
                    break;
                }
                else
                {
                    current=current.left;
                }
            }
            else if(current.val<node.val)
            {
                if(current.right==null)
                {
                    current.right=node;
                    break;
                }
                else
                {
                    current=current.right;
                }
            }
        }
        
        return root;
    }
}