/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-ii
@Language: Java
@Datetime: 16-11-18 19:50
*/

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution 
{
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) 
                                                 {
        ArrayList<ParentTreeNode> listA = new ArrayList<ParentTreeNode>();
        ArrayList<ParentTreeNode> listB = new ArrayList<ParentTreeNode>();
        while(A!=null)
        {
            listA.add(A);
            A=A.parent;
        }
        while(B!=null)
        {
            listB.add(B);
            B=B.parent;
        }
        
        for(int i=listA.size()-1, j=listB.size()-1; i>=0 && j>=0; i--, j--)
        {
            if(listA.get(i)!=listB.get(j))  //applicable for one node is not parent of another one
            {
                return listA.get(i).parent; 
            }
        }
        return listA.size()<=listB.size() ? listA.get(0) : listB.get(0);    //applicable for one node is parent of another one
    }
}
