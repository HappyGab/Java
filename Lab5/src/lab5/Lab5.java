package lab5;

import java.util.Scanner;

public class Lab5 {

	static RecipeManager rM = new RecipeManager();

	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {

		Lab5 Lab5 = new Lab5();
		System.out.println("Welcome to the world's best bread recipe manager.");

		boolean quit = false;
		int playerIn = 0;
		
		while (quit == false) {
			

			Lab5.printMenu();
			
			try {
				playerIn = keyboard.nextInt();
			}
			catch ( java.util.InputMismatchException e) {
				
				String s = keyboard.nextLine();
				System.out.println("\nPlease enter a valid input. \nValid inputs are numbers form 0 to 4");
			}
			
			if (playerIn == 0) {
				//nothing happens here, have a good day :D
			}
			else if (playerIn == 1) {
				rM.printRlist();
			}
			else if (playerIn == 2) {
				Lab5.createSlist();
			}
			else if (playerIn == 3) {
				rM.printSlist();
			}
			else if (playerIn == 4) {
				System.out.println("\nMade by Gabriel Koscielniak");
				quit = true;
			}
			
			
		}
	}


	public void printMenu() {

		System.out.println("\nSelect one of the following options");
		System.out.println("1. Show available recipes");
		System.out.println("2. Create shopping list");
		System.out.println("3. Print shopping list");
		System.out.println("4. Quit program");
		System.out.println("0. Reprint the menu");
		System.out.print("Please enter your choice: ");
	}
	
	public void createSlist() {
		
		int PlayerInBread = 0;
		int PlayerInNum = 0;
		
		boolean loop = false;
		
		do{
			try {
				loop = false;
				System.out.print("\nWhich bread would you like? ");
				PlayerInBread = keyboard.nextInt();	
			}
			catch ( java.util.InputMismatchException e) {
			
				System.out.println("\nPlease enter a valid input. \nValid inputs are numbers form 1 to 7");
				String s = keyboard.nextLine();
				loop = true;
			}
		}
		while (loop == true);
		
		boolean loop2 = false;
		
		do {
			try {
				loop2 = false;
				System.out.print("\nHow many would you like? ");
				PlayerInNum = keyboard.nextInt();	
			}
			catch ( java.util.InputMismatchException e) {
				
				System.out.println("\nPlease enter a valid input. \nValid inputs are numbers");
				String s = keyboard.nextLine();
				loop2 = true;
			}
		}
		while (loop2 == true);
		
		rM.addToShoppingList(PlayerInBread, PlayerInNum);
	
	}
}
