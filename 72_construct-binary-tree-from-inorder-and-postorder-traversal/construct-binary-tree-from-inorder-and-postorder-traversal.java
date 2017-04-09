/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal
@Language: Java
@Datetime: 16-08-14 16:36
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
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int iS, int iE, int[] postorder, int pS, int pE)
    {
        if(iS>iE)
        {
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[pE]);
        int index = inorderIndex(inorder, iS, iE, postorder[pE]);
        
        //divide
        TreeNode left = helper(inorder, iS, index-1, postorder, pS, index-1-iS+pS);
        TreeNode right = helper(inorder, index+1, iE, postorder, index-1-iS+pS+1, pE-1);
        
        //conquer
        node.left=left;
        node.right=right;
        
        return node;
    }
    
    private int inorderIndex(int[] inorder, int iS, int iE, int target)
    {
        for(int i=iS; i<=iE; i++)
        {
            if(inorder[i]==target)
            {
                return i;
            }
        }
        return -1;
    }
}