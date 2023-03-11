package edu.unca.csci202;
/**
 * 
 * @author Kamren Sims
 * Defines what a customer is, uses getters for the amount of groceries/time remaining.
 * also has the constructor which is used to hold the grocery items they're carrying and the customer's cart.
 */

public class Customer {
	private int groceryItems;
	private int timeRemaining;

	/**
	 * Constructor, takes in two integer parameters, number of grocery items and time it takes to process cart
	 * @param groceryItems 
	 * @param processCart 
	 */

	public Customer(int groceryItems, int processCart){
		this.groceryItems = groceryItems;
		this.timeRemaining = processCart * groceryItems;

	}

	/**
	 * Getter for the amount of groceries
	 * @return groceryItems - the amount of groceries
	 */

	public int getgroceryItems() {
		return groceryItems;
	}
	
	/**
	 * Sets the number of items
	 * @param groceryItems
	 */
	
	public void setgroceryItems(int groceryItems) {
		this.groceryItems = groceryItems;
	}

	/**
	 * Sets the checkout time for customer
	 * @param timeRemaining
	 */
	
	public void settimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	

	/**
	 * Getter for the time remaining 
	 * @return timeRemaining - the remaining amount of time
	 */
	public int gettimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Decrements the time remaining until transaction is complete
	 */
	public void decreaseTime() {
		this.timeRemaining--;
	}


}
