/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/surrounded-regions
@Language: Java
@Datetime: 16-07-26 17:42
*/

public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        if(board.length==0) {
            return;
        }
        
        //4 edges dfs find unsurrounded spots
        for(int i=0; i<=board.length-1; i++) {
            //if(board[i][0]=='O') {
                dfs(board, i, 0);
            //}
            //if(board[i][board[0].length-1]=='O') {
                dfs(board, i, board[0].length-1);
            //}
        }
        
        for(int i=1; i<=board[0].length-2; i++) {
            //if(board[0][i]=='O') {
               dfs(board, 0, i);
            //}
            //if(board[board.length-1][i]=='O') {
                dfs(board, board.length-1, i);
            //}
        }
        
        //surrounded spots to 'X', unsurrounded spots to 'O'
        for(int i=0; i<=board.length-1; i++) {
            for(int j=0; j<=board[0].length-1; j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                }
                else if(board[i][j]=='E') {
                    board[i][j]='O';
                }
            }
        }
        
    }
    
    private void dfs(char[][] board, int y, int x) {
        if(board[y][x]!='O')
        {
            return;
        }
        board[y][x]='E';
        
        if(y-1>=0) {
            dfs(board, y-1, x);
        }
        if(x-1>=0) {
            dfs(board, y, x-1);
        }
        if(y+1<=board.length-1) {
            dfs(board, y+1, x);
        }
        if(x+1<=board[0].length-1) {
            dfs(board, y, x+1);
        }
    }
}