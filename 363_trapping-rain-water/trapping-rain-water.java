/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/trapping-rain-water
@Language: Java
@Datetime: 16-08-23 08:37
*/

public class Solution 
{
    public int trapRainWater(int[] heights) 
    {
        //forward-backward traversal
        /*
        if(heights.length==0)
        {
            return 0;
        }
        
        int[] leftMaxHeight = new int[heights.length];
        leftMaxHeight[0] = 0;
        for(int i=1; i<=leftMaxHeight.length-2; i++)
        {
            leftMaxHeight[i]=Math.max(leftMaxHeight[i-1], heights[i-1]);
        }
        
        int[] rightMaxHeight = new int[heights.length];
        rightMaxHeight[rightMaxHeight.length-1] = 0;
        for(int i=rightMaxHeight.length-2; i>=1; i--)
        {
            rightMaxHeight[i]=Math.max(rightMaxHeight[i+1], heights[i+1]);
        }
        
        int sum=0;
        for(int i=1; i<=heights.length-2; i++)
        {
            int minHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            if(minHeight>heights[i])
            {
                sum+=minHeight-heights[i];
            }
        }
        
        return sum;
        */
        
        //two pointers
        
        int start = 0;
        int end = heights.length-1;
        
        //int smaller;
        int area=0;
        
        while(start<end)
        {
            if(heights[start]<heights[end])
            {
                int smaller=heights[start];
                start++;
                while(start<end && heights[start]<smaller)
                {
                    area+=smaller-heights[start];
                    start++;
                }
            }
            else
            {
                int smaller=heights[end];
                end--;
                while(start<end && heights[end]<smaller)
                {
                    area+=smaller-heights[end];
                    end--;
                }
            }
        }
        return area;
    }
}