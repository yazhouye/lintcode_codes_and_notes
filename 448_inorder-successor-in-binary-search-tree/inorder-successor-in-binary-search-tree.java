/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Java
@Datetime: 16-08-11 00:54
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution 
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) 
    {
        if(root==null || p==null)
        {
            return null;
        }
        
        if(p.right!=null)
        {
            TreeNode current = p.right;
            while(current.left!=null)
            {
                current=current.left;
            }
            return current;
        }
        else
        {
            TreeNode lastLeftParent = null;
            while(root!=null)
            {
                if(p.val<root.val)
                {
                    lastLeftParent = root;
                    root=root.left;
                }
                else if(root.val<p.val)
                {
                    root=root.right;
                }
                else
                {
                    break;
                }
            }
            return root==null ? null:lastLeftParent;
        }
    }
}