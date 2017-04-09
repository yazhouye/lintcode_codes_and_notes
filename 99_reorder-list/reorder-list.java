/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/reorder-list
@Language: Java
@Datetime: 16-08-18 23:16
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
    private ListNode findMiddle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode current = head;
        ListNode previous = null;
        
        while(current!=null)
        {
            ListNode next = current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        
        return previous;
    }
    
    private void mergeOneByOne(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while(l1!=null && l2!=null)
        {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
            
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        
        if(l1!=null)
        {
            current.next=l1;
        }
        else if(l2!=null)
        {
            current.next=l2;
        }
    }
    
    public void reorderList(ListNode head) 
    {  
        if(head==null)
        {
            return;
        }
        
        ListNode leftEnd = findMiddle(head);
        ListNode rightStart = leftEnd.next;
        leftEnd.next=null;
        ListNode newRightStart = reverse(rightStart);
        mergeOneByOne(head, newRightStart);
    }
}
