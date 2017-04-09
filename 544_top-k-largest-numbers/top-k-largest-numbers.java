/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 16-08-21 20:18
*/

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    /*
    public int[] topk(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for(int item: nums) 
        {
            pq.offer(item);
            if(pq.size()>k) 
            {
                pq.poll();
            }
        }
        
        int[] result = new int[k];
        for(int i=k-1; i>=0; i--)
        {
            result[i]=pq.poll();
        }
        return result;
    }
    */
    
    public int[] topk(int[] nums, int k) 
    {
        heapify(nums);
        int[] result = new int[k];
        
        for(int i=0; i<k; i++)
        {
            result[i]=nums[0];
            nums[0]=nums[nums.length-1-i];
            moveDown(nums, 0, nums.length-1-i);
        }
        return result;
    }
    
    private void heapify(int[] nums)
    {
        for(int i=nums.length/2-1; i>=0; i--)
        {
            moveDown(nums, i, nums.length);
        }
    }
    
    private void moveDown(int[] nums, int index, int size)
    {
        while(index*2+1<size)
        {
            if(index*2+2>=size)
            {
                if(nums[index*2+1]>nums[index])
                {
                    int temp = nums[index*2+1];
                    nums[index*2+1] = nums[index];
                    nums[index] = temp;
                    
                    index=index*2+1;
                }
                else
                {
                    break;
                }
            }
            else
            {
                if(nums[index*2+1]<nums[index] && nums[index*2+2]<nums[index])
                {
                    break;
                }
                else
                {
                    int maxIndex = nums[index*2+1]>=nums[index*2+2] ? index*2+1:index*2+2;
                    
                    int temp = nums[maxIndex];
                    nums[maxIndex] = nums[index];
                    nums[index] = temp;
                    
                    index=maxIndex;
                }
            }
        }
    }
}

