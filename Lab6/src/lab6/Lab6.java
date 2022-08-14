/*
 * Gabriel Koscielniak
 * #041062261
 * 
 * CST8132
 * Professor Daniel Cormier
 * 
 * Lab 5
 * 
 * Bread recipe manager
 * 
 */


package lab6;

import java.util.Scanner;

/**
 * Driver Class
 * 
 * @author gabko
 * @version 1.0
 * @since 1.8
 */
public class Lab6 {

	//RecipeManager object
	static RecipeManager rM = new RecipeManager();

	//keyboard scanner
	static Scanner keyboard = new Scanner(System.in);

	/**
	 * Main method, makes the program run
	 * 
	 * @param args : nothing
	 */
	public static void main(String[] args) {	

		RecipeManager.readFile();

		//starts the program
		Lab6 Lab6 = new Lab6();
		System.out.println("Welcome to the world's best bread recipe manager.");

		//boolean, false : does not quit the program, true : quits the program
		boolean quit = false;

		//int for the user's input
		int playerIn = 0;

		//keeps looping until quit = true
		while (quit == false) {

			//prints the menu
			Lab6.printMenu();

			//checks for exceptions
			try {
				//user's input
				playerIn = keyboard.nextInt();
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner
				String s = keyboard.nextLine();
				System.out.println("\nPlease enter a valid input. \nValid inputs are numbers form 0 to 4");
			}

			//options depending on the user's input
			if (playerIn == 0) {
				//nothing happens here, have a good day :D
			}
			else if (playerIn == 1) {
				//calls the method that prints the list of available recipes
				rM.printRlist();
			}
			else if (playerIn == 2) {
				//calls the method that add a recipe
				Lab6.addRecipe();
			}
			else if (playerIn == 3) {
				//calls the method to create the list
				Lab6.createSlist();
			}
			else if (playerIn == 4) {
				//calls the method that prints the shopping list
				String sList = rM.printSlist();
				System.out.println(sList);
				Lab6.saveList();

			}
			else if (playerIn == 5) {
				//quits the program
				System.out.println("\nMade by Gabriel Koscielniak");
				quit = true;
			}


		}
	}

	/**
	 * This method prints the option menu
	 */
	public void printMenu() {

		//prints the menu
		System.out.println("\nSelect one of the following options");
		System.out.println("1. Show available recipes");
		System.out.println("2. Add a new recipe");
		System.out.println("3. Create shopping list");
		System.out.println("4. Print shopping list");
		System.out.println("5. Quit program");
		System.out.println("0. Reprint the menu");
		System.out.print("Please enter your choice: ");
	}

	/**
	 * This method asks the user for the type and amount of bread to add to the shopping list
	 * calls the method that create the shopping list with the parameters given by the user
	 */
	public void createSlist() {

		//ints for the user's input
		int PlayerInBread = 0;
		int PlayerInNum = 0;

		//to end the loop
		boolean loop = false;

		do{
			//checks for exceptions
			try {
				//gets user's input for the bread wanted
				loop = false;
				System.out.print("\nWhich bread would you like? ");
				PlayerInBread = keyboard.nextInt();	
			}
			catch ( java.util.InputMismatchException e) {

				//tells the user he messed up and flushes the scanner
				System.out.println("\nPlease enter a valid input. \nValid inputs are numbers form 1 to 7");
				String s = keyboard.nextLine();
				loop = true;
			}
		}
		while (loop == true);

		//to end the second loop
		boolean loop2 = false;

		do {
			try {
				//gets the user input for the amount of bread
				loop2 = false;
				System.out.print("\nHow many would you like? ");
				PlayerInNum = keyboard.nextInt();	
			}
			catch ( java.util.InputMismatchException e) {

				//tells the user he messed up and flushes the scanner
				System.out.println("\nPlease enter a valid input. \nValid inputs are numbers");
				String s = keyboard.nextLine();
				loop2 = true;
			}
		}
		while (loop2 == true);

		//calls the method that add the right bread and amount to the shopping list
		rM.addToShoppingList(PlayerInBread, PlayerInNum);

	}

	public void saveList() {

		String playerInchoice = "n";

		boolean loop = false;

		do{
			//checks for exceptions
			try {
				//gets user's input for the bread wanted
				loop = false;
				System.out.print("\nSave changes to shopping list? \ny to save, anything else to discard changes ");
				playerInchoice = keyboard.next();	
			}
			catch ( java.util.InputMismatchException e) {

				//tells the user he messed up and flushes the scanner
				System.out.println("\nPlease enter a valid input. \nValid inputs are letters");
				String s = keyboard.nextLine();
				loop = true;
			}
		}
		while (loop == true);

		rM.saveList(playerInchoice);
	}

	/**
	 * method to add a new recipe
	 */
	private void addRecipe() {

		//ints for the user's input of ingredients and name of the bread
		String name = "";
		float yeast = 0;
		float flour = 0;
		float sugar = 0;
		float eggs = 0;
		float butter = 0;

		//to end the loop 
		boolean loop = false;

		do{
			//checks for exceptions
			try {
				//gets user's input for the bread wanted
				loop = false;
				System.out.print("\nWhat is the name of the bread? \n");
				name = keyboard.next();
				String s1 = keyboard.nextLine();
				System.out.print("\nHow much yeast does it need? ");
				yeast = keyboard.nextFloat();
				s1 = keyboard.nextLine();
				System.out.print("\nHow much flour does it need? ");
				flour = keyboard.nextFloat();
				s1 = keyboard.nextLine();
				System.out.print("\nHow much sugar does it need? ");
				sugar = keyboard.nextFloat();
				s1 = keyboard.nextLine();
				System.out.print("\nHow much eggs does it need? ");
				eggs = keyboard.nextFloat();
				s1 = keyboard.nextLine();
				System.out.print("\nHow much butter does it need? ");
				butter = keyboard.nextFloat();
				s1 = keyboard.nextLine();
			}
			catch ( java.util.InputMismatchException e) {

				//tells the user he messed up and flushes the scanner
				System.out.println("\nPlease enter a valid input.");
				String s = keyboard.nextLine();
				loop = true;
			}
		}
		while (loop == true);
		
		rM.addRecipe(name, yeast, flour, sugar, eggs, butter);
	}
}
