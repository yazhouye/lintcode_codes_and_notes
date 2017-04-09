/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 16-07-25 07:24
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
    public ListNode reverseKGroup(ListNode ohead, int k) 
    {
        if(ohead==null || ohead.next==null || k==1)
        {
            return ohead;
        }
        
        int index=0;
        ListNode current = ohead;
        
        ListNode preHead=null;
        ListNode preRear=null;
        ListNode head=null;
        ListNode rear=null;
        ListNode resultHead=null;
        
        while(current!=null)
        {
            index++;
            
            if(index%k==1)
            {
                preHead = head;
                head = current;
            }
            else if(index%k==0)
            {
                preRear = rear;
                rear = current;
                if(resultHead==null)
                {
                    resultHead=rear;
                }
                ListNode nextHead = rear.next;
                rear.next=null;
                reverse(head);
                if(preHead!=null)
                {
                    preHead.next=rear;
                }
                head.next=nextHead;
                current = head;
            }
        
            current=current.next;
        }
        
        return resultHead;
    }
    
    private void reverse(ListNode head)
    {
        ListNode previous = null;
        ListNode current = head;
        
        while(current!=null)
        {
            ListNode next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
    }
}