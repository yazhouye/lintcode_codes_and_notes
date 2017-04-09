/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 16-07-23 00:05
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
    ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode dummy = new ListNode(0);   //1
        dummy.next=head;    //2
        ListNode fast = dummy;  //2
        
        for(int i=0; i<=n; i++)
        {
            fast=fast.next;
        }
        
        ListNode slow = dummy;  //2
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        slow.next=slow.next.next;
        
        return dummy.next;  //3
    }
}
