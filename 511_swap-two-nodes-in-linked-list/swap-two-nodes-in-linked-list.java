/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Java
@Datetime: 16-08-19 01:01
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
    public ListNode swapNodes(ListNode head, int v1, int v2) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode previous = dummy;
        ListNode current = head;
        
        ListNode p1 = null;
        ListNode l1 = null;
        ListNode p2 = null;
        ListNode l2 = null;
        
        while(current!=null)
        {
            if(current.val==v1)
            {
                p1=previous;
                l1=current;
            }
            if(current.val==v2)
            {
                p2=previous;
                l2=current;
            }
            
            previous=current;
            current=current.next;
        }
        
        if(l1==null || l2==null)
        {
            return head;
        }
        
        if(l1.next==l2)
        {
            l1.next=l2.next;
            l2.next=l1;
            p1.next=l2;
        }
        else if(l2.next==l1)
        {
            l2.next=l1.next;
            l1.next=l2;
            p2.next=l1;
        }
        else
        {
            ListNode n1=l1.next;
            ListNode n2=l2.next;
            
            p1.next=l2;
            l2.next=n1;
            p2.next=l1;
            l1.next=n2;
        }
        
        return dummy.next;
    }
}