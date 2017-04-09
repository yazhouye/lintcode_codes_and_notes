/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/parking-lot
@Language: Java
@Datetime: 16-08-18 20:51
*/

enum VehicleSize 
{
    Motorcycle,
    Compact,
    Large
}

abstract class Vehicle 
{
    protected VehicleSize size;
    protected ArrayList<Spot> parkingSpots;
    
    public Vehicle()
    {
        parkingSpots = new ArrayList<Spot>();
    }
    
    public VehicleSize getVehicleSize()
    {
        return size;
    }
    
    public void parkInSpot(Spot spot)
    {
		parkingSpots.add(spot);
	}
	
	public void clearSpots() 
	{
		for(Spot spot: parkingSpots) 
		{
		    spot.removeVehicle();
		}
		parkingSpots.clear();
	}
}

class Motorcycle extends Vehicle 
{
    public Motorcycle()
    {
        super();
        this.size = VehicleSize.Motorcycle;
    }
}

class Car extends Vehicle 
{
    public Car()
    {
        super();
        this.size = VehicleSize.Compact;
    }
}

class Bus extends Vehicle 
{
    public Bus()
    {
        super();
        this.size = VehicleSize.Large;
    }
}

class Spot
{
    private Level level;
    private VehicleSize vehicleSize;
    private Vehicle vehicle;
    
    public Spot(Level level, VehicleSize vehicleSize)
    {
        this.level = level;
        this.vehicleSize = vehicleSize;
    }
    
	public boolean isAvailable() 
	{
		return vehicle == null;
	}
	
	public void park(Vehicle vehicle) 
	{
	    this.vehicle=vehicle;
	}
	
    public void removeVehicle()
    {
        this.vehicle=null;
    }
}

class Level 
{
    private ParkingLot parkingLot;
    private int num_rows;
    private int spots_per_row;
    private Spot[][] square;
    
    public Level(ParkingLot parkingLot, int num_rows, int spots_per_row)
    {
        this.parkingLot=parkingLot;
        this.num_rows=num_rows;
        this.spots_per_row=spots_per_row;
        square = new Spot[num_rows][spots_per_row];
        for(int i=0; i<num_rows; i++)
        {
            for(int j=0; j<spots_per_row/4; j++)
            {
                square[i][j] = new Spot(this, VehicleSize.Motorcycle);
            }
            for(int j=spots_per_row/4; j<(spots_per_row/4)*3; j++)
            {
                square[i][j] = new Spot(this, VehicleSize.Compact);
            }
            for(int j=(spots_per_row/4)*3; j<spots_per_row; j++)
            {
                square[i][j] = new Spot(this, VehicleSize.Large);
            }
        }
    }
    
    public boolean parkVehicle(Vehicle vehicle)
    {
        for(int i=0; i<num_rows; i++)
        {
            if(vehicle.getVehicleSize()==VehicleSize.Motorcycle)
            {
                for(int j=0; j<spots_per_row; j++)
                {
                    if(square[i][j].isAvailable())
                    {
                        square[i][j].park(vehicle);
                        vehicle.parkInSpot(square[i][j]);
                        return true;
                    }
                }
            }
            else if(vehicle.getVehicleSize()==VehicleSize.Compact)
            {
                for(int j=spots_per_row/4; j<spots_per_row; j++)
                {
                    if(square[i][j].isAvailable())
                    {
                        square[i][j].park(vehicle);
                        vehicle.parkInSpot(square[i][j]);
                        return true;
                    }
                }
            }
            else if(vehicle.getVehicleSize()==VehicleSize.Large)
            {
                for(int j=(spots_per_row/4)*3; j<=spots_per_row-5; j++)
                {
                    boolean allAvailable=true;
                    for(int k=j; k<j+5; k++)
                    {
                        if(!square[i][k].isAvailable())
                        {
                            allAvailable=false;
                            break;
                        }
                    }
                    if(allAvailable)
                    {
                        for(int k=j; k<j+5; k++)
                        {
                            square[i][k].park(vehicle);
                            vehicle.parkInSpot(square[i][k]);
                        }
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}

public class ParkingLot 
{
    private int levelNumber;
    private Level[] levels;
    
    public ParkingLot(int n, int num_rows, int spots_per_row) 
    {
        this.levelNumber=n;
        levels = new Level[levelNumber];
        for(int i=0; i<levelNumber; i++)
        {
            levels[i] = new Level(this, num_rows, spots_per_row);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) 
    {
        for(Level level: levels)
        {
            if(level.parkVehicle(vehicle))
            {
                return true;
            }
        }
        return false;
    }

    public void unParkVehicle(Vehicle vehicle) 
    {
        vehicle.clearSpots();
    }
}