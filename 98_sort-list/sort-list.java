/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Java
@Datetime: 16-08-18 23:32
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
    private ListNode getMiddle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    private ListNode mergeTwoSortedList(ListNode n1, ListNode n2)
    {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while(n1!=null && n2!=null)
        {
            if(n1.val<n2.val)
            {
                current.next=n1;
                n1=n1.next;
            }
            else
            {
                current.next=n2;
                n2=n2.next;
            }
            current=current.next;
        }
        
        if(n1!=null)
        {
            current.next=n1;
        }
        else if(n2!=null)
        {
            current.next=n2;
        }
        
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) 
    {  
        if(head==null || head.next==null)
        {
            return head;
        }
        
        ListNode middle = getMiddle(head);
        ListNode rightHead = sortList(middle.next);
        middle.next=null;
        ListNode leftHead = sortList(head);
        
        return mergeTwoSortedList(leftHead, rightHead);
    }
}
