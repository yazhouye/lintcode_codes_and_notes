/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/maximal-rectangle
@Language: Java
@Datetime: 16-04-02 20:32
*/

public class Solution 
{
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) 
    {
        if(matrix.length==0)
        return 0;
        
        Stack<Integer> ascendingStack = new Stack<Integer>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrixArea = new int[m][n];
        
        int maxArea = 0;
        for(int j=0; j<m; j++)
        {
            for(int i=0; i<=n; i++)
            {
                int insertHeight;
                if(i==n)
                {
                    insertHeight = -1;
                }
                else
                {
                    if(j == 0)
                    {
                        matrixArea[j][i] = matrix[j][i] ? 1 : 0; 
                    }
                    else
                    {
                        matrixArea[j][i] = matrix[j][i] ? 1+matrixArea[j-1][i] : 0;
                    }
                    
                    insertHeight = matrixArea[j][i];
                }
                
                while(!ascendingStack.empty() && insertHeight < matrixArea[j][ascendingStack.peek()])
                {
                    int height = matrixArea[j][ascendingStack.pop()];
                    int left = ascendingStack.empty() ? -1 : ascendingStack.peek();
                    int right = i;
                    
                    maxArea = Math.max(maxArea, height * (right-left-1));
                }
                ascendingStack.push(i);
            }
            
            ascendingStack.clear();
        }
        
        return maxArea;
    }
}