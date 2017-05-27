package asgn2Tests;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A - Jonny Hall n9697985
 *
 */
public class CustomerFactoryTests {
	@Test
	public void CustomerFactoryPickupTest() throws CustomerException{
		Customer pizzaTest = CustomerFactory.getCustomer("PUC", "Jonny", "0123456789", 0, 0);	
	}
	
	@Test
	public void CustomerFactoryDroneTest() throws CustomerException{
		Customer pizzaTest = CustomerFactory.getCustomer("DNC", "Jonny", "0123456789", 1, 4);	
	}
	
	@Test
	public void CustomerFactoryDeliveryTest() throws CustomerException{
		Customer pizzaTest = CustomerFactory.getCustomer("DVC", "Jonny", "0123456789", 1, 4);	
	}
	
	// Exception Tests
	
	@Test (expected = CustomerException.class)
	public void PizzaFactoryException() throws CustomerException{
		Customer pizzaTest = CustomerFactory.getCustomer("ERR", "Jonny", "0123456789", 1, 4);	
	}
}
