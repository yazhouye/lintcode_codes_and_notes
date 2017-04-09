/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list
@Language: Java
@Datetime: 16-07-28 23:57
*/

public class Queue 
{
    class Node
    {
        int value;
        Node next;
        public Node(int value)
        {
            this.value=value;
            next=null;
        }
    }
    
    private Node first;
    private Node last;
    
    public Queue() 
    {
        first=null;
        last=null;
    }

    public void enqueue(int item) 
    {
        if(first==null)
        {
            first = new Node(item);
            last = first;
        }
        else
        {
            last.next = new Node(item);
            last=last.next;
        }
    }

    public int dequeue() 
    {
        int head = first.value;
        first=first.next;
        if(first==null)
        {
            last=null;
        }
        return head;
    }
}