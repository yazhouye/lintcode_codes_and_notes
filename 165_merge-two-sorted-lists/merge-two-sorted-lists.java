/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-lists
@Language: Java
@Datetime: 16-07-23 20:06
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {   
        ListNode dummy = new ListNode(0);   //1
        ListNode current = dummy;   //2
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                current.next=l1;
                l1=l1.next;
            }
            else
            {
                current.next=l2;
                l2=l2.next;
            }
            current=current.next;
        }
        
        if(l1!=null)
        {
            current.next=l1;
        }
        else if(l2!=null)
        {
            current.next=l2;
        }
        
        return dummy.next;  //3
    }
}