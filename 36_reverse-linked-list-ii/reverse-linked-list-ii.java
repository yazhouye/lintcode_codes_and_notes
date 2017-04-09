/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/reverse-linked-list-ii
@Language: Java
@Datetime: 16-08-18 23:44
*/

/**
 * Definition for ListNode
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
    private ListNode reverse(ListNode head)
    {
        ListNode current = head;
        ListNode previous = null;
        while(current!=null)
        {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
    
    public ListNode reverseBetween(ListNode head, int m , int n) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        ListNode leftEnd = null;
        ListNode middleEnd = null;
        
        int counter = 0;
        while(current!=null)
        {
            if(counter==m-1)
            {
                leftEnd=current;
            }
            if(counter==n)
            {
                middleEnd=current;
            }
            current=current.next;
            counter++;
        }
        
        ListNode middleStart = leftEnd.next;
        ListNode rightStart = middleEnd.next;
        
        middleEnd.next=null;
        leftEnd.next=reverse(middleStart);
        middleStart.next=rightStart;
        
        return dummy.next;
    }
}