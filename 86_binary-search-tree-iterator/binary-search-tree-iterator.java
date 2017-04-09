/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Java
@Datetime: 16-08-11 05:01
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator 
{
    private TreeNode current;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) 
    {
        current=root;
        stack = new Stack<TreeNode>();
    }

    public boolean hasNext() 
    {
        return current!=null || stack.size()!=0;
    }
    
    public TreeNode next() 
    {
        while(current!=null)
        {
            stack.push(current);
            current=current.left;
        }
        TreeNode next = stack.pop();
        current=next.right;
        return next;
    }
}