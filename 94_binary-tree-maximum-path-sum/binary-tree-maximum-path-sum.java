/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 16-08-10 22:38
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
    public int maxPathSum(TreeNode root) 
    {
        if(root==null)
        {
            return Integer.MIN_VALUE;   //important
        }
        
        int leftMaxPathSum = maxPathSum(root.left);
        int rightMaxPathSum = maxPathSum(root.right);
        
        int leftMaxPathSum2 = maxPathSum2(root.left);
        int rightMaxPathSum2 = maxPathSum2(root.right);
        
        int max = Math.max(leftMaxPathSum, rightMaxPathSum);
        int max2 = Math.max(Math.max(leftMaxPathSum2, rightMaxPathSum2), leftMaxPathSum2+rightMaxPathSum2);  //important: one path or two paths
        
        return Math.max(max, Math.max(max2, 0)+root.val);    //at least one node
    }
    
    private int maxPathSum2(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
        int leftMaxPathSum2 = maxPathSum2(root.left);
        int rightMaxPathSum2 = maxPathSum2(root.right);
        
        return Math.max(0, Math.max(leftMaxPathSum2, rightMaxPathSum2))+root.val;
    }
}