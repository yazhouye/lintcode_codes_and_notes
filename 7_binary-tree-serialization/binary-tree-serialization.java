/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/binary-tree-serialization
@Language: Java
@Datetime: 16-08-15 00:41
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution 
{
    //bfs
    /*
    public String serialize(TreeNode root) 
    {
        String s = "";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.size()!=0)
        {
            TreeNode head = queue.poll();
            if(head==null)
            {
                s+="#";
            }
            else
            {
                s+=Integer.toString(head.val);
                queue.offer(head.left);
                queue.offer(head.right);
            }
            s+=",";
        }
        return s;
    }
    
    public TreeNode deserialize(String data) 
    {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        for(String s: data.split(","))
        {
            if(s.equals("#"))
            {
                list.add(null);
            }
            else
            {
                list.add(new TreeNode(Integer.parseInt(s)));
            }
        }
        
        for(int i=0, j=1; j<list.size(); i++)
        {
            if(list.get(i)!=null)
            {
                list.get(i).left=list.get(j++);
                list.get(i).right=list.get(j++);
            }
        }
        
        return list.get(0);
    }
    */
    
    //dfs: applicable to all kind of tree, same as Trie Serialization
    public String serialize(TreeNode root) 
    {
        String s = "";
        if(root==null)
        {
            s+="#";
            s+=",";
            return s;
        }
        s+=Integer.toString(root.val);
        s+=",";
        s+="{";
        s+=",";
        if(root.left!=null || root.right!=null)
        {
            s+=serialize(root.left);
            s+=serialize(root.right);
        }
        s+="}";
        s+=",";
        return s;
    }
    
    public TreeNode deserialize(String data) 
    {
        String[] array = data.split(",");
        if(array[0].equals("#"))
        {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> isLeftChecked = new HashSet<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        TreeNode current = root;
        
        for(int i=1; i<array.length; i++)
        {
            if(array[i].equals("{"))
            {
                stack.push(current);
            }
            else if(array[i].equals("}"))
            {
                stack.pop();
            }
            else
            {
                if(array[i].equals("#"))
                {
                    if(!isLeftChecked.contains(stack.peek()))
                    {
                        stack.peek().left=null;
                        isLeftChecked.add(stack.peek());
                    }
                    else
                    {
                        stack.peek().right=null;
                    }
                }
                else
                {
                    current = new TreeNode(Integer.parseInt(array[i]));
                    if(!isLeftChecked.contains(stack.peek()))
                    {
                        stack.peek().left=current;
                        isLeftChecked.add(stack.peek());
                    }
                    else
                    {
                        stack.peek().right=current;
                    }
                }
            }
        }
        
        return root;
    }
}
