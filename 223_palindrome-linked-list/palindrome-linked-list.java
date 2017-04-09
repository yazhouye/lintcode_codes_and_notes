/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/palindrome-linked-list
@Language: Java
@Datetime: 16-07-25 03:48
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
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null)
        {
            return true;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode halfHead = slow.next;
        slow.next=null;
        
        halfHead=reverse(halfHead);
        
        while(halfHead!=null)
        {
            if(head.val!=halfHead.val)
            {
                return false;
            }
            head=head.next;
            halfHead=halfHead.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) 
    {
        ListNode previous = null;
        ListNode current = head;
        
        while(current!=null)
        {
            ListNode next = current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        
        return previous;
    }
}