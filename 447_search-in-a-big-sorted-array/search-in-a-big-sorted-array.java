/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Java
@Datetime: 16-08-09 21:34
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution 
{
    public int searchBigSortedArray(ArrayReader reader, int target) 
    {
        int index=0;
        while(reader.get(index)<target)
        {
            index=(index+1)*2-1;
        }
        
        int left = (index+1)/2-1;
        int right = index;
        
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(reader.get(mid)<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return reader.get(left)==target ? left:-1;
    }
}