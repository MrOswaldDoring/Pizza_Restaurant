package asgn2Tests;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import asgn2Customers.*;
import asgn2Exceptions.CustomerException;
/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Jonny Hall n9697985
 * 
 *
 */
public class CustomerTests {
	
	DriverDeliveryCustomer driverDelivery;
	DroneDeliveryCustomer droneDelivery;
	PickUpCustomer pickUp;
	
	DriverDeliveryCustomer deliveryDriver;
	
	//Exception Testing
	
	//Tests similar across all the subclasses
	@Test (expected = CustomerException.class)
	public void testNoName() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("", "0123456789", 3, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void testLargeName() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789", 3, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void testWhiteSpace() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("           ", "0123456789", 3, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void shortPhoneLen() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("Mike Hunt", "041", 3, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void longPhoneLen() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("Mike Hunt", "04122354120111452201", 3, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void phoneNumNotLead0() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("Mike Hunt", "1234567890", 3, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void locationXTooLarge() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("Mike Hunt", "0123456789", 11, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void locationXTooSmall() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("Mike Hunt", "0123456789", -33, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void locationYTooLarge() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("Mike Hunt", "0123456789", 11, 3);
	}
		
	@Test (expected = CustomerException.class)
	public void locationYTooSmall() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("Mike Hunt", "0123456789", -33, 3);
	}
	
	@Test (expected = CustomerException.class)
	public void deliveryLocationAtStore() throws CustomerException{
		driverDelivery = new DriverDeliveryCustomer("Mike Hunt", "0123456789", 0, 0);
	}
	
	@Test (expected = CustomerException.class)
	public void testPickUpLocation() throws CustomerException{
		pickUp = new PickUpCustomer("Mike Hunt", "0123456789", 5, 8);
	}
	
	//Functionality Test with an instance of driverDeliveryCustomer
	
	@Before
	public void deliveryInstance() throws CustomerException{
		deliveryDriver = new DriverDeliveryCustomer("Mike Hunt", "0412356789", 3, 3);
	}
	
	@Test
	public void testGetName() throws CustomerException{
		assertEquals("Mike Hunt", deliveryDriver.getName());
	}
	
	@Test
	public void testGetMobile() throws CustomerException{
		assertEquals("0412356789", deliveryDriver.getMobileNumber());
	}
	
	@Test
	public void testGetCustomerType() throws CustomerException{
		assertEquals("Driver Delivery", deliveryDriver.getCustomerType());
	}
	
	@Test
	public void testGetLocationX() throws CustomerException{
		assertEquals(3, deliveryDriver.getLocationX());
	}
	
	@Test
	public void testGetLocationY() throws CustomerException{
		assertEquals(3, deliveryDriver.getLocationY());
	}
	
	@Test
	public void testGetDeliveryDistance() throws CustomerException{
		assertEquals(6, deliveryDriver.getDeliveryDistance(), 0);
	}
	
	//Testing delivery distance with drone
	@Test
	public void testGetDeliveryDistancDrone() throws CustomerException{
		droneDelivery = new DroneDeliveryCustomer("Mike Hunt", "0123456789", 4, 4);
		double testAnswer = Math.sqrt(32);
		assertEquals(testAnswer, droneDelivery.getDeliveryDistance(), 0);
	}
	
	//Testing delivery distance with pickup
	@Test
	public void testDeliveryDistancePickUp() throws CustomerException{
		pickUp = new PickUpCustomer("Mike Hunt", "0123456789", 0, 0);
		assertEquals(0, pickUp.getDeliveryDistance(), 0);
	}
}
