package Entity;

import Enum.Gender;

public class Driver extends User {

	Vehicle vehicle;
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Driver(String userName, Gender gender, Integer age) {
		super(userName, gender, age);
		// TODO Auto-generated constructor stub
	}
	public Driver() {
		// TODO Auto-generated constructor stub
	}

}
