package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;
import org.junit.Before;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.PizzaFactory;


/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Oswald Doring n9451269
 * 
 */
public class PizzaFactoryTests {
	
	@Test(expected = PizzaException.class)
	public void testIncorrectCode() throws PizzaException{
		LocalTime orderTime = LocalTime.of(17, 00);
		LocalTime deliveryTime = LocalTime.of(17, 30);
		PizzaFactory.getPizza("ERR", 1, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testIncorrectCode2() throws PizzaException{
		LocalTime orderTime = LocalTime.of(16, 00);
		LocalTime deliveryTime = LocalTime.of(17, 30);
		PizzaFactory.getPizza("PZA", 1, orderTime, deliveryTime);
	}
	
	@Test
	public void testMeatloversPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 00);
		LocalTime deliveryTime = LocalTime.of(20, 30);
		PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
	}
	
	@Test
	public void testMargheritaPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 00);
		LocalTime deliveryTime = LocalTime.of(20, 30);
		PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
	}
	
	@Test
	public void testVegoPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 00);
		LocalTime deliveryTime = LocalTime.of(20, 30);
		PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
	}
}
