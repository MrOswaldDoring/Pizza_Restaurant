package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Oswald Doring n9451269
* 
*/
public class LogHandlerPizzaTests {
	
	String LogFileOne = "logs\\20170101.txt";
	String LogFileTwo = "logs\\testSingle.txt";
	
	@Test (expected = LogHandlerException.class)
	public void errorLog1() throws PizzaException, LogHandlerException{
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
		LogHandler.populatePizzaDataset(LogFileTwo);
	}
	
	@Test
	public void populateMultiplyLine() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset(LogFileOne);
	}

}
