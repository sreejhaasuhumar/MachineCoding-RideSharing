package Driver;

import java.util.List;
import java.util.Scanner;

import Entity.Driver;
import Entity.Ride;
import Entity.User;
import Enum.Gender;
import Enum.VehicleType;
import Service.RideSharingImpl;

public class DriverClass {

	public static void main(String[] args) throws Exception {

		RideSharingImpl service=new RideSharingImpl();
		Scanner in=new Scanner(System.in);
		while(true)
		{
			String[] input=in.next().split("-");
			String command=input[0];
			switch(command)
			{
			case "addUser":
			{
				String userName=input[1];
				Gender gender=Gender.valueOf(input[2]);
				Integer age=Integer.parseInt(input[3]);
				User user=service.addUser(userName, gender,age);
				System.out.println(user.getUserName()+" added successfully");
				break;
			}
			case "addVehicle":
			{
				String userName=input[1];
				VehicleType vehicleType=VehicleType.valueOf(input[2]);
				String licenseNo=input[3];
				Driver driver=service.addVehicle(userName, vehicleType, licenseNo);
			    System.out.println(driver.getVehicle().getVehicleType()+ " got added to the user "+driver.getUserName()+" successfully");
			    break;
			}
			case "offerRide" :
			{
				String userName=input[1];
				String origin=input[2];
				String destination=input[3];
				Integer availableSeatCount=Integer.parseInt(input[4]);
				VehicleType vehicleType=VehicleType.valueOf(input[5]);
				String licenseNo=input[6];
				Ride ride=service.offerRide(userName, origin, destination, availableSeatCount, vehicleType, licenseNo);
			    System.out.println("Ride "+ride.getRideName()+" from "+ride.getOrigin()+" to "+ride.getDestination()+" id offered by "+ride.getDriver().getUserName());
			    break;
			}
			case "selectRide" :
			{
				String userName=input[1];
				String origin=input[2];
				String destination=input[3];
				Integer requestedSeatCount=Integer.parseInt(input[4]);
				VehicleType strategy=VehicleType.valueOf(input[5]);
				List<Ride> rideList=service.selectRide(userName, origin, destination, requestedSeatCount, strategy);
			    System.out.println("Below are the list of rides available for the user "+userName);
			    for(Ride iterator:rideList)
			    {
			    	System.out.println("Ride name:"+iterator.getRideName()+" Origin:"+iterator.getOrigin()+" Destination:"+iterator.getDestination()+ "Driver name:"+iterator.getDriver().getUserName()+" Vehicle:"+iterator.getStrategy());
			    	System.out.println("\n");
			    }
			    break;
			}
			case "endRide" :
			{
				String rideName=input[1];
				Boolean isRideEnded=service.endRide(rideName);
				if(isRideEnded)
					System.out.println("Ride "+rideName+" ended successfully");
				else
					System.out.println("Ride "+rideName+" doesnt end successfully");

				break;
			}
			case "getRideCount" :
			{
				String userName=input[1];
				Integer rideCount=service.getTotalRides(userName);
				System.out.println("Total number of rides taken by "+userName+" is "+rideCount);
                break;
			}
			case "printRideStatus" :
			{
				String userName=input[1];
				service.printRideStatus(userName);
				break;
			}
				
		}
		
	}

}
}
