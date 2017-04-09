/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 16-08-11 06:18
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
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(root, target, list, result);
        return result;
    }
    
    private void helper(TreeNode root, int target, List<Integer> list, List<List<Integer>> result)
    {
        if(root==null)
        {
            return;
        }
        
        if(root.left==null && root.right==null)
        {
            if(target==root.val)
            {
                list.add(root.val);
                result.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);   
            }
            return;
        }
        
        list.add(root.val);
        helper(root.left, target-root.val, list, result);
        list.remove(list.size()-1);
        
        list.add(root.val);
        helper(root.right, target-root.val, list, result);
        list.remove(list.size()-1);
    }
}