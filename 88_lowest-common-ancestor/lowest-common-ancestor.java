/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor
@Language: Java
@Datetime: 16-08-11 04:39
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) 
    {
        if(root==null)
        {
            return null;
        }
        if(root==A || root==B)
        {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if(left!=null && right!=null)
        {
            return root;
        }
        else if(left!=null)
        {
            return left;
        }
        else if(right!=null)
        {
            return right;
        }
        else
        {
            return null;
        }
    }
}