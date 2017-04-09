/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/identical-binary-tree
@Language: Java
@Datetime: 16-08-11 17:08
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
    public boolean isIdentical(TreeNode a, TreeNode b) 
    {
        if(a==null && b==null)
        {
            return true;
        }
        else if(a==null || b==null || a.val!=b.val)
        {
            return false;
        }
        
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}