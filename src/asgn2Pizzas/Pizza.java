package asgn2Pizzas;

import java.time.LocalTime;
import java.util.ArrayList;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Jonny Hall - n9697985
 *
 */
public abstract class Pizza  {
	
	protected static final String margheritaHumanReadable = "Margherita";
	protected static final String meatloversHumanReadable = "Meat Lovers";
	protected static final String vegetarianHumanReadable = "Vegetarian";
	
	protected static final String margheritaShortFormat = "PZM";
	protected static final String meatLoversShortFormat = "PZL";
	protected static final String vegetarianShortFormat = "PZV";
	
	protected static final int margheritaSalePrice = 8;
	protected static final int meatLoversSalePrice = 12;
	protected static final int vegetarianSalePrice = 10;
	
	protected static final LocalTime kitchenOpen = LocalTime.of(19, 00);
	protected static final LocalTime kitchenClose = LocalTime.of(23, 00);
	
	private ArrayList<PizzaTopping> meatLoversToppings = new ArrayList<PizzaTopping>();
	private ArrayList<PizzaTopping> vegetarianToppings = new ArrayList<PizzaTopping>();
	private ArrayList<PizzaTopping> margheritaToppings = new ArrayList<PizzaTopping>();
	
	private int quantity;
	private String type;
	private double price;
	private double costPerPizza;
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
	
		this.quantity = quantity;
		this.type = type;
		this.price = price;
		
		if(type.equals(meatloversHumanReadable)){
			meatLoversToppings.add(PizzaTopping.TOMATO);
			meatLoversToppings.add(PizzaTopping.CHEESE);
			meatLoversToppings.add(PizzaTopping.BACON);
			meatLoversToppings.add(PizzaTopping.SALAMI);
			meatLoversToppings.add(PizzaTopping.PEPPERONI);
		}
		
		if(type.equals(margheritaHumanReadable)){
			margheritaToppings.add(PizzaTopping.CHEESE);
			margheritaToppings.add(PizzaTopping.TOMATO);
		}
		
		if(type.equals(vegetarianHumanReadable)){
			vegetarianToppings.add(PizzaTopping.CHEESE);
			vegetarianToppings.add(PizzaTopping.TOMATO);
			vegetarianToppings.add(PizzaTopping.EGGPLANT);
			vegetarianToppings.add(PizzaTopping.MUSHROOM);
			vegetarianToppings.add(PizzaTopping.CAPSICUM);
		}
		
	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		
		costPerPizza = 0;
	
		if(type.equals(margheritaHumanReadable)){
			for(PizzaTopping toppings: margheritaToppings){
				costPerPizza += (Double)toppings.getCost();
			}
		} else if(type.equals(meatloversHumanReadable)){
			for(PizzaTopping toppings: meatLoversToppings){
				costPerPizza += (Double)toppings.getCost();
			}
		} else if(type.equals(vegetarianHumanReadable)){
			for(PizzaTopping toppings: vegetarianToppings){
				costPerPizza += (Double)toppings.getCost();
			}
		}
		
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		
		return costPerPizza;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		
		return price;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		
		return this.getCostPerPizza() * quantity;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		
		return price * quantity;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		
		return this.getOrderPrice() - this.getOrderCost();
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		
		if(type.equals(margheritaHumanReadable)){
			return margheritaToppings.contains(topping);
		} else if(type.equals(meatloversHumanReadable)){
			return meatLoversToppings.contains(topping);
		} else if(type.equals(vegetarianHumanReadable)){
			return vegetarianToppings.contains(topping);
		} return false;
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		
		return quantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		return type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
