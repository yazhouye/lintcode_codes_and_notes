/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/implement-trie
@Language: Java
@Datetime: 16-08-19 18:20
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode 
{
    TrieNode[] children;
    boolean isWordEnd;
    
    public TrieNode() 
    {
        children = new TrieNode[26];
        isWordEnd = false;
    }
}

public class Trie 
{
    private TrieNode root;

    public Trie() 
    {
        root = new TrieNode();
    }

    public void insert(String word) 
    {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i)-'a';
            if(cur.children[index]==null)
            {
                cur.children[index] = new TrieNode();
            }
            cur=cur.children[index];
        }
        cur.isWordEnd=true;
    }

    public boolean search(String word) 
    {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i)-'a';
            if(cur.children[index]==null)
            {
                return false;
            }
            cur=cur.children[index];
        }
        return cur.isWordEnd;
    }

    public boolean startsWith(String prefix) 
    {
        TrieNode cur = root;
        for(int i=0; i<prefix.length(); i++)
        {
            int index = prefix.charAt(i)-'a';
            if(cur.children[index]==null)
            {
                return false;
            }
            cur=cur.children[index];
        }
        return true;
    }
}