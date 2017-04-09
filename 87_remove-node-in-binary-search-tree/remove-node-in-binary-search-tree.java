/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/remove-node-in-binary-search-tree
@Language: Java
@Datetime: 16-08-15 02:59
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
    public TreeNode removeNode(TreeNode root, int value) 
    {
        TreeNode previous = null;
        TreeNode current = root;
        while(current!=null)
        {
            if(value<current.val)
            {
                previous=current;
                current=current.left;
            }
            else if(value>current.val)
            {
                previous=current;
                current=current.right;
            }
            else
            {
                break;
            }
        }
        
        if(current==null)
        {
            return root;
        }
        
        TreeNode newCurrent=removeNode(current);
        
        if(previous==null)
        {
            return newCurrent;
        }
        
        if(previous.left==current)
        {
            previous.left=newCurrent;
        }
        else if(previous.right==current)
        {
            previous.right=newCurrent;
        }
        
        return root;
    }
    
    private TreeNode removeNode(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            return null;
        }
        else if(root.left!=null)
        {
            TreeNode oRight = root.right;
            TreeNode oLeft = root.left;
            TreeNode previous = null;
            TreeNode current = oLeft;
            while(current.right!=null)
            {
                previous = current;
                current=current.right;
            }
            if(previous!=null)
            {
                previous.right=current.left;
                current.left=oLeft;
            }
            current.right=oRight;
            return current;
        }
        else
        {
            TreeNode oRight = root.right;
            TreeNode oLeft = root.left;
            TreeNode previous = null;
            TreeNode current = oRight;
            while(current.left!=null)
            {
                previous=current;
                current=current.left;
            }
            if(previous!=null)
            {
                previous.left=current.right;
                current.right=oRight;
            }
            current.left=oLeft;
            return current;
        }
    }
}