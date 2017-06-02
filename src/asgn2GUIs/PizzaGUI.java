package asgn2GUIs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;

/**
 * This class is the graphical user interface for the rest of the system.
 * Currently it is a �dummy� class which extends JFrame and implements Runnable
 * and ActionLister. It should contain an instance of an
 * asgn2Restaurant.PizzaRestaurant object which you can use to interact with the
 * rest of the system. You may choose to implement this class as you like,
 * including changing its class signature � as long as it maintains its core
 * responsibility of acting as a GUI for the rest of the system. You can also
 * use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Jonny Hall (n9697985) and Oswald Doring (n9451269)
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {

	private PizzaRestaurant theRestaurant;

	private JFrame theWindow;
	private JFileChooser theFile;
	private JTextArea theOutputArea;
	private JButton open, exit, profit, order, reset, distance;
	private JScrollPane theScroller;
	private JPanel theMainPanel;
	private Boolean fileLoaded = false;
	private String FormTitle;

	/**
	 * Creates a new Pizza GUI with the specified title
	 * 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		this.FormTitle = title;

		// Create a new Restaurant
		theRestaurant = new PizzaRestaurant();
	}

	public void run() {
		// Create the Frame
		theWindow = new JFrame(FormTitle);
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the panel
		JPanel MainPane = theMainPanel();

		// Window Settings
		theWindow.add(MainPane);
		theWindow.pack();
		theWindow.setVisible(true);
	}

	public JPanel theMainPanel() {
		// Load Button
		open = new JButton("Select File");
		open.addActionListener(this);
		open.setActionCommand("Load");

		// Profit button
		profit = new JButton("Profit");
		profit.addActionListener(this);
		profit.setActionCommand("Profit");

		// Distance Button
		distance = new JButton("Distance");
		distance.addActionListener(this);
		distance.setActionCommand("Distance");

		// Order Number
		order = new JButton("Orders");
		order.addActionListener(this);
		order.setActionCommand("Order");

		// Reset Button
		reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setActionCommand("Reset");

		// Exit Button
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setActionCommand("Exit");

		// OutPutArea
		theOutputArea = new JTextArea(30, 40);
		theOutputArea.setEditable(false);

		// ScrollPane
		theScroller = new JScrollPane(theOutputArea);
		theScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		theScroller.setPreferredSize(new Dimension(500, 600));

		// theMainPanel
		theMainPanel = new JPanel();

		// Frame Layout
		GroupLayout layout = new GroupLayout(theMainPanel);
		theMainPanel.setLayout(layout);

		// Setup for the horizontal groups
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						// Group 1
						.addComponent(theScroller))
				.addGroup(layout.createSequentialGroup()
						// Group 2
						.addComponent(open).addComponent(profit).addComponent(distance)
						.addComponent(order).addComponent(reset).addComponent(exit)));
		// Setup for the vertical groups
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						// Top group
						.addComponent(open).addComponent(profit).addComponent(distance)
						.addComponent(order).addComponent(reset).addComponent(exit))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						// bottom group
						.addComponent(theScroller)));
		return theMainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		// This is the Exit button to close the whole program
		case "Exit":
			theWindow.dispose();
			break;

		// This is the button to load a file (Strictly .txt file)
		case "Load":
			theFile = new JFileChooser();
			int returnValue = theFile.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				if (theFile.getSelectedFile().getPath().toString().contains(".txt")) {
					File selectedFile = theFile.getSelectedFile();
					try {
						// Process the log file
						if (theRestaurant.processLog(selectedFile.getPath().toString()) == true) {
							theOutputArea.setText("Successfully Loaded File");
							fileLoaded = true;
						}
					} catch (Exception ex) {
						// This exception will display if there is an error in
						// the log file
						theOutputArea.setText(ex.getMessage());
					}
				} else {
					theOutputArea.setText("Invalid File Type: Please Select a .txt File.");
				}
			}
			break;

		// This is the button to display the total Profit from the day
		case "Profit":
			if (fileLoaded == true) {
				DecimalFormat df = new DecimalFormat("#.00");
				theOutputArea.setText("The total profit from the log is: $" + df.format(theRestaurant.getTotalProfit()));
			} else {
				theOutputArea.setText("Cannot Perform Action: No file Loaded.");
			}
			break;

		// This is the Reset button
		case "Reset":
			if (fileLoaded == true) {
				theRestaurant.resetDetails();
				fileLoaded = false;
				theOutputArea.setText("Reset Complete");
			} else {
				theOutputArea.setText("Cannot Perform Action: No file Loaded.");
			}
			break;

		// This is the Order button
		case "Order":
			if (fileLoaded == true) {
				try {
					String OutPut = "";
					// This will create a string for every Information string
					// needing to be displayed
					for (int i = 0; i < theRestaurant.getNumCustomerOrders(); i++) {
						DecimalFormat df = new DecimalFormat("#.00");
						String CustomerName = theRestaurant.getCustomerByIndex(i).getName();
						String CustomerMob = theRestaurant.getCustomerByIndex(i).getMobileNumber();
						String CustomerType = theRestaurant.getCustomerByIndex(i).getCustomerType();
						Integer XLocation = theRestaurant.getCustomerByIndex(i).getLocationX();
						Integer YLocation = theRestaurant.getCustomerByIndex(i).getLocationY();
						Double Distance = theRestaurant.getCustomerByIndex(i).getDeliveryDistance();

						String PizzaType = theRestaurant.getPizzaByIndex(i).getPizzaType();
						Integer Quantity = theRestaurant.getPizzaByIndex(i).getQuantity();
						Double OrderPrice = theRestaurant.getPizzaByIndex(i).getOrderPrice();
						Double OrderCost = theRestaurant.getPizzaByIndex(i).getOrderCost();
						Double OrderProfit = theRestaurant.getPizzaByIndex(i).getOrderProfit();

						// Build
						OutPut += "Customer " + (i + 1) + ": \n Customer Name: " + CustomerName + "\n Mobile Number: "
								+ CustomerMob + "\n CustomerType: " + CustomerType + "\n X and Y Location: " + XLocation
								+ ":" + YLocation + "\n Delivery Distnace from Restaurant: " + df.format(Distance)
								+ "km" + "\n" + "\n Order " + (i + 1) + ": \n Pizza Type: " + PizzaType
								+ "\n Quantity: " + Quantity + "\n Order Price: $" + df.format(OrderPrice)
								+ "\n Order Cost: $" + df.format(OrderCost) + "\n Order Profit: $"
								+ df.format(OrderProfit) + "\n \n";
					}
					theOutputArea.setText(OutPut);
				} catch (Exception ex) {
					theOutputArea.setText(ex.getMessage());
				}
			} else {
				theOutputArea.setText("Cannot Perform Action: No file Loaded.");
			}
			break;
		// This is the button that will return the total distance travelled for
		// the day
		case "Distance":
			if (fileLoaded == true) {
				DecimalFormat df = new DecimalFormat("#.00");
				theOutputArea.setText(
						"Total Distance Travelled: " + df.format(theRestaurant.getTotalDeliveryDistance()) + "km");
			} else {
				theOutputArea.setText("Cannot Perform Action: No file Loaded.");
			}
			break;
		}
	}
}
