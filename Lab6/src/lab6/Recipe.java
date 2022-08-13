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

/**
 * 
 * @author gabko
 * @version 1.0
 * @since 1.8
 */
public class Recipe {

	public float yeast = 0;
	public float flour = 0;
	public float sugar = 0;
	public float eggs = 0;
	public float butter = 0;
	
	public int breadNum = 1;
	
	public String breadName = "";
	
	/**
	 * sets the name of the bread
	 * 
	 * @param name : (string) the name of the bread
	 */
	public void setName(String name) {	
		this.breadName = name;
	
	}
	
	/**
	 * sets the number of breads
	 * 
	 * @param breadNum : (int) the number of breads
	 */
	public void setBreadNum(int breadNum) {	
		this.breadNum = breadNum;
		
	}
	
	/**
	 * sets the amount of yeast
	 * 
	 * @param num : (int) the amount of yeast
	 */
	public void setYeast(float num) {
		this.yeast = num * breadNum;
		
	}
	
	/**
	 * sets the amount of flour
	 * 
	 * @param num : (int) the amount of flour
	 */
	public void setFlour(float num) {
		this.flour = num * breadNum;
		
	}
	
	/**
	 * sets the amount of sugar
	 * 
	 * @param num : (int) the amount of sugar
	 */
	public void setSugar(float num) {
		this.sugar = num * breadNum;
		
	}
	
	/**
	 * sets the amount of eggs
	 * 
	 * @param num : (int) the amount of eggs
	 */
	public void setEggs(float num) {
		this.eggs = num * breadNum;
		
	}
	
	/**
	 * sets the amount of butter
	 * 
	 * @param num : (int) the amount of butter
	 */
	public void setButter(float num) {
		this.butter = num * breadNum;
		
	}
	
	/**
	 * gets the bread's name
	 * 
	 * @return breadName: (string) the bread's name
	 */
	public String getName() {
		
		return breadName;
	}
	
	/**
	 * gets the number of breads
	 * 
	 * @return breadNum: (int) the number of breads
	 */
	public int getBreadNum() {
		
		return breadNum;
	}
	
	/**
	 * gets the amount of yeast
	 * 
	 * @return yeast: (float) the amount of yeast
	 */
	public float getYeast() {
		
		return yeast;
	}

	/**
	 * gets the amount of flour
	 * 
	 * @return yeast: (float) the amount of flour
	 */
	public float getFlour() {
		
		return flour;
	}
	
	/**
	 * gets the amount of sugar
	 * 
	 * @return yeast: (float) the amount of sugar
	 */
	public float getSugar() {
			
		return sugar;
	}
	
	/**
	 * gets the amount of eggs
	 * 
	 * @return yeast: (float) the amount of eggs
	 */
	public float getEggs() {
		
		return eggs;
	}
	
	/**
	 * gets the amount of butter
	 * 
	 * @return yeast: (float) the amount of butter
	 */
	public float getButter() {
		
		return butter;
	}	
}
