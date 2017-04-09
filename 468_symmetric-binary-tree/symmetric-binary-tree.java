/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/symmetric-binary-tree
@Language: Java
@Datetime: 16-08-11 17:12
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
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null)
        {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode A, TreeNode B)
    {
        if(A==null && B==null)
        {
            return true;   
        }
        else if(A==null || B==null || A.val!=B.val)
        {
            return false;
        }
        
        return helper(A.left, B.right) && helper(A.right, B.left);
    }
}