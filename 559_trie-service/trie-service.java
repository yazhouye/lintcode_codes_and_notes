/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/trie-service
@Language: Java
@Datetime: 16-08-18 00:21
*/

/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public List<Integer> top10;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *         List<Integer> top10 = new ArrayList<Integer>();
 *     }
 * }
 */
public class TrieService 
{

    private TrieNode root = null;

    public TrieService() 
    {
        root = new TrieNode();
    }

    public TrieNode getRoot() 
    {
        return root;
    }

    public void insert(String word, int frequency) 
    {
        TrieNode current = root;
        for(int i=0; i<=word.length(); i++)
        {
            int j=0;
            while(j<current.top10.size() && frequency<current.top10.get(j))
            {
                j++;
            }
            current.top10.add(j, frequency);
            if(current.top10.size()>10)
            {
                current.top10.remove(current.top10.size()-1);
            }
            
            if(i<word.length())
            {
                char c = word.charAt(i);
                if(!current.children.containsKey(c))
                {
                    current.children.put(c, new TrieNode());
                }
                current=current.children.get(c);
            }
        }
    }
 }