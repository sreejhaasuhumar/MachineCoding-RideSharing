package Service;

import java.util.List;

import Entity.Driver;
import Entity.Ride;
import Entity.User;
import Enum.Gender;
import Enum.VehicleSeatCount;
import Enum.VehicleType;

public interface RideSharingService {

	public User addUser(String userName,Gender gender,Integer age) throws Exception;
	public Driver addVehicle(String ownerName,VehicleType vehicleType,String licenseNo) throws Exception;
	public Ride offerRide(String ownerName,String origin,String destination,Integer availableSeatCount,VehicleType vehicleType,String licenseNo) throws Exception;
	public List<Ride> selectRide(String passengerName,String origin,String destination,Integer requestedSeatCount,VehicleSeatCount strategy) throws Exception;
    public Boolean endRide(String rideName) throws Exception;
    public Integer getTotalRides(String userName);
    public void printRideStatus(String userName);
}

