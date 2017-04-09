/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-arrays
@Language: Java
@Datetime: 16-08-21 20:09
*/

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    
    private List<Integer> mergeTwoLists(List<Integer> up, List<Integer> down)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int indexUp = 0;
        int indexDown = 0;
        
        while(indexUp<up.size() && indexDown<down.size())
        {
            if(up.get(indexUp) < down.get(indexDown))
            {
                result.add(up.get(indexUp));
                indexUp++;
            }
            else
            {
                result.add(down.get(indexDown));
                indexDown++;
            }
        }
        
        while(indexUp<up.size())
        {
            result.add(up.get(indexUp));
            indexUp++;
        }
        
        while(indexDown<down.size())
        {
            result.add(down.get(indexDown));
            indexDown++;
        }
        
        return result;
    }
    
    private List<Integer> helper(int[][] arrays, int start, int end)
    {
        if(start == end)
        {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i=0; i<arrays[start].length; i++)
            {
                result.add(arrays[start][i]);
            }
            return result;
        }
        
        int mid = start + (end - start)/2;
        List<Integer> up = helper(arrays, start, mid);
        List<Integer> down = helper(arrays, mid+1, end);
        
        return mergeTwoLists(up, down);
    }
    
    public List<Integer> mergekSortedArrays(int[][] arrays) 
    {
        return helper(arrays, 0, arrays.length-1);
    }
}