/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/geohash
@Language: Java
@Datetime: 16-08-20 17:54
*/

public class GeoHash 
{
    public String encode(double latitude, double longitude, int precision) 
    {
        int eachBiLength = precision%2==0 ? precision/2*5 : (precision+1)/2*5;
        String laString = getBi(-90, 90, latitude, eachBiLength);
        String longString = getBi(-180, 180, longitude, eachBiLength);
        
        String mixBi="";
        for(int i=0; i<eachBiLength; i++)
        {
            mixBi+=longString.charAt(i);
            mixBi+=laString.charAt(i);
        }
        
        String hashCode = "";
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        for(int i=0; i<precision*5; i+=5)
        {
            hashCode+=base32.charAt(Integer.parseInt(mixBi.substring(i, i+5), 2));
        }
        
        return hashCode;
    }
    
    private String getBi(double start, double end, double value, int length)
    {
        String s="";
        for(int i=0; i<length; i++)
        {
            double mid = start+(end-start)/2.0;
            if(value>mid)
            {
                s+="1";
                start=mid;
            }
            else
            {
                s+="0";
                end=mid;
            }
        }
        return s;
    }
}