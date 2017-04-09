/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal
@Language: Java
@Datetime: 16-08-14 16:30
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
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int pS, int pE, int[] inorder, int iS, int iE)
    {
        if(pS>pE)
        {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[pS]);
        int index = inorderIndex(inorder, iS, iE, preorder[pS]);
        
        //divide
        TreeNode left = helper(preorder, pS+1, pS+index-iS, inorder, iS, index-1);
        TreeNode right = helper(preorder, pS+index-iS+1, pE, inorder, index+1, iE);
        
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