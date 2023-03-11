package edu.unca.csci202;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

/**
 * 
 * @author Kamren Sims
 * The class that deals with all the math for the most part
 * Creates an Arraylist to hold the lines, and a deque to hold the customers
 * Also at the end contains what would be printed out into the console 
 */

public class GroceryStore {
	ArrayList<Queue> line;
	Random gen = new Random();
	private int Items;
	private int processCart;
	private int shiftDuration;
	private double arrivalProbability;
	int customersServed;
	private int[] maxLength;

	/**
	 * Hold the numbers of checkout line, creates a queue for each line.
	 * @param lines
	 */
	public GroceryStore(int lines) {
		customersServed = 0; 
		line = new ArrayList<>(lines);
		ArrayDeque<Customer> person;  
		for (int i = 0; i < lines; i++) {
			person = new ArrayDeque<>();
			line.add(person);  //Adds people to the line 
		}
		maxLength = new int[lines];
	}
	/**
	 * Obtains the queues and uses a for loop to decide which queue is the shortest
	 * @return shortestQueue - the shortest queue that was obtained in the for loop
	 */

	public Queue getShortestQueue() {	  
		Queue shortestQueue;
		int start = 0; 	  
		for (int i = 1; i < line.size(); i++) 
			if (line.get(start).size() > line.get(i).size()) start = i;
		shortestQueue = line.get(start); 
		return shortestQueue; 
	}

	/**
	 *  Creates how the simulation is to run and what things will be needed which is included in the parameters
	 * @param shiftDuration - used to store the duration of the shift.
	 * @param arrivalProbability  - Used to calculate the probability of a customer arriving.
	 * @param processCart - integer used to process the Customer's cart.
	 * @param Items - used to hold the number of items a customer has.
	 */

	public void run(int shiftDuration, double arrivalProbability, int processCart, int Items) {
		this.shiftDuration = shiftDuration;
		this.Items = Items;
		this.processCart = processCart;
		this.arrivalProbability = arrivalProbability;
		Customer one;
		Queue shortestQueue;

		if (!line.isEmpty()) {
			for (int time = 0; time < shiftDuration; time++) {
				if (gen.nextDouble() <= arrivalProbability) {
					one = new Customer(gen.nextInt(Items) + 1, processCart);
					shortestQueue = getShortestQueue();
					shortestQueue.add(one);
//					maxLength[line.indexOf(shortestQueue)]++;
					if(shortestQueue.size() >maxLength[line.indexOf(shortestQueue)]) {
						maxLength[line.indexOf(shortestQueue)] = shortestQueue.size();
					}
				}

				for (int i = 0; i < line.size(); i++) {
					if(!line.get(i).isEmpty()) {
						Customer shopper = (Customer) line.get(i).element();
						shopper.decreaseTime();
						if(shopper.gettimeRemaining() == 0) {
							line.get(i).remove();
							customersServed++;
						}
					}
				}
			}
			
		//	line.clear();
			
		}
	}

	/**
	 * Prints out the data to be shown on the console.
	 */
	public void printData() {
		System.out.println("Number of timesteps: " + shiftDuration);
		System.out.println("Number of lines: " + line.size());
		System.out.println("Probability of a customer arriving: " + arrivalProbability);
		System.out.println("Time per item: " + processCart);
		System.out.println("Maximum number of items: " + Items);

		for(int i = 0; i < line.size();i++) {
			System.out.println("Maximum length of line " + i + " is: " + maxLength[i]);
			System.out.println("Customers left in line " + i + " is: " + line.get(i).size());

		}
		//	   for(int i = 0; i < line.size(); i++) {
		//	  
		//	        }
		System.out.println("Total number of customers served is: " + customersServed);

	}
}


