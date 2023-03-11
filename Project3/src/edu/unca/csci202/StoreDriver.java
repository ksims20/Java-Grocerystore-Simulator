package edu.unca.csci202;
/**
 * 
 * @author Kamren Sims
 *  Main method class, using to create instances of grocery stores 
 * Fills the .run parameter by including the shiftduration,  arrvialprobability, processcart, and items.
 * Currently runs 7 instances but could be altered for more or less.
 */

public class StoreDriver {

	public static void main(String[] args) {

//				GroceryStore a = new GroceryStore(2);
//					a.run(300,0.1,1,10);
//					a.printData();
//					System.out.println();
					
					
					GroceryStore b = new GroceryStore(2);
					b.run(100, 0.1, 10, 20);
					b.printData();
					System.out.println();

		GroceryStore aldi = new GroceryStore(0);
		aldi.run(200, 0.34, 2, 10);
		aldi.printData();

		System.out.println();  //Used to space out the Grocery stores, keeping them in so the reader
		//can easily read the output
		GroceryStore ingles = new GroceryStore(13);
		ingles.run(130, 0.65, 3, 30);
		ingles.printData();
		System.out.println();

		GroceryStore foodlion = new GroceryStore(1);
		foodlion.run(1000, 0.54, 1, 20);
		foodlion.printData();
		System.out.println();

		GroceryStore harristeeter = new GroceryStore(4);
		harristeeter.run(100, 0.80, 1, 5);
		harristeeter.printData();
		System.out.println();

		GroceryStore wholefoods = new GroceryStore(2);
		wholefoods.run(60, 0.01, 1, 100);
		wholefoods.printData();
		System.out.println();

		GroceryStore lowes = new GroceryStore(3);
		lowes.run(120, 0.99, 5, 200);
		lowes.printData();
		System.out.println();

		GroceryStore walmart = new GroceryStore(1);
		walmart.run(500, 0.99, 1, 2);
		walmart.printData();
		System.out.println();
		
		GroceryStore g1 = new GroceryStore(5);
		
		g1.run(1000, 0.1,5, 50);
		g1.printData();
	}

}


