package Entity;

import Enum.VehicleType;

public class Vehicle {

	Long vehicleId;
//	Driver driver;	
	VehicleType vehicleType;
	String licenseNo;
	String ownerName;
	
	public Vehicle(String ownerName,VehicleType vehicleType, String licenseNo) {
		super();
		this.ownerName=ownerName;
		this.vehicleType = vehicleType;
		this.licenseNo = licenseNo;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
//	public Driver getDriver() {
//		return driver;
//	}
//	public void setDriver(Driver driver) {
//		this.driver = driver;
//	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
