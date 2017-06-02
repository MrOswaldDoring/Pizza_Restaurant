package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Jonny Hall n9697985 and Oswald Doring n9451269
 *
 */
public class LogHandler {

	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		BufferedReader logFile;
		
		try{
			logFile = new BufferedReader(new FileReader(filename));
		} catch (Exception e) {
			throw new LogHandlerException("Error with log file!");
		}
		
		try{
			String x = logFile.readLine();
			while(x != null){
				customerList.add(createCustomer(x));
				x = logFile.readLine();
			}
		logFile.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return customerList;
	
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		BufferedReader logFile;
		
		try{
			logFile = new BufferedReader(new FileReader(filename));
		} catch (Exception e) {
			throw new LogHandlerException("Error with log file!");
		}
		
		try{
			String x = logFile.readLine();
			while(x != null){
				pizzaList.add(createPizza(x));
				x = logFile.readLine();
			}
		logFile.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return pizzaList;
	}				

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		
		String customerCode, name, mobileNumber;
		int locationX, locationY;
		
		String[] customerLog = line.split(",");
		if(customerLog.length != 9){
			throw new LogHandlerException("Insufficient data in the line to process!");
		}
		
		try{
			locationX = Integer.parseInt(customerLog[5]);
			locationY = Integer.parseInt(customerLog[6]);
		}catch (Exception e){
			throw new LogHandlerException("Error with processing customers location!");
		}
		
		name = customerLog[2];
		mobileNumber = customerLog[3];
		customerCode = customerLog[4];
		
		return CustomerFactory.getCustomer(customerCode, name, mobileNumber, locationX, locationY);
							
	}

	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		
		String pizzaCode;
		int quantity;
		LocalTime orderTime, deliveryTime;
		
		String[] pizzaLog = line.split(",");
		/*if(pizzaLog.length != 9){
			throw new LogHandlerException("Insufficient data in the line to process!");
		}
		*/
		try{
			orderTime = LocalTime.parse(pizzaLog[0]);
			deliveryTime = LocalTime.parse(pizzaLog[1]);
		}catch (Exception e){
			throw new LogHandlerException("Error with processing order and delivery times!");
		}
		pizzaCode = pizzaLog[7];
		try{
			quantity = Integer.parseInt(pizzaLog[8]);
		}catch (Exception e){
			throw new LogHandlerException("Error with processing quantity!");
		}
		
		return PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);
							
	}

}
