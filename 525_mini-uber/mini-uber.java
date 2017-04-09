/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/mini-uber
@Language: Java
@Datetime: 16-08-20 18:42
*/

/**
 * Definition of Trip:
 * public class Trip {
 *     public int id; // trip's id, primary key
 *     public int driver_id, rider_id; // foreign key
 *     public double lat, lng; // pick up location
 *     public Trip(int rider_id, double lat, double lng);
 * }
 * Definition of Helper
 * class Helper {
 *     public static double get_distance(double lat1, double lng1,
                                         double lat2, double lng2) {
 *         // return distance between (lat1, lng1) and (lat2, lng2)
 *     }
 * };
 */
class Location
{
    double lng;
    double lat;
    public Location(double lng, double lat)
    {
        this.lng=lng;
        this.lat=lat;
    }
}
 
public class MiniUber 
{
    private HashMap<Integer, Location> drive2Location;
    private HashMap<Integer, Trip> drive2Trip;

    public MiniUber() 
    {
        drive2Location = new HashMap<Integer, Location>();
        drive2Trip = new HashMap<Integer, Trip>();
    }

    public Trip report(int driver_id, double lat, double lng) 
    {
        if(drive2Trip.containsKey(driver_id))
        {
            return drive2Trip.get(driver_id);
        }
        
        if(!drive2Location.containsKey(driver_id))
        {
            drive2Location.put(driver_id, new Location(lng, lat));
        }
        else
        {
            drive2Location.get(driver_id).lng=lng;
            drive2Location.get(driver_id).lat=lat;
        }
        
        return null;
    }

    public Trip request(int rider_id, double lat, double lng) 
    {
        if(drive2Location.size()==0)
        {
            return null;
        }
        
        int driver_id=-1;
        double closetDistance=-1;
        for(Map.Entry<Integer, Location> entry: drive2Location.entrySet())
        {
            double distance = Helper.get_distance(lat, lng, entry.getValue().lat, entry.getValue().lng);
            if(closetDistance==-1 || distance<closetDistance)
            {
                driver_id = entry.getKey();
                closetDistance=distance;
            }
        }
        
        drive2Location.remove(driver_id);
        
        Trip trip = new Trip(rider_id, lat, lng);
        trip.driver_id = driver_id;
        drive2Trip.put(driver_id, trip);
        
        return trip;
    }
}