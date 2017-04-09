/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 16-07-26 00:52
*/

public class Solution 
{
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        //time: O(m+n)  space: O(m)
        /*
        HashSet<Integer> nums1Set = new HashSet<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        for(int item: nums1)
        {
            nums1Set.add(item);
        }
        
        for(int item: nums2)
        {
            if(nums1Set.contains(item))
            {
                result.add(item);
            }
        }
        
        int[] array = new int[result.size()];
        int i=0;
        for(int item: result)
        {
            array[i++]=item;
        }
        return array;
        */
        
        //time: O(mlgm+nlgn)  space: O(1)
        /*
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i1=0;
        int i2=0;
        HashSet<Integer> result = new HashSet<Integer>();
        
        while(i1<nums1.length && i2<nums2.length)
        {
            if(nums1[i1]<nums2[i2])
            {
                i1++;
            }
            else if(nums1[i1]>nums2[i2])
            {
                i2++;
            }
            else
            {
                result.add(nums1[i1]);
                i1++;
                i2++;
            }
        }
        
        int[] array = new int[result.size()];
        int i=0;
        for(int item: result)
        {
            array[i++]=item;
        }
        return array;
        */
        
        //time: O(mlgm+nlgm)  space: O(1)
        
        Arrays.sort(nums1);
        HashSet<Integer> result = new HashSet<Integer>();
        
        for(int item: nums2)
        {
            if(binarySearch(nums1, item))
            {
                result.add(item);
            }
        }
        
        int[] array = new int[result.size()];
        int i=0;
        for(int item: result)
        {
            array[i++]=item;
        }
        return array;
    }
    
    private boolean binarySearch(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end)
        {
            int mid = (start + end)/2;
            if(nums[mid]>target)
            {
                end=mid-1;
            }
            else if(nums[mid]<target)
            {
                start=mid+1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}