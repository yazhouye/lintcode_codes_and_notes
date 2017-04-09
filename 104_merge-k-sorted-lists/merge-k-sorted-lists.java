/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Java
@Datetime: 16-07-23 00:43
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution 
{
    //divide conquer
    /*
    private ListNode merge2Lists(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);   //1
        ListNode current = dummy;   //2
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                current.next=l1;
                l1=l1.next;
            }
            else
            {
                current.next=l2;
                l2=l2.next;
            }
            current=current.next;
        }
        
        if(l1!=null)
        {
            current.next=l1;
        }
        else if(l2!=null)
        {
            current.next=l2;
        }
        
        return dummy.next;  //3
    }
    
    private ListNode helper(List<ListNode> lists, int start, int end)
    {
        if(start==end)
        {
            return lists.get(start);
        }
        
        ListNode up = helper(lists, start, (start+end)/2);
        ListNode down = helper(lists, (start+end)/2+1, end);
        
        return merge2Lists(up, down);
    }
    
    public ListNode mergeKLists(List<ListNode> lists) 
    {  
        if(lists==null || lists.size()==0)
        {
            return null;
        }
        
        return helper(lists, 0, lists.size()-1);
    }
    */
    
    
    //heap, PriorityQueue
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>()
    {
        @Override
        public int compare(ListNode left, ListNode right)
        {
            return left.val-right.val;
        }
    };
    
    public ListNode mergeKLists(List<ListNode> lists)
    {
        if (lists == null || lists.size() == 0)
        {
            return null;
        }
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        
        for(int i=0; i<lists.size(); i++)
        {
            if(lists.get(i)!=null)
            {
                heap.add(lists.get(i));   
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while(heap.size()!=0)
        {
            ListNode head = heap.poll();
            current.next = head;
            current = head;
            
            if(head.next!=null)
            {
                heap.add(head.next);  
            }
        }
        
        return dummy.next;
    }
}
