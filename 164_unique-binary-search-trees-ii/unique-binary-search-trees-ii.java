/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/unique-binary-search-trees-ii
@Language: Java
@Datetime: 16-08-15 04:40
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
    public List<TreeNode> generateTrees(int n) 
    {
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end)
    {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(start>end)
        {
            list.add(null);
            return list;
        }
        
        for(int i=start; i<=end; i++)
        {
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            
            for(TreeNode l: left)
            {
                for(TreeNode r: right)
                {
                    TreeNode current = new TreeNode(i);
                    current.left=l;
                    current.right=r;
                    list.add(current);
                }
            }
        }
        return list;
    }
}