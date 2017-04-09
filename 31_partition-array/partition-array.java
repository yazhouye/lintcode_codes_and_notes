/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 16-08-21 00:32
*/

public class Solution 
{
    //same as Remove Element
    public int partitionArray(int[] nums, int k) 
    {
        int start=0;
        int end=nums.length-1;
        
        while(start<=end)
        {
            while(start<=end && nums[start]<k)
            {
                start++;
            }
            while(start<=end && nums[end]>=k)
            {
                end--;
            }
            if(start<=end)
            {
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
            }
        }
        
        return start;
    }
    
    //related partition in quicksort
    /*
	public static void quickSort(int[] arr, int left, int right)
	{
		if(left>=right)
		{
			return;
		}
		int index = partition(arr, left, right);
		quickSort(arr, left, index-1);
		quickSort(arr, index, right);
	}
	
	public static int partition(int[] arr, int left, int right)
	{
		int pivot = arr[(left+right)/2];
		while(left<=right)
		{
			while(left<=right && arr[left]<pivot) left++;
			while(left<=right && pivot<arr[right]) right--;
			
			if(left<=right)
			{
				swap(arr,left,right);
				left++;
				right--;
			}
		}

		return left;
	}
	*/
}