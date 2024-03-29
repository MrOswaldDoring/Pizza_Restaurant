package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;

/**
 * 
 *  A class that represents a meat lovers pizza made at the Pizza Palace restaurant. 
 *  The meat lovers pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Jonny Hall - n9697985
 *
 */
public class MeatLoversPizza extends Pizza {

	/**
	 * 
	 *  This class represents a meat lovers pizza made at the  Pizza Palace restaurant. The meat lovers pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
 	 * <P> PRE: TRUE
 	 * <P> POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MeatLoversPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		
		/* Creating pizza superclass with meatlovers pizza */
		super(quantity, orderTime, deliveryTime, Pizza.MEATLOVERS_PIZZA, Pizza.MEATLOVERS_SALE_PRICE);
		
		if (quantity > Pizza.MAX_PIZZA_QUANTITY){
			throw new PizzaException("A maximum of 10 pizzas are allowed per order!");
		} else if (quantity < 1){
			throw new PizzaException("No pizzas were added to the order!");
		} else if (orderTime.isBefore(KITCHEN_OPEN_TIME)){
			throw new PizzaException("The Kitchen is unable to take orders before 7pm!");
		}else if (orderTime.isAfter(KITCHEN_CLOSE_TIME)){
			throw new PizzaException("The Kitchen has closed for the night!");
		}else if (deliveryTime.isBefore(orderTime)){
			throw new PizzaException("A pizza cannot be delivered before its ordered!");
		}else if (deliveryTime.minusMinutes(10).isBefore(orderTime)){
			throw new PizzaException("A pizza takes 10 minutes to cook!");
		}else if (deliveryTime.minusHours(1).isAfter(orderTime.minusMinutes(1))){
			throw new PizzaException("A pizza is thrown out after an hour");
		}else if (orderTime == deliveryTime){
			throw new PizzaException("Please allow 10 minutes for the pizza to cook!");
		}
		
	}

}
