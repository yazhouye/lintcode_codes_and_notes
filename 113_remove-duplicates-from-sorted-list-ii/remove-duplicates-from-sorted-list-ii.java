/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list-ii
@Language: Java
@Datetime: 16-08-18 22:09
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
        ListNode dummy = new ListNode(0);   //1
        dummy.next=head;    //2
        ListNode previous = dummy;  //2
        
        while(previous.next!=null && previous.next.next!=null)
        {
            if(previous.next.val==previous.next.next.val)
            {
                int currentValue = previous.next.val;
                while(previous.next != null && previous.next.val==currentValue)
                {
                    previous.next=previous.next.next;
                }
            }
            else
            {
                previous=previous.next;
            }
        }
        
        return dummy.next;  //3
    }
}
