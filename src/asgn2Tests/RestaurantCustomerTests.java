package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Jonny Hall n9697985
 */
public class RestaurantCustomerTests {
	
	String logOne = "logs\\20170101.txt";
	String logTwo = "logs\\20170102.txt";
	String logThree = "logs\\20170103.txt";
	PizzaRestaurant restaurant;
	
	@Before
	public void setUp() throws PizzaException{
		restaurant = new PizzaRestaurant();
	}
	
	@Test
	public void processLogOne() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logOne);
	}
	
	@Test
	public void processLogTwo() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logTwo);
	}
	
	@Test
	public void processLogThree() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logThree);
	}
	
	@Test (expected = CustomerException.class)
	public void CustomerOutOfIndex() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logOne);
		restaurant.getCustomerByIndex(3);
	}
	
	@Test
	public void customerByIndex() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logOne);
		PickUpCustomer testCustomer = new PickUpCustomer("Oroku Saki", "0111222333", 0, 0);
		assertEquals(testCustomer, restaurant.getCustomerByIndex(2));
	}
	
	@Test
	public void customerArraySize() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logOne);
		assertEquals(3, restaurant.getNumCustomerOrders());
	}
	
	@Test
	public void totalDeliveryDistance() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logOne);
		double droneDistance = Math.sqrt((Math.pow(3 - 0, 2)) + (Math.pow(4 - 0, 2)));
		double totalDistanceCheck = droneDistance + 10;
		assertEquals(totalDistanceCheck, restaurant.getTotalDeliveryDistance(), 0);
	}
	
	@Test
	public void resetTest() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logTwo);
		restaurant.resetDetails();
		assertEquals(0, restaurant.getNumCustomerOrders());
		assertEquals(0, restaurant.getTotalDeliveryDistance(), 0);
	}
}
