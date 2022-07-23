package lab5;

import java.util.ArrayList;

class RecipeManager extends RecipeTemplate {

	private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	
	protected void printRlist() {
		
		System.out.println();
		for (int i = 0; i <names.length; i++) {
			
			System.out.println((i+1) + "." + names[i]);
		}
	}
	
	protected void addToShoppingList(int bread, int num) {
		
		Recipe tempRecipe = new Recipe();
		
		tempRecipe.setName(names[bread -1]);
		tempRecipe.setBreadNum(num);
		
		tempRecipe.setYeast(yeast[bread-1]);
		tempRecipe.setFlour(flour[bread-1]);
		tempRecipe.setSugar(sugar[bread-1]);
		tempRecipe.setEggs(eggs[bread-1]);
		tempRecipe.setButter(butter[bread-1]);
		
		recipeList.add(tempRecipe);
		
	}
}
