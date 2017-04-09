/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 16-07-22 20:46
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
    public ListNode partition(ListNode head, int x) 
    {
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode leftCurrent = leftDummy;
        ListNode rightCurrent = rightDummy;
        
        while(head!=null)
        {
            if(head.val<x)
            {
                leftCurrent.next=head;
                leftCurrent=leftCurrent.next;
            }
            else
            {
                rightCurrent.next=head;
                rightCurrent=rightCurrent.next;
            }
            head=head.next;
        }
        leftCurrent.next=rightDummy.next;
        rightCurrent.next=null;  //important
        
        return leftDummy.next;
    }
}
