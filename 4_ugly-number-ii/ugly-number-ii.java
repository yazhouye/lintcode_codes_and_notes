/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Java
@Datetime: 16-08-21 20:48
*/

class Solution 
{
    public int nthUglyNumber(int n) 
    {
        if(n==1)
        {
            return 1;
        }
        
        Queue<Long> q2 = new LinkedList<Long>();
        Queue<Long> q3 = new LinkedList<Long>();
        Queue<Long> q5 = new LinkedList<Long>();
        q2.offer((long)2);
        q3.offer((long)3);
        q5.offer((long)5);
        
        for(int i=2; i<n; i++)
        {
            long min = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
            if(min==q2.peek())
            {
                q2.poll();
                q2.offer(min*2);
            }
            else if(min==q3.peek())
            {
                q3.poll();
                q2.offer(min*2);
                q3.offer(min*3);
            }
            else if(min==q5.peek())
            {
                q5.poll();
                q2.offer(min*2);
                q3.offer(min*3);
                q5.offer(min*5);
            }
        }
        
        return (int)Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
    }
};
