/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/trie-serialization
@Language: Java
@Datetime: 16-08-19 18:38
*/

/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *     }
 * }
 */
class Solution 
{
    public String serialize(TrieNode root) 
    {
        String s = "";
        s+="{";
        for(Map.Entry<Character,TrieNode> entry: root.children.entrySet())
        {
            s+=entry.getKey();
            s+=serialize(entry.getValue());
        }
        s+="}";
        return s;
    }

    public TrieNode deserialize(String data) 
    {
        TrieNode root = new TrieNode();
        TrieNode current = root;
        Stack<TrieNode> stack = new Stack<TrieNode>();
        for(int i=0; i<data.length(); i++)
        {
            char c = data.charAt(i);
            if(c=='{')
            {
                stack.push(current);
            }
            else if(c=='}')
            {
                stack.pop();
            }
            else
            {
                current = new TrieNode();
                stack.peek().children.put(c, current);
            }
        }
        return root;
    }
}
