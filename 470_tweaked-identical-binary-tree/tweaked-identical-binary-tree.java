/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/tweaked-identical-binary-tree
@Language: Java
@Datetime: 16-08-11 17:05
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
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) 
    {
        if(a==null && b==null)
        {
            return true;
        }
        else if(a==null)
        {
            return false;
        }
        else if(b==null)
        {
            return false;
        }
        
        if(a.val!=b.val)
        {
            return false;
        }
        
        //divide
        //conquer
        return (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) || (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left));
    }
}