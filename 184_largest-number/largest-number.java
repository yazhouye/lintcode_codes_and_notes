/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/largest-number
@Language: Java
@Datetime: 16-08-17 06:05
*/

public class Solution 
{
    private Comparator<String> numbersComparator = new Comparator<String>() 
    {
	    @Override
	    public int compare(String s1, String s2) 
	    {
		    return (s2 + s1).compareTo(s1 + s2);
	    }
    };
    
    public String largestNumber(int[] num) 
    {
        String[] list = new String[num.length];
        for(int i=0; i<num.length; i++)
        {
            list[i]=Integer.toString(num[i]);
        }
        
        Arrays.sort(list, numbersComparator);
        
        String s="";
        for(String item: list)
        {
            s+=item;
        }
        return s.split("0").length==0 ? "0" : s;
    }
}