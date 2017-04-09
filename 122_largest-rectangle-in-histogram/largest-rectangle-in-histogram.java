/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Java
@Datetime: 16-08-21 21:11
*/

public class Solution 
{
    public int largestRectangleArea(int[] height) 
    {
        Stack<Integer> acsendingStack = new Stack<Integer>();
        int max=0;
        
        for(int i=0; i<=height.length; i++)
        {
            int nextHeight = i==height.length ? -1 : height[i];
            while(acsendingStack.size()!=0 && nextHeight<height[acsendingStack.peek()])
            {
                int insideHeight = height[acsendingStack.pop()];
                int left = acsendingStack.size()==0 ? -1:acsendingStack.peek();
                int right = i;
                
                max=Math.max(max, insideHeight*(right-left-1));
            }
            acsendingStack.push(i);
        }
        return max;
    }
}
