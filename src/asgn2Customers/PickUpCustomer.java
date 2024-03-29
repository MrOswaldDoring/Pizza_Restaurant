package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to collect their pizza at the restaurant. 
 *  This class extends the abstract Customer class. Since the customer is at the restaurant the delivery 
 *  distance should be zero.  A description of the class's fields and their constraints is provided 
 *  in Section 5.2 of the Assignment Specification.
 *
 * @author Oswald Doring
 *
 */
public class PickUpCustomer extends Customer {
	
	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to pickup their pizza at the restaurant. 
	 *  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment Specification are violated. 
	 *  
	 * <P> PRE: TRUE
 	 * <P> POST: All field values are set
	 *  
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if supplied parameters are invalid
	 * 
	 */
	public PickUpCustomer(String name, String mobileNumber, int locationX,  int locationY) throws CustomerException {
		
		/* Creating instance of Customer super class with PickUp details */
		super(name, mobileNumber, locationX, locationY, Customer.PICK_UP_CUSTOMER);
		
		/* Getting mobileNumber length and first number for exception testing */
		int lenMobNum = mobileNumber.length();
		int firstDigitMob = Integer.parseInt(mobileNumber.substring(0, 1));
		
		if(name.length() < 1 || name.length() > Customer.MAX_NAME_LENGTH){
			throw new CustomerException("The customers name needs to be been 1 character and 20 characters long");
		}else if (name.trim().length() == 0){
				throw new CustomerException("Customer name does not contain any characters!");
		}else if(lenMobNum != Customer.MOBILE_LENGTH){
			throw new CustomerException("Mobile numbers must be 10 digits long");
		}else if(firstDigitMob != 0){
			throw new CustomerException("Mobile numbers must begin with a 0!");
		}else if(locationX != 0 || locationY != 0){
			throw new CustomerException("Customers location must be 0, 0 if it is a Pick Up!");
		}
		
	}

	/**
	 *  Overrides DeliveryDistance() in Customer. Since the customer is at the restaurant the delivery distance should be zero. 
	 *  
     * @return The value 0
	 */
	@Override
	public double getDeliveryDistance() {
		return 0;
	}

}
