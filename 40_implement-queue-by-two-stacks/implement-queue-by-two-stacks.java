/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/implement-queue-by-two-stacks
@Language: Java
@Datetime: 16-07-28 20:33
*/

public class Queue 
{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() 
    {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    
    public void push(int element) 
    {
        stack1.push(element);
    }
    
    private void reverse()
    {
        if(stack2.size()==0)
        {
            while(stack1.size()!=0)
            {
                stack2.push(stack1.pop());
            }
        }
    }

    public int pop() 
    {
        reverse();
        return stack2.pop();
    }

    public int top() 
    {
        reverse();
        return stack2.peek();
    }
}