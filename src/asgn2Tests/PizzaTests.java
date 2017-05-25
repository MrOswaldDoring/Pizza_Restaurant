package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.*;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.*;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Oswald Doring n9451269
 *
 */
public class PizzaTests {
	
	MeatLoversPizza meatLovers;
	VegetarianPizza vegetarian;
	MargheritaPizza margherita; 
	
	// Exception testing
	
	//MargheitaPizza class exception testing
	
	@Test(expected = PizzaException.class)
	public void marghertiaException1() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 0;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void margheritaException2() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 18;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void marghertiaException3() throws PizzaException{
		LocalTime orderTime = LocalTime.of(18, 45);
		LocalTime deliveryTime = LocalTime.of(19, 15);
		int quantity = 5;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void margheritaException4() throws PizzaException{
		LocalTime orderTime = LocalTime.of(23, 20);
		LocalTime deliveryTime = LocalTime.of(23, 45);
		int quantity = 5;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void margheritaException5() throws PizzaException{
		LocalTime orderTime = LocalTime.of(11, 20);
		LocalTime deliveryTime = LocalTime.of(12, 00);
		int quantity = 5;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void margheritaException6() throws PizzaException{
		LocalTime orderTime = LocalTime.of(22, 45);
		LocalTime deliveryTime = LocalTime.of(23, 15);
		int quantity = 5;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void margheritaException7() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 20);
		LocalTime deliveryTime = LocalTime.of(21, 45);
		int quantity = 5;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void margheritaException8() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 15);
		LocalTime deliveryTime = LocalTime.of(20, 20);
		int quantity = 5;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void margheritaException9() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 45);
		LocalTime deliveryTime = LocalTime.of(20, 15);
		int quantity = 5;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	//Vegetarian Pizza Class exception testing
	
	@Test(expected = PizzaException.class)
	public void vegetarianException1() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 0;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegetarianException2() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 18;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegetarianException3() throws PizzaException{
		LocalTime orderTime = LocalTime.of(18, 45);
		LocalTime deliveryTime = LocalTime.of(19, 15);
		int quantity = 5;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegetarianException4() throws PizzaException{
		LocalTime orderTime = LocalTime.of(23, 20);
		LocalTime deliveryTime = LocalTime.of(23, 45);
		int quantity = 5;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegetarianException5() throws PizzaException{
		LocalTime orderTime = LocalTime.of(11, 20);
		LocalTime deliveryTime = LocalTime.of(12, 00);
		int quantity = 5;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegetarianException6() throws PizzaException{
		LocalTime orderTime = LocalTime.of(22, 45);
		LocalTime deliveryTime = LocalTime.of(23, 15);
		int quantity = 5;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegetarianException7() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 20);
		LocalTime deliveryTime = LocalTime.of(21, 45);
		int quantity = 5;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegetarianException8() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 15);
		LocalTime deliveryTime = LocalTime.of(20, 20);
		int quantity = 5;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void vegetarianException9() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 45);
		LocalTime deliveryTime = LocalTime.of(20, 15);
		int quantity = 5;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	//Meatlovers Pizza Class exception testing
	
	@Test(expected = PizzaException.class)
	public void meatLoversException1() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 0;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversException2() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 18;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversException3() throws PizzaException{
		LocalTime orderTime = LocalTime.of(18, 45);
		LocalTime deliveryTime = LocalTime.of(19, 15);
		int quantity = 5;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversException4() throws PizzaException{
		LocalTime orderTime = LocalTime.of(23, 20);
		LocalTime deliveryTime = LocalTime.of(23, 45);
		int quantity = 5;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversException5() throws PizzaException{
		LocalTime orderTime = LocalTime.of(11, 20);
		LocalTime deliveryTime = LocalTime.of(12, 00);
		int quantity = 5;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversException6() throws PizzaException{
		LocalTime orderTime = LocalTime.of(22, 45);
		LocalTime deliveryTime = LocalTime.of(23, 15);
		int quantity = 5;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversException7() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 20);
		LocalTime deliveryTime = LocalTime.of(21, 45);
		int quantity = 5;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversException8() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 15);
		LocalTime deliveryTime = LocalTime.of(20, 20);
		int quantity = 5;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void meatLoversException9() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 45);
		LocalTime deliveryTime = LocalTime.of(20, 15);
		int quantity = 5;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	//Testing functionality of each pizza class
	
	@Test
	public void margheritaPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 45);
		LocalTime deliveryTime = LocalTime.of(21, 15);
		int quantity = 5;
		margherita = new MargheritaPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test
	public void meatLoversPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 45);
		LocalTime deliveryTime = LocalTime.of(21, 15);
		int quantity = 5;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test
	public void vegetarianPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 45);
		LocalTime deliveryTime = LocalTime.of(21, 15);
		int quantity = 5;
		vegetarian = new VegetarianPizza(quantity, orderTime, deliveryTime);
	}
	
	@Test
	public void pizzaCalcCost() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertEquals(5.00, meatLovers.getCostPerPizza(), 0);
	} 
	
	@Test
	public void pizzaPricePer() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertEquals(12.00, meatLovers.getPricePerPizza(), 0);
	}
	
	@Test
	public void pizzaOrderCost() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertEquals(35.00, meatLovers.getOrderCost(), 0);
	}
	
	@Test
	public void pizzaOrderPrice() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertEquals(84.00, meatLovers.getOrderPrice(), 0);
	}
	
	@Test
	public void pizzaOrderProfit() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertEquals(49.00, meatLovers.getOrderProfit(), 0);
	}
	
	@Test
	public void pizzaContainTopTrue() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertTrue(meatLovers.containsTopping(PizzaTopping.CHEESE));
	}
	
	@Test
	public void pizzaContainTopFalse() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertFalse(meatLovers.containsTopping(PizzaTopping.EGGPLANT));
	}
	
	@Test
	public void pizzaQuantity() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertEquals(7, meatLovers.getQuantity());
	}
	
	@Test
	public void pizzaType() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 30);
		LocalTime deliveryTime = LocalTime.of(21, 00);
		int quantity = 7;
		meatLovers = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		assertEquals("Meat Lovers", meatLovers.getPizzaType());
	}
}

