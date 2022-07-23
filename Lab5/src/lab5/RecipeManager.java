package lab5;

import java.util.ArrayList;

class RecipeManager extends RecipeTemplate {

	private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

	protected void printRlist() {

		System.out.println("\nAvailable recipes:");
		System.out.println();
		for (int i = 0; i < names.length; i++) {

			System.out.println((i + 1) + "." + names[i]);
		}
	}

	protected void addToShoppingList(int bread, int num) {

		Recipe tempRecipe = new Recipe();

		boolean isInSlist = false;
		int whereInSlist = 0;

		for (int i = 0; i < recipeList.size(); i++) {

			if (recipeList.get(i).getName().equals(names[bread - 1])) {
				isInSlist = true;
				whereInSlist = i;
			}
		}

		if (isInSlist == false) {
			tempRecipe.setName(names[bread - 1]);
			tempRecipe.setBreadNum(num);

			tempRecipe.setYeast(yeast[bread - 1]);
			tempRecipe.setFlour(flour[bread - 1]);
			tempRecipe.setSugar(sugar[bread - 1]);
			tempRecipe.setEggs(eggs[bread - 1]);
			tempRecipe.setButter(butter[bread - 1]);

			recipeList.add(tempRecipe);
		} else {

			recipeList.get(whereInSlist).setBreadNum(recipeList.get(whereInSlist).getBreadNum() + num);
			recipeList.get(whereInSlist).setYeast(yeast[bread - 1]);
			recipeList.get(whereInSlist).setFlour(flour[bread - 1]);
			recipeList.get(whereInSlist).setSugar(sugar[bread - 1]);
			recipeList.get(whereInSlist).setEggs(eggs[bread - 1]);
			recipeList.get(whereInSlist).setButter(butter[bread - 1]);
		}

	}

	protected int recipeNum() {

		return recipeList.size();
	}

	protected void printSlist() {

		int listSize = recipeNum();

		System.out.println();

		for (int i = 0; i < listSize; i++) {

			System.out.print((i + 1) + ".");
			System.out.println(recipeList.get(i).getName());
		}

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
