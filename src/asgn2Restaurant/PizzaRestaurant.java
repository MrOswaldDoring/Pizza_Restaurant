package asgn2Restaurant;

import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Exceptions.*;
import asgn2Pizzas.Pizza;

/**
 * This class acts as a â€˜modelâ€™ of a pizza restaurant. It contains an ArrayList of Pizza objects and an ArrayList of  Customer objects.
 *  It contains a method that can populate the ArrayLists,  several methods to retrieve information about the ArrayLists and 
 *  a method to reset the array list. Information about the x and y location of the restaurant and the time that first and last 
 *  orders are accepted are listed in Section 5 of the Assignment Specification. 
 *  
 *  Any exceptions raised by one of the methods called by this class should be passed to asgn2GUIs.PizzaGUI so that it can be shown to
 *  the user.
 * 
 * @author Jonny Hall n9697985 & Oswald Doring n9451269
 *
 */
public class PizzaRestaurant {

	private ArrayList<Customer> customers;
	private ArrayList<Pizza> pizzas;

	
	/**
	 * Creates an instance of the PizzaRestaurant and sets the customers and pizzas fields to
	 * an appropriate initial empty state. 
	 * 
	 * <P> PRE: TRUE
	 * <P> POST: The customers and pizzas fields are initialized to an empty state
	 * 
	 */
	public PizzaRestaurant() {
		customers = new ArrayList<Customer>();
		pizzas = new ArrayList<Pizza>();
	}

	/**
	 * This method processes the information contained in the log file and populates the customers and pizzas fields.  
	 * The other classes that the method interacts with are listed in Section 11 of the specification document. 
     *
     * <P> PRE: TRUE
     * <P>POST: If no exception is thrown then the customers and pizzas fields are populated with the details in the log file ordered as they appear in the log file.
     * <P>      If an exception is thrown then the customers and pizzas fields should be empty.
     * 
	 * @param filename The log's filename
	 * @return true if the file was processed correctly 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above (passed by another class).
     *
	 */
	public boolean processLog(String filename) throws CustomerException, PizzaException, LogHandlerException{
		
		/* Tries to process provided files, and creates pizzas and customers if successful */
		try{
			customers = LogHandler.populateCustomerDataset(filename);
			pizzas = LogHandler.populatePizzaDataset(filename);
			
			return true;
			
		}catch(Exception e){
			System.out.println("The log file was unsucessfully processed!");
			e.printStackTrace();
			return false;
		}
	
	}

	/**
	 * Returns the Customer object contained at the specified index of the customers field. The index should be the same as the index in the log file.
	 * @param index - The index within the customers field to retrieve.
	 * @return The Customer object located at the specified index.
	 * @throws CustomerException if index is invalid.
	 */
	public Customer getCustomerByIndex(int index) throws CustomerException{
		if (index < 0 || index > customers.size() - 1){
			throw new CustomerException("The index value is invalid");
		}
		return customers.get(index);
		
	}
	
	/**
	 * Returns the Pizza object contained at the specified index of the pizzas field. The index should be the same as the index in the log file.
	 * @param index - The index within the pizzas field to retrieve.
	 * @return The Pizza object located at the specified index.
	 * @throws PizzaException if index is invalid.
	 */	
	public Pizza getPizzaByIndex(int index) throws PizzaException{
		if (index < 0 || index > pizzas.size() - 1){
			throw new PizzaException("The index value is invalid");
		}
		return pizzas.get(index);
	}
	
	/**
	 * Returns the number of objects contained in the pizzas field. This value SHOULD be the same as 
	 * the value returned by getNumCustomerOrders.
	 * 
	 * @return the number of objects contained in the pizzas field.
	 */
	public int getNumPizzaOrders(){
		return pizzas.size();
	}

	/**
	 * Returns the number of objects contained in the customers field. This value SHOULD be the same as 
	 * the value returned by getNumPizzaOrders.
	 * 
	 * @return the number of objects contained in the customers field.
	 */
	public int getNumCustomerOrders(){
		return customers.size();
	}

	
	/**
	 * Returns the total delivery distance for all of the customers.
	 * 
	 * @return the total delivery distance for all Customers objects in the customers field.
	 */
	public double getTotalDeliveryDistance(){
		double deliveryDistanceTotal = 0;
		for(Customer customer: customers){
			deliveryDistanceTotal += customer.getDeliveryDistance();
		}
		return deliveryDistanceTotal;
	}

	/**
	 * Returns the total profit for all of the pizza orders.
	 * 
	 * @return the total profit for all of the Pizza objects in the pizzas field.
	 */	
	public double getTotalProfit(){
		
		double orderProfitTotal = 0;
	
		for(Pizza pizza: pizzas){
			pizza.calculateCostPerPizza();
			orderProfitTotal += pizza.getOrderProfit();
		}
		return orderProfitTotal;
	}
	
	/**
	 * Resets the pizzas and customers fields to their initial empty states.
	 * 
	 * <P> PRE: True
	 * <P> POST:  The pizzas and customers fields are set to their initial empty states
	 */
	public void resetDetails(){
		customers.clear();
		pizzas.clear();
	}

}
