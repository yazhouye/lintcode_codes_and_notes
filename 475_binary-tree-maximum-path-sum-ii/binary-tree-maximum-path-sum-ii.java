/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Java
@Datetime: 16-08-10 21:44
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
    public int maxPathSum2(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        
        int leftPathSum = maxPathSum2(root.left);
        int rightPathSum = maxPathSum2(root.right);
        
        return Math.max(0, Math.max(leftPathSum, rightPathSum))+root.val;
    }
}