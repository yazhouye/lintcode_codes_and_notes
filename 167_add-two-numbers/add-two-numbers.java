/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 16-08-19 00:37
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
    public ListNode addLists(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        boolean carry = false;
        while(l1!=null || l2!=null || carry)
        {
            int val=0;
            if(l1!=null)
            {
                val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                val+=l2.val;
                l2=l2.next;
            }
            if(carry)
            {
                val+=1;
            }
            
            carry = val/10 == 1 ? true:false;
            
            ListNode newNode = new ListNode(val%10);
            current.next=newNode;
            current=current.next;
        }
        
        return dummy.next;
    }
}