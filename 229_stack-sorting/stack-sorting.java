/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/stack-sorting
@Language: Java
@Datetime: 16-08-22 01:19
*/

public class Solution 
{
    //selection sort
    public void stackSorting(Stack<Integer> stack) 
    {
        Stack<Integer> buffer = new Stack<Integer>();
        for(int i=0; i<stack.size(); i++)
        {
            int smallest = stack.pop();
            while(stack.size()>i)
            {
                if(stack.peek()<smallest)
                {
                    buffer.push(smallest);
                    smallest = stack.pop();
                }
                else
                {
                    buffer.push(stack.pop());
                }   
            }
            stack.push(smallest);
            
            while(buffer.size()>0)
            {
                stack.push(buffer.pop());
            }
        }
    }
}