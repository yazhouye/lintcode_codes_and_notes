/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Java
@Datetime: 16-08-14 16:51
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
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) 
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root, k1, k2, list);
        return list;
    }
    
    private void helper(TreeNode root, int k1, int k2, ArrayList<Integer> list)
    {
        if(root==null)
        {
            return;
        }
        
        //divide
        if(k1<root.val)
        {
            helper(root.left, k1, k2, list);
        }
        //conquer
        if(root.val>=k1 && root.val<=k2)
        {
            list.add(root.val);
        }
        //divide
        if(root.val<k2)
        {
            helper(root.right, k1, k2, list);
        }
    }
}