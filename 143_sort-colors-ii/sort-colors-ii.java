/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 16-08-21 09:52
*/

class Solution 
{
    public void sortColors2(int[] colors, int k) 
    {
        int min = 1;
        int max = k;
        
        int left=0;
        int right=colors.length-1;
        
        while(min<max)
        {
            int current = left;
            while(current<=right)
            {
                if(colors[current]==min)
                {
                    if(left!=current)
                    {
                        int temp = colors[current];
                        colors[current] = colors[left];
                        colors[left] = temp;
                    }
                    left++;
                    current++;
                }
                else if(colors[current]>min && colors[current]<max)
                {
                    current++;
                }
                else
                {
                    if(right!=current)
                    {
                        int temp = colors[current];
                        colors[current] = colors[right];
                        colors[right] = temp;
                    }
                    right--;
                }
            }
            min++;
            max--;
        }
    }
}