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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

 /**
  * This class manages the list of recipes to be added to the shopping list
  * 
  * @author gabko
  * @version 1.0
  * @since 1.8
  */
public class RecipeManager {
	
	//contains the shopping list
	private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		
	private static Scanner rL;
	private static FileWriter sLw;
	private static FileWriter rLw;
	
	//method to reset the scanners and file writers
	public static void readFile() {
		
		try {
			rL = new Scanner(new File("recipelist.txt"));
			sLw = new FileWriter("shoplist.txt", true);
			rLw = new FileWriter("recipelist.txt", true);
			
		}
		catch (FileNotFoundException e) {
			
			System.out.println("Error: File not found");
		}
		catch (IOException e2) {
			
			System.out.println("Error: Something went wrong");
		}
	}
	/**
	 * This method prints the availabe recipes
	 */
	public void printRlist() {
		//prints all available recipes
		System.out.println("\nAvailable Recipes\n");
		
		int i = 1;
		
		while (rL.hasNext() == true) {
			
			if (rL.next().equals("Recipe")) {
				
				System.out.println(i + ": " + rL.nextLine());
				i++;
			}
		}
		
		
	}
	
	/**
	 * 
	 * @param name : String for the name
	 * @param yeast : float for the yeast
	 * @param flour : float for the flour
	 * @param sugar : float for the sugar
	 * @param eggs : float for the eggs
	 * @param butter : float for the butter
	 */
	public void addRecipe(String name, float yeast, float flour, float sugar, float eggs, float butter) {
		
		readFile();
		
		String newRecipe = "\n";
		
		newRecipe = newRecipe + "Recipe " + name;
		newRecipe = newRecipe + "\nyeast " + yeast; 
		newRecipe = newRecipe + "\nflour " + flour; 
		newRecipe = newRecipe + "\nsugar " + sugar; 
		newRecipe = newRecipe + "\neggs " + eggs; 
		newRecipe = newRecipe + "\nbutter " + butter; 
		
		//adds the new recipe to recipelist.txt
		try {
			rLw.write(newRecipe);
			rLw.close();
		} 
		catch (IOException e) {
			System.out.println("Error: something went wrong");
		}
		
	}

	/**
	 * 
	 * @param bread : (int) specifies the type of bread wanted
	 * @param num : (int) the number of breads wanted
	 */
	public void addToShoppingList(int bread, int num) {

		readFile();
		
		String rName = null;
		
		for (int i = 1; i <= bread;) {
			
			while (rL.hasNext() == true) {
				
				if (rL.next().equals("Recipe")) {
					
					rName = rL.nextLine();
					i++;
					break;
				}
			}
		}
				
		//temporary recipe to add to the shopping list
		Recipe tempRecipe = new Recipe();

		//true = that type of bread is in the list already, false = it is not
		boolean isInSlist = false;
		//used if ^ is true, specifies which where in the shopping list that bread already is
		int whereInSlist = 0;

		//checks if the bread already is in the shopping list
		for (int i = 0; i < recipeList.size(); i++) {

			if (recipeList.get(i).getName().equals(rName)) {
				isInSlist = true;
				whereInSlist = i;
			}
		}

		float yeast = 0;
		float flour = 0;	
		float sugar = 0;
		float eggs = 0;
		float butter = 0;
		
		//if the bread is not in the shopping list
		if (isInSlist == false) {
			
			//creates the right recipe and adds it to the shopping list
			tempRecipe.setName(rName);
			tempRecipe.setBreadNum(num);

			int i = 1;
			
			while(i <= 5) {
				
				i++;
				 
				String ing = rL.next();
				
				if (ing.equals("yeast")) {
					yeast = rL.nextFloat();
				}
				else if (ing.equals("flour")) {
					flour = rL.nextFloat();
				}
				else if (ing.equals("sugar")) {
					sugar = rL.nextFloat();
				}
				else if (ing.equals("eggs")) {
					eggs = rL.nextFloat();
				}
				else if (ing.equals("butter")) {
					butter = rL.nextFloat();
				}

			}
			tempRecipe.setYeast(yeast);
			tempRecipe.setFlour(flour);
			tempRecipe.setSugar(sugar);
			tempRecipe.setEggs(eggs);
			tempRecipe.setButter(butter);
			recipeList.add(tempRecipe);
			
		//if the bread already is in the shopping list
		} else {

			int i = 1;
			
			while(i <= 5) {
				
				i++;
				
				String ing = rL.next();
				
				if (ing.equals("yeast")) {
					yeast = rL.nextFloat();
				}
				else if (ing.equals("flour")) {
					flour = rL.nextFloat();
				}
				else if (ing.equals("sugar")) {
					sugar = rL.nextFloat();
				}
				else if (ing.equals("eggs")) {
					eggs = rL.nextFloat();
				}
				else if (ing.equals("butter")) {
					butter = rL.nextFloat();
				}
			}
			
			//edits the recipe for that bread in the shopping list
			recipeList.get(whereInSlist).setBreadNum(recipeList.get(whereInSlist).getBreadNum() + num);
			recipeList.get(whereInSlist).setYeast(yeast);
			recipeList.get(whereInSlist).setFlour(flour);
			recipeList.get(whereInSlist).setSugar(sugar);
			recipeList.get(whereInSlist).setEggs(eggs);
			recipeList.get(whereInSlist).setButter(butter);
		}
		
	}

	/**
	 * This method returns the number of recipes in the list
	 * 
	 * @return : (int) the number of recipes in the list
	 */
	public int recipeNum() {

		//the size of the shopping list
		return recipeList.size();
	}
	
	

	/**
	 * This method prints the shopping list of recipes
	 */
	public String printSlist() {

		String sList = "";
		
		//size of the shopping list
		int listSize = recipeNum();

		System.out.println();
		sList = sList + "\n";

		//prints the type of bread and their amounts in the list
		for (int i = 0; i < listSize; i++) {

			sList = sList +(recipeList.get(i).getBreadNum() + ".");
			sList = sList +(recipeList.get(i).getName() + "\n");
		}

		//prints the total amount of ingredients needed for all the bread in the shopping list
		//skips the ingredients ou need none of
		sList = sList +("\nIngredients needed:");

		float yeast = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getYeast() > 0) {
				yeast = yeast + recipeList.get(i).getYeast();
			}
		}

		if (yeast > 0) {
			sList = sList + "\n" + (yeast + " grams of yeast");
		}

		float flour = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getFlour() > 0) {
				flour = flour + recipeList.get(i).getFlour();
			}
		}

		if (flour > 0) {
			sList = sList + "\n" + (flour + " grams of flour");
		}

		float sugar = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getSugar() > 0) {
				sugar = sugar + recipeList.get(i).getSugar();
			}
		}

		if (sugar > 0) {
			sList = sList + "\n" + (sugar + " grams of sugar");
		}

		float eggs = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getEggs() > 0) {
				eggs = eggs + recipeList.get(i).getEggs();
			}
		}

		if (eggs > 0) {
			sList = sList + "\n" + (eggs + " eggs");
		}

		float butter = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getButter() > 0) {
				butter = butter + recipeList.get(i).getButter();
			}
		}

		if (butter > 0) {
			sList = sList + "\n" + (butter + " grams of butter");
		}
		
		return sList;
	}
	
	public void saveList(String yn) {
		
		if (yn.equals("y")) {
			
			try {
				sLw.write(printSlist());
				sLw.close();
			} 
			catch (IOException e) {
				System.out.println("Error: something went wrong");
			}
		}
		else {
			System.out.println("Shopping List changes discarded");
		}
	}
}
