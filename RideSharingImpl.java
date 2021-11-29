package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Entity.Driver;
import Entity.IDGenerator;
import Entity.Passenger;
import Entity.Ride;
import Entity.User;
import Entity.Vehicle;
import Enum.Gender;
import Enum.RideStatus;
import Enum.VehicleSeatCount;
import Enum.VehicleType;

public class RideSharingImpl implements RideSharingService {
	
	Set<String> userSet;
	Map<String,User> userMap;
	Map<String,String> driverMap;
	Map<String,Ride> rideMap;
	Map<String,RideStatus> rideStatusMap;
	Map<String,Ride> rideNameMap;

	public RideSharingImpl()
	{
	  userSet=new HashSet<>();	
	  driverMap=new HashMap<>();
	  rideMap=new HashMap<>();
	  rideStatusMap=new HashMap<>();
	  rideNameMap=new HashMap<>();
	  userMap=new HashMap<>();

	}
	
	@Override
	public User addUser(String userName,Gender gender,Integer age) throws Exception
	{
		User user=null;
		if(userSet.contains(userName))
		{
			throw new Exception("User Already exists");
		}
		else
		{
			long userId=IDGenerator.getId();
			user=new User(userName, gender, age);
			user.setUserId(userId);
			userSet.add(userName);	
			userMap.put(userName, user);
		}
		return user;
	}

	@Override
	public Driver addVehicle(String ownerName, VehicleType vehicleType, String licenseNo) throws Exception {
		Driver driver=null;
		Vehicle vehicle=null;
		if(!userSet.contains(ownerName))
		{
			throw new Exception("User doesnt exist");
		}
		else if(driverMap.containsKey(ownerName))			
		{
		   throw new Exception("Vehicle already exists for the user");
		}
		else
		{
		   driver=new Driver();
		   vehicle = new Vehicle(ownerName, vehicleType, licenseNo);
		   driver.setUserName(ownerName);
		   driver.setVehicle(vehicle);
		   driverMap.put(ownerName,licenseNo);
		}
		return driver;
	}

	@Override
	public Ride offerRide(String ownerName, String origin, String destination, Integer availableSeatCount,
			VehicleType vehicleType, String licenseNo) throws Exception {
		Ride ride=null;
		if(userSet.contains(ownerName) && driverMap.containsKey(ownerName) && !rideMap.containsKey(ownerName) )
		{
			ride=new Ride();
			Long rideId=IDGenerator.getId();
			String rideName=ownerName+"-"+rideId;
			ride.setRideId(rideId);
			ride.setRideName(rideName);
			ride.getDriver().setUserName(ownerName);
			ride.setOrigin(origin);
			ride.setDestination(destination);
			ride.setAvailableSeatCount(availableSeatCount);
			ride.getDriver().getVehicle().setVehicleType(vehicleType);
			ride.getDriver().getVehicle().setLicenseNo(licenseNo);
			ride.setRideStatus(RideStatus.notstarted);
			rideMap.put(ownerName, ride);
			rideStatusMap.put(rideName,RideStatus.notstarted);
			rideNameMap.put(rideName,ride);

			}
		else
		{
			throw new Exception("Not a valid ride");
		}
		return ride;
	}

	@Override
	public List<Ride> selectRide(String passengerName, String origin, String destination, Integer requestedSeatCount,
			VehicleSeatCount strategy) throws Exception {
		List<Ride> selectedRideList=new ArrayList<>();
		if(userSet.contains(passengerName))
		{
			for(Map.Entry<String,Ride> iterator:rideMap.entrySet())
			{
				if(iterator.getValue().getOrigin().equals(origin) && iterator.getValue().getDestination().equals(destination) && iterator.getValue().getAvailableSeatCount()>=requestedSeatCount) {
					if(strategy.equals(VehicleType.Most_Vacant))
					{
						if(iterator.getValue().getStrategy().getAvailableSeatCount()==4)
						{
							selectedRideList.add(iterator.getValue());
							iterator.getValue().setRideStatus(RideStatus.started);
							Integer updatedSeatCount=iterator.getValue().getAvailableSeatCount()-1;
						    iterator.getValue().setAvailableSeatCount(updatedSeatCount);
						    String rideName=iterator.getValue().getRideName();
						    rideStatusMap.put(rideName, RideStatus.started);
						    rideNameMap.put(rideName, iterator.getValue());
						}
					}
					else
					{
						if(strategy.equals(iterator.getValue().getStrategy()))
						{
							selectedRideList.add(iterator.getValue());
							iterator.getValue().setRideStatus(RideStatus.started);
							Integer updatedSeatCount=iterator.getValue().getAvailableSeatCount()-1;
						    iterator.getValue().setAvailableSeatCount(updatedSeatCount);
						    String rideName=iterator.getValue().getRideName();
						    rideStatusMap.put(rideName, RideStatus.started);
						    rideNameMap.put(rideName, iterator.getValue());
						}
					}
				}
			}
		}
		else
		{
			throw new Exception("Passenger doesnt exists");
		}
		return selectedRideList;
	}

	@Override
	public Boolean endRide(String rideName) throws Exception {
		if(rideStatusMap.containsKey(rideName) && rideStatusMap.containsValue(RideStatus.started))
		{
			rideStatusMap.put(rideName, RideStatus.ended);
			Ride ride=rideNameMap.get(rideName);
			ride.setRideStatus(RideStatus.ended);
			rideNameMap.put(rideName,ride);
			return true;
		}
		else
		{
			throw new Exception("Ride doesnt exists");
		}
	}

	@Override
	public Integer getTotalRides(String userName) {
		User user=userMap.get(userName);
		return user.getRideSize();
	}

	@Override
	public void printRideStatus(String userName) {
		User user=userMap.get(userName);

		if(user instanceof Driver)
		{
			System.out.println(user.getUserName()+" : 0 Taken , "+ user.getRideSize()+" Offered");
		}
		else if(user instanceof Passenger)
		{
			System.out.println(user.getUserName()+" : "+ user.getRideSize()+" Taken , 0 Offered");
		}
	}

}
