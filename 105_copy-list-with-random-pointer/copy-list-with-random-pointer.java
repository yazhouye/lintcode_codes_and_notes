/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 16-08-18 22:14
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution 
{
    private void copyNext(RandomListNode head)
    {
        while(head!=null)
        {
            RandomListNode next = head.next;
            RandomListNode newNode = new RandomListNode(head.label);
            head.next = newNode;
            newNode.next = next;
            head = next;
        }
    }
    
    private void copyRandom(RandomListNode head)
    {
        while(head!=null)
        {
            RandomListNode newNode = head.next;
            if(head.random!=null)
            {
                newNode.random = head.random.next;
            }
            head = newNode.next;
        }
    }
    
    private RandomListNode split(RandomListNode head)
    {
        RandomListNode dummy = new RandomListNode(0);   //1
        dummy.next=head;    //2
        RandomListNode current = dummy; //2
        
        while(current.next!=null)
        {
            current.next=current.next.next;
            current=current.next;
        }
        
        return dummy.next;  //3
    }
    
    public RandomListNode copyRandomList(RandomListNode head) 
    {
        copyNext(head);
        copyRandom(head);
        return split(head);
    }
}