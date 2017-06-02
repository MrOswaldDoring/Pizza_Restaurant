package asgn2Tests;

import org.junit.*;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import asgn2Restaurant.PizzaRestaurant;

import java.time.LocalTime;


/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Oswald Doring n9451269
 *
 */
public class RestaurantPizzaTests {
	
	String logOne = "logs\\20170101.txt";
	String logTwo = "logs\\20170102.txt";
	String logThree = "logs\\20170103.txt";
	PizzaRestaurant pr;
	MargheritaPizza testPizza;
	
	@Before
	public void setUpStuff() throws PizzaException{
		pr = new PizzaRestaurant();
		testPizza = new MargheritaPizza(1, LocalTime.of(20, 00), LocalTime.of(20, 25));
	}
	
	@Test
	public void processLogOne() throws CustomerException, PizzaException, LogHandlerException{
		pr.processLog(logOne);
	}
	
	@Test
	public void processLogTwo() throws CustomerException, PizzaException, LogHandlerException{
		pr.processLog(logTwo);
	}
	
	@Test
	public void processLogThree() throws CustomerException, PizzaException, LogHandlerException{
		pr.processLog(logThree);
	}
	
	
	@Test(expected = PizzaException.class)
	public void pizzaIndexInvalid() throws PizzaException{
		pr.getPizzaByIndex(5);
	}
	
	@Test
	public void pizzaByIndex() throws PizzaException, CustomerException, LogHandlerException{
		pr.processLog(logOne);
		assertEquals(testPizza, pr.getPizzaByIndex(1));
	}
	
	@Test
	public void customerSize() throws PizzaException, CustomerException, LogHandlerException{
		pr.processLog(logThree);
		assertEquals(100, pr.getNumPizzaOrders());
	}
	
	@Test
	public void totalOrderProfit() throws PizzaException, CustomerException, LogHandlerException{
		pr.processLog(logOne);
		assertEquals(36.5, pr.getTotalProfit(), 0);
	}
	
	@Test
	public void testReset() throws PizzaException, CustomerException, LogHandlerException{
		pr.processLog(logTwo);
		pr.resetDetails();
		assertEquals(0, pr.getNumPizzaOrders());
		assertEquals(0, pr.getTotalProfit(), 0);
	}
}
