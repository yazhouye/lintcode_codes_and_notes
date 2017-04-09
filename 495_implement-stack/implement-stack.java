/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/implement-stack
@Language: Java
@Datetime: 16-07-28 23:46
*/

class Stack 
{
    private ArrayList<Integer> list = new ArrayList<Integer>();
    // Push a new item into the stack
    public void push(int x) 
    {
        list.add(x);
    }

    // Pop the top of the stack
    public void pop() 
    {
        list.remove(list.size()-1);
    }

    // Return the top of the stack
    public int top() 
    {
        return list.get(list.size()-1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() 
    {
        return list.size()==0;
    }    
}