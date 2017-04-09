/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Java
@Datetime: 16-07-29 00:39
*/

public class Solution 
{
    private PriorityQueue<Integer> pq;
    private int capacity;
    public Solution(int k) 
    {
        pq = new PriorityQueue<Integer>();
        capacity=k;
    }

    public void add(int num) 
    {
        pq.offer(num);
        if(pq.size()>capacity)
        {
            pq.poll();
        }
    }

    public List<Integer> topk() 
    {
        List<Integer> result = new ArrayList<Integer>(pq);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
};