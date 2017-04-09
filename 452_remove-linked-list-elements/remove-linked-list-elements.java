/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/remove-linked-list-elements
@Language: Java
@Datetime: 16-07-23 18:16
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution 
{
    public ListNode removeElements(ListNode head, int val) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode current = dummy;
        
        while(current.next!=null)
        {
            if(current.next.val==val)
            {
                current.next=current.next.next;
            }
            else
            {
                current=current.next;   
            }
        }
        
        
        return dummy.next;
    }
}