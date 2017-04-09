/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 16-07-28 21:01
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode[] rehashing(ListNode[] hashTable) 
    {
        ListNode[] newHashTable = new ListNode[hashTable.length*2];
        
        for(ListNode node: hashTable)
        {
            while(node!=null)
            {
                ListNode next = node.next;
                int index = (node.val%newHashTable.length+newHashTable.length)%newHashTable.length;
                ListNode newNode = newHashTable[index];
                if(newNode==null)
                {
                    newHashTable[index]=node;   //don't new ListNode
                }
                else
                {
                    while(newNode.next!=null)
                    {
                        newNode=newNode.next;
                    }
                    newNode.next=node;  //don't new ListNode
                }
                node.next=null;
                
                node=next;
            }
        }
        
        return newHashTable;
    }
};
