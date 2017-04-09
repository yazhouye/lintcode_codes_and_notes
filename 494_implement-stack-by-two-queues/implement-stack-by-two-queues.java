/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/implement-stack-by-two-queues
@Language: Java
@Datetime: 16-07-28 23:49
*/

class Stack {
    private Queue<Integer> queue = new LinkedList<Integer>();
    
    // Push a new item into the stack
    public void push(int x) 
    {
        queue.offer(x);
        for(int i=0; i<queue.size()-1; i++)
        {
            queue.offer(queue.poll());
        }
    }

    // Pop the top of the stack
    public void pop() 
    {
        queue.poll();
    }

    // Return the top of the stack
    public int top() 
    {
        return queue.peek();
    }

    // Check the stack is empty or not.
    public boolean isEmpty() 
    {
        return queue.isEmpty();
    }    
}