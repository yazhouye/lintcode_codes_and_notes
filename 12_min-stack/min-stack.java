/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 16-08-21 20:29
*/

public class MinStack 
{
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() 
    {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) 
    {
        if(minStack.size()==0 || number<=minStack.peek())
        {
            minStack.push(number);
        }
        stack.push(number);
    }

    public int pop() 
    {
        if(minStack.peek().equals(stack.peek()))
        {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() 
    {
        return minStack.peek();
    }
}
