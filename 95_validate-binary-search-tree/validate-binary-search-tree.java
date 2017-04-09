/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Java
@Datetime: 16-08-11 00:34
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
    public boolean isValidBST(TreeNode root) 
    {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode root, Integer lb, Integer ub)
    {
        if(root==null)
        {
            return true;
        }
        
        if(lb!=null && root.val<=lb)
        {
            return false;
        }
        if(ub!=null && root.val>=ub)
        {
            return false;
        }
        
        return isValidBST(root.left, lb, root.val) && isValidBST(root.right, root.val, ub);
    }
}