package Entity;

import java.util.ArrayList;
import java.util.List;

import Enum.Gender;

public class User {

	Long userId;
	String userName;
	String email;
	String password;
	Integer age;
	List<Ride> rideList;
	Gender gender;

	public User(String userName,  Gender gender,Integer age) {
		super();
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		rideList=new ArrayList<>();
	}
	public User() {
		
	}
	
	public List<Ride> getRideList() {
		return rideList;
	}

	public void setRideList(List<Ride> rideList) {
		this.rideList = rideList;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public List<Ride> addRides(Ride ride)
	{
		rideList.add(ride);
		return rideList;
	}
	
	public int getRideSize()
	{
		return rideList.size();
	}
	
	
}
