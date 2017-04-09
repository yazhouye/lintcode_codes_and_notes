/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list
@Language: Java
@Datetime: 16-07-23 20:03
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
    public static ListNode deleteDuplicates(ListNode head) 
    { 
        if(head==null)
        {
            return null;
        }
        
        ListNode current = head;
        
        while(current.next!=null)
        {
            if(current.val==current.next.val)
            {
                current.next=current.next.next;
            }
            else
            {
                current=current.next;
            }
        }
        
        return head;
    }  
}