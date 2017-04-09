/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Java
@Datetime: 16-08-09 21:57
*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution 
{
    public int findFirstBadVersion(int n) 
    {
        int left = 1;
        int right = n;
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(SVNRepo.isBadVersion(mid))
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }
}
