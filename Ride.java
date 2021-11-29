package Entity;

import Enum.RideStatus;
import Enum.VehicleSeatCount;

public class Ride {

	Long rideId;
	String rideName;
	Driver driver;
	Passenger passenger;
	Integer requestedSeatCount;
	Integer availableSeatCount;
	String origin;
	RideStatus rideStatus;
	String destination;
	VehicleSeatCount strategy;
	
	
	public String getRideName() {
		return rideName;
	}
	public void setRideName(String rideName) {
		this.rideName = rideName;
	}
	public Integer getAvailableSeatCount() {
		return availableSeatCount;
	}
	public void setAvailableSeatCount(Integer availableSeatCount) {
		this.availableSeatCount = availableSeatCount;
	}
	public RideStatus getRideStatus() {
		return rideStatus;
	}
	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}
	public Long getRideId() {
		return rideId;
	}
	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Integer getRequestedSeatCount() {
		return requestedSeatCount;
	}
	public void setRequestedSeatCount(Integer requestedSeatCount) {
		this.requestedSeatCount = requestedSeatCount;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public VehicleSeatCount getStrategy() {
		return strategy;
	}
	public void setStrategy(VehicleSeatCount strategy) {
		this.strategy = strategy;
	}
	
	
	
}
