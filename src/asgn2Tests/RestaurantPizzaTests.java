package asgn2Tests;

import org.junit.*;

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
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	// TO DO
	MeatLoversPizza meatLovers;
	VegetarianPizza vegetarian;
	MargheritaPizza margherita;
	
	@Before
	public void initalisePizzas() throws PizzaException{
		PizzaRestaurant pr = new PizzaRestaurant();
		LocalTime orderTime = LocalTime.of(20, 00);
		LocalTime deliveryTime = LocalTime.of(20, 45);
		int quantity = 1;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
		pr.
		
	}
	
	@Test(Expected = PizzaException.class)
	public void pizzaIndexInvalid() throws PizzaException{
		PizzaRestaurant.getPizzaByIndex(5);
	}
}
