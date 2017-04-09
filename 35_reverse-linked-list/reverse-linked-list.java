/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/reverse-linked-list
@Language: Java
@Datetime: 16-08-18 23:03
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
 */ 
public class Solution 
{
    public ListNode reverse(ListNode head) 
    {
        ListNode previous=null;
        ListNode current=head;
        
        while(current!=null)
        {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
}
