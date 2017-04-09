/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/swap-nodes-in-pairs
@Language: Java
@Datetime: 16-08-19 00:04
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
    public ListNode swapPairs(ListNode head) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while(current.next!=null && current.next.next!=null)
        {
            ListNode first = current.next;
            ListNode last = current.next.next;
            ListNode nextFirst = current.next.next.next;
            current.next=last;
            last.next=first;
            first.next=nextFirst;
            current=first;
        }
        
        return dummy.next;
    }
}