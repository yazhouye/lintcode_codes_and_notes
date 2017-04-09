/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/add-two-numbers-ii
@Language: Java
@Datetime: 16-07-25 03:10
*/

/**
 * Definition for singly-linked list.
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
    
    private ListNode addLists(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(0);   //1
        ListNode current = dummy;   //2
        
        boolean carry = false;
        while(l1!=null || l2!=null || carry)
        {
            int value=0;
            if(l1!=null)
            {
                value+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                value+=l2.val;
                l2=l2.next;
            }
            if(carry)
            {
                value++;
            }
            
            ListNode newNode = new ListNode(value%10);
            current.next=newNode;
            current=newNode;
            
            carry = value/10 == 1 ? true:false;
        }
        
        return dummy.next;  //3
    }
    
    public ListNode addLists2(ListNode l1, ListNode l2) 
    {
        return reverse(addLists(reverse(l1), reverse(l2)));
    }  
}