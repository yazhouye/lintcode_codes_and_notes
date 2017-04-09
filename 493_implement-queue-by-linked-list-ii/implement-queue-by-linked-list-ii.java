/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list-ii
@Language: Java
@Datetime: 16-07-29 00:10
*/

public class Dequeue 
{
    class Node
    {
        int value;
        Node pre;
        Node next;
        public Node(int value)
        {
            this.value=value;
        }
    }
    
    private Node first;
    private Node last;
    
    public Dequeue() 
    {
        first=null;
        last=null;
    }

    public void push_front(int item) 
    {
        if(first==null)
        {
            first=new Node(item);
            last=first;
        }
        else
        {
            first.pre=new Node(item);
            first.pre.next=first;
            first=first.pre;
        }
    }

    public void push_back(int item) 
    {
        if(last==null)
        {
            last=new Node(item);
            first=last;
        }
        else
        {
            last.next=new Node(item);
            last.next.pre=last;
            last=last.next;
        }
    }

    public int pop_front() 
    {
        if(first==null)
        {
            return -1;
        }
        else
        {
            int head = first.value;
            first=first.next;
            if(first==null)
            {
                last=null;
            }
            else
            {
                first.pre=null;
            }
            return head;
        }
    }

    public int pop_back() 
    {
        if(last==null)
        {
            return -1;
        }
        else
        {
            int rear = last.value;
            last=last.pre;
            if(last==null)
            {
                first=null;
            }
            else
            {
                last.next=null;
            }
            return rear;
        }
    }
}