/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/geohash-ii
@Language: Java
@Datetime: 16-08-20 18:10
*/

public class GeoHash 
{
    public double[] decode(String geohash) 
    {
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        double[] longitude = {-180, 180};
        double[] latitude = {-90, 90};
        int[] getBi = {16, 8, 4, 2, 1};
        
        boolean isEven=true;
        for(int i=0; i<geohash.length(); i++)
        {
            int value = base32.indexOf(geohash.charAt(i));
            for(int j=0; j<5; j++)
            {
                if(isEven)
                {
                    if((value&getBi[j])==0)
                    {
                        longitude[1]=(longitude[0]+longitude[1])/2.0;
                    }
                    else
                    {
                        longitude[0]=(longitude[0]+longitude[1])/2.0;
                    }
                }
                else
                {
                    if((value&getBi[j])==0)
                    {
                        latitude[1]=(latitude[0]+latitude[1])/2.0;
                    }
                    else
                    {
                        latitude[0]=(latitude[0]+latitude[1])/2.0;
                    }
                }
                isEven=!isEven;
            }
        }
        
        double[] positon = new double[2];
        positon[0]=(latitude[0]+latitude[1])/2.0;
        positon[1]=(longitude[0]+longitude[1])/2.0;
        
        return positon;
    }
}