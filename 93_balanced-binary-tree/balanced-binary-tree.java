/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Java
@Datetime: 16-08-10 21:30
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
    public boolean isBalanced(TreeNode root) 
    {
        return maxDepth(root)!=-1;
    }
    
    private int maxDepth(TreeNode root) //double functions: depth and isBalanced
    {
        if(root==null)
        {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(left==-1 || right==-1)
        {
            return -1;
        }
        
        if(Math.abs(left-right)>1)
        {
            return -1;
        }
        
        return Math.max(left, right)+1;
    }
}