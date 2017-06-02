package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Jonny Hall n9697985
 */
public class LogHandlerCustomerTests {
	
	String LogOne = "logs\\testSingle.txt";
	String LogTwo = "logs\\20170101.txt";
	
	@Test (expected = LogHandlerException.class)
	public void errorLog() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset("/errfile");
	}
	
	@Test (expected = LogHandlerException.class)
	public void errorLog2() throws PizzaException, LogHandlerException{
		String line = "21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,3";
		LogHandler.createPizza(line);
	}
	
	@Test (expected = LogHandlerException.class)
	public void errorLog3() throws PizzaException, LogHandlerException{
		String line = "29::00:00,21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,3";
		LogHandler.createPizza(line);
	}
	
	@Test (expected = LogHandlerException.class)
	public void errorLog4() throws PizzaException, LogHandlerException{
		String line = "29:00:00,21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,S";
		LogHandler.createPizza(line);
	}
	
	@Test
	public void populateSingleLine() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset(LogOne);
	}
	
	@Test
	public void populateMultiplyLine() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset(LogTwo);
	}
}
