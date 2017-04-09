/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/minimum-depth-of-binary-tree
@Language: Java
@Datetime: 16-08-11 18:14
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
    public int minDepth(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        
        //divide
        int left = minDepth(root.left);
        int right =  minDepth(root.right);
        
        //conquer
        if(left==0 && right!=0) //go to one subtree
        {
            return right+1;
        }
        else if(left!=0 && right==0) //go to one subtree
        {
            return left+1;
        }
        else //no subtree or two subtree
        {
            return Math.min(left, right)+1; 
        }
    }
}