package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to have their pizza delivered by a driver. 
 * This class extends the abstract Customer class and calculates the delivery distance as the Manhattan  
 * Distance between the customer and the restaurant. A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.
 * 
 * @author Person B
 *
 */
public class DriverDeliveryCustomer extends Customer {
	
	private int locationX;
	private int locationY;

	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to have their pizza delivered by 
	 *  a driver.  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment
	 *  Specification are violated. 
     *
     *  <P>PRE: TRUE
 	 *  <P>POST: All field values are set
	 *  
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY -  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if supplied parameters are invalid
	 * 
	 */
	public DriverDeliveryCustomer(String name, String mobileNumber, int locationX, int locationY) throws CustomerException {
		
		super(name, mobileNumber, locationX, locationY, "Driver Delivery");
		
		int lenMobNum = Integer.valueOf(mobileNumber).toString().length();
		int firstDigitMob = Integer.parseInt(mobileNumber.substring(0, 1));
		
		if (name.length() < 1 || name.length() > 20){
			throw new CustomerException("Name is not valid, must be between 1 and 20 characters long!");
		}
		if (name.trim().length() == 0){
			throw new CustomerException("Customer name does not contain any characters!");
		}
		if (lenMobNum != 10){
			throw new CustomerException("Mobile numbers must 10 numbers long!");
		}
		if (firstDigitMob != 0){
			throw new CustomerException("Mobile numbers must begin with a 0!");
		}
		if (locationX > 10 || locationX < -10 || locationY > 10 || locationY < -10){
			throw new CustomerException("The delivery address is too far from the restaurant!");
		}
		if(locationX == 0 && locationY == 0){
			throw new CustomerException("The restaurant is not able to deliver to itself!");
		}
		
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	/**
	 * Returns the Manhattan Distance between the instance of DriverDeliveryCustomer and the restaurant. Overrides  
	 * getDeliveryDistance() in Customer.
	 * 
	 * @return The distance between the restaurant and the customer in Manhattan distance.
	 */
	@Override
	public double getDeliveryDistance() {	
		double xDistance = Math.abs(locationX);
		double yDistance = Math.abs(locationY);
		return xDistance + yDistance;
		
	}

}
