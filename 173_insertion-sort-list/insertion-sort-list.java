/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 16-08-19 00:32
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
    public ListNode insertionSortList(ListNode head) 
    {
        ListNode dummy = new ListNode(0);
        
        ListNode p = head;
        while(p!=null)
        {
            ListNode next = p.next;
            
            ListNode current = dummy;
            while(current.next!=null && p.val>current.next.val)
            {
                current=current.next;
            }
            p.next=current.next;
            current.next=p;
            
            p=next;
        }
        
        return dummy.next;
    }
}