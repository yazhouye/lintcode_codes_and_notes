/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 16-08-10 11:24
*/

public class Solution 
{
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) 
    {
        ArrayList<Long> result = new ArrayList<Long>();
        if(A.size()==1)
        {
            result.add((long)1);
            return result;
        }
        
        long[] leftProducts = new long[A.size()];
        for(int i=0; i<A.size(); i++)
        {
            if(i==0)
            {
                leftProducts[i]=A.get(i);
            }
            else
            {
                leftProducts[i]=leftProducts[i-1]*A.get(i);
            }
        }
        
        long[] rightProducts = new long[A.size()];
        for(int i=A.size()-1; i>=0; i--)
        {
            if(i==A.size()-1)
            {
                rightProducts[i]=A.get(i);
            }
            else
            {
                rightProducts[i]=rightProducts[i+1]*A.get(i);
            }
        }
        
        for(int i=0; i<A.size(); i++)
        {
            if(i==0)
            {
                result.add(rightProducts[i+1]);
            }
            else if(i==A.size()-1)
            {
                result.add(leftProducts[i-1]);
            }
            else
            {
                result.add(leftProducts[i-1]*rightProducts[i+1]);
            }
        }
        return result;
    }
}
