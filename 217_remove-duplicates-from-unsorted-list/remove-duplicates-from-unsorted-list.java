/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-unsorted-list
@Language: Java
@Datetime: 16-07-23 18:28
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
    public ListNode removeDuplicates(ListNode head) 
    { 
        HashSet<Integer> set = new HashSet<Integer>();

        ListNode dummy = new ListNode(0); 
        dummy.next=head;
        ListNode current = dummy;
        
        while(current.next!=null)
        {
            if(set.contains(current.next.val))
            {
                current.next=current.next.next;
            }
            else
            {
                set.add(current.next.val);
                current=current.next;
            }
        }
        
        return dummy.next;
    }  
}