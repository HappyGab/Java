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

package lab5;

import java.util.ArrayList;
 /**
  * This class manages the list of recipes to be added to the shopping list
  * 
  * @author gabko
  * @version 1.0
  * @since 1.8
  */
class RecipeManager extends RecipeTemplate {

	//contains the shopping list
	private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

	/**
	 * This method prints the availabe recipes
	 */
	protected void printRlist() {

		//prints all available recipes
		System.out.println("\nAvailable recipes:");
		System.out.println();
		for (int i = 0; i < NUMRECIPES; i++) {

			System.out.println((i + 1) + "." + names[i]);
		}
	}

	/**
	 * 
	 * @param bread : (int) specifies the type of bread wanted
	 * @param num : (int) the number of breads wanted
	 */
	protected void addToShoppingList(int bread, int num) {

		//temporary recipe to add to the shopping list
		Recipe tempRecipe = new Recipe();

		//true = that type of bread is in the list already, false = it is not
		boolean isInSlist = false;
		//used if ^ is true, specifies which where in the shopping list that bread already is
		int whereInSlist = 0;

		//checks if the bread already is in the shopping list
		for (int i = 0; i < recipeList.size(); i++) {

			if (recipeList.get(i).getName().equals(names[bread - 1])) {
				isInSlist = true;
				whereInSlist = i;
			}
		}

		//if the bread is not in the shopping list
		if (isInSlist == false) {
			
			//creates the right recipe and adds it to the shopping list
			tempRecipe.setName(names[bread - 1]);
			tempRecipe.setBreadNum(num);

			tempRecipe.setYeast(yeast[bread - 1]);
			tempRecipe.setFlour(flour[bread - 1]);
			tempRecipe.setSugar(sugar[bread - 1]);
			tempRecipe.setEggs(eggs[bread - 1]);
			tempRecipe.setButter(butter[bread - 1]);

			recipeList.add(tempRecipe);
			
		//if the bread already is in the shopping list
		} else {

			//edits the recipe for that bread in the shopping list
			recipeList.get(whereInSlist).setBreadNum(recipeList.get(whereInSlist).getBreadNum() + num);
			recipeList.get(whereInSlist).setYeast(yeast[bread - 1]);
			recipeList.get(whereInSlist).setFlour(flour[bread - 1]);
			recipeList.get(whereInSlist).setSugar(sugar[bread - 1]);
			recipeList.get(whereInSlist).setEggs(eggs[bread - 1]);
			recipeList.get(whereInSlist).setButter(butter[bread - 1]);
		}

	}

	/**
	 * This method returns the number of recipes in the list
	 * 
	 * @return : (int) the number of recipes in the list
	 */
	protected int recipeNum() {

		//the size of the shopping list
		return recipeList.size();
	}

	/**
	 * This method prints the shopping list of recipes
	 */
	protected void printSlist() {

		//size of the shopping list
		int listSize = recipeNum();

		System.out.println();

		//prints the type of bread and their amounts in the list
		for (int i = 0; i < listSize; i++) {

			System.out.print((i + 1) + ".");
			System.out.println(recipeList.get(i).getName());
		}

		//prints the total amount of ingredients needed for all the bread in the shopping list
		//skips the ingredients ou need none of
		System.out.println("\nIngredients needed:");

		float yeast = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getYeast() > 0) {
				yeast = yeast + recipeList.get(i).getYeast();
			}
		}

		if (yeast > 0) {
			System.out.println(yeast + " grams of yeast");
		}

		float flour = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getFlour() > 0) {
				flour = flour + recipeList.get(i).getFlour();
			}
		}

		if (flour > 0) {
			System.out.println(flour + " grams of flour");
		}

		float sugar = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getSugar() > 0) {
				sugar = sugar + recipeList.get(i).getSugar();
			}
		}

		if (sugar > 0) {
			System.out.println(sugar + " grams of sugar");
		}

		float eggs = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getEggs() > 0) {
				eggs = eggs + recipeList.get(i).getEggs();
			}
		}

		if (eggs > 0) {
			System.out.println(eggs + " eggs");
		}

		float butter = 0;

		for (int i = 0; i < listSize; i++) {

			if (recipeList.get(i).getButter() > 0) {
				butter = butter + recipeList.get(i).getButter();
			}
		}

		if (butter > 0) {
			System.out.println(butter + " grams of butter");
		}
	}
}
