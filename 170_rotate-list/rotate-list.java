/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/rotate-list
@Language: Java
@Datetime: 16-07-25 04:12
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null)
        {
            return null;
        }
        
        ListNode current = head;
        int length=0;
        while(current!=null)
        {
            length++;
            current=current.next;
        }
        
        k%=length;
        
        if(k==0)
        {
            return head;
        }
        
        ListNode fast = head;
        for(int i=0; i<k; i++)
        {
            fast=fast.next;
        }
        
        ListNode slow = head;
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        ListNode newHead = slow.next;
        slow.next=null;
        fast.next=head;
        
        return newHead;
    }
}