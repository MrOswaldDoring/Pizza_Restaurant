package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.PizzaTopping;



/**
 * 
 *  A class that represents a margherita pizza made at the Pizza Palace restaurant. 
 *  The margherita pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Jonny Hall - n9697985
 *
 */
public class MargheritaPizza extends Pizza {

	
	/**
	 * 
	 *  This class represents a margherita pizza made at the  Pizza Palace restaurant.   The margherita pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
	 * <P>PRE: TRUE
	 * <P>POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MargheritaPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		
		super(quantity, orderTime, deliveryTime, Pizza.margheritaHumanReadable, Pizza.margheritaSalePrice);
		
		if (quantity > 10){
			throw new PizzaException("A maximum of 10 pizzas are allowed per order!");
		} else if (quantity < 1){
			throw new PizzaException("No pizzas were added to the order!");
		} else if (orderTime.isBefore(kitchenOpen)){
			throw new PizzaException("The Kitchen is unable to take orders before 7pm!");
		}else if (deliveryTime.isAfter(kitchenClose)){
			throw new PizzaException("The Kitchen has closed for the night!");
		}else if (deliveryTime.isBefore(orderTime)){
			throw new PizzaException("A pizza cannot be delivered before its ordered!");
		}else if (deliveryTime.minusMinutes(11).isBefore(orderTime)){
			throw new PizzaException("A pizza takes 10 minutes to cook!");
		}else if (deliveryTime.minusHours(1).isAfter(orderTime.minusMinutes(1))){
			throw new PizzaException("A pizza is thrown out after an hour");
		}else if (orderTime == deliveryTime){
			throw new PizzaException("Please allow 10 minutes for the pizza to cook!");
		}
		
	}
	
}
