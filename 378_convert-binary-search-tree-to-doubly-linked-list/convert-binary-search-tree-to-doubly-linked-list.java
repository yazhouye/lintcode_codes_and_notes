/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Java
@Datetime: 16-08-19 01:05
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution 
{
    public DoublyListNode bstToDoublyList(TreeNode root) 
    {  
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        
        DoublyListNode head=null;
        DoublyListNode previous=null;
        DoublyListNode currentNew=null;
        while(current!=null || stack.size()!=0)
        {
            while(current!=null)
            {
                stack.push(current);
                current=current.left;
            }
            
            current = stack.pop();
            DoublyListNode newNode = new DoublyListNode(current.val);
            if(previous!=null)
            {
                previous.next=newNode;
                newNode.prev=previous;
            }
            else
            {
                head=newNode;
            }
            previous=newNode;
            
            current=current.right;
        }
        
        return head;
    }
}
