/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/linked-list-cycle-ii
@Language: Java
@Datetime: 16-08-18 23:48
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
    public ListNode detectCycle(ListNode head) 
    {  
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode hitPoint = null;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                hitPoint = slow;
                break;
            }
        }
        
        if(hitPoint==null)
        {
            return null;
        }
        
        fast=head;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
