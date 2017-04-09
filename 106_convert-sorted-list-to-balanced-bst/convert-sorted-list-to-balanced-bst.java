/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/convert-sorted-list-to-balanced-bst
@Language: Java
@Datetime: 16-08-18 22:23
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
    private int getSize(ListNode head)
    {
        int counter=0;
        while(head!=null)
        {
            counter++;
            head=head.next;
        }
        return counter;
    }
    
    public TreeNode sortedListToBST(ListNode head) 
    {  
        int size = getSize(head);
        current = head;
        return sortedListToBST(size);
    }
    
    private ListNode current;
    private TreeNode sortedListToBST(int size)
    {
        if(size==0)
        {
            return null;
        }
        
        TreeNode left = sortedListToBST(size/2);
        TreeNode root = new TreeNode(current.val);
        current=current.next;
        TreeNode right = sortedListToBST(size-1-size/2);
        
        root.left=left;
        root.right=right;
        return root;
    }
}
