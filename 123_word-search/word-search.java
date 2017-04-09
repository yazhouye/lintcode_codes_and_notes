/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/word-search
@Language: Java
@Datetime: 16-07-27 01:33
*/

public class Solution 
{
    public boolean exist(char[][] board, String word) 
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                boolean result = bfs(board, i, j, word, 0);
                if(result)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean bfs(char[][] board, int i, int j, String word, int index)
    {
        if(index==word.length())
        {
            return true;
        }
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]!=word.charAt(index))
        {
            return false;
        }
        
        board[i][j]='#';
        boolean result = bfs(board, i+1, j, word, index+1) || bfs(board, i-1, j, word, index+1) || bfs(board, i, j+1, word, index+1) || bfs(board, i, j-1, word, index+1);
        board[i][j]=word.charAt(index);

        return result;
    }
}