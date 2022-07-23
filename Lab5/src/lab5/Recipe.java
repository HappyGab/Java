package lab5;

public class Recipe {

	public float yeast = 0;
	public float flour = 0;
	public float sugar = 0;
	public float eggs = 0;
	public float butter = 0;
	
	public int breadNum = 1;
	
	public String breadName = "";
	
	public void setName(String name) {	
		this.breadName = name;
	
	}
	
	public void setBreadNum(int breadNum) {	
		this.breadNum = breadNum;
		
	}
	
	public void setYeast(float num) {
		this.yeast = num * breadNum;
		
	}
	
	public void setFlour(float num) {
		this.flour = num * breadNum;
		
	}
	
	public void setSugar(float num) {
		this.sugar = num * breadNum;
		
	}
	
	public void setEggs(float num) {
		this.eggs = num * breadNum;
		
	}
	
	public void setButter(float num) {
		this.butter = num * breadNum;
		
	}
	
	public String getName() {
		
		return breadName;
	}
	
	public float getYeast() {
		
		return yeast;
	}

	public float getFlour() {
		
		return flour;
	}
	
	public float getSugar() {
			
		return sugar;
	}
	
	public float getEggs() {
		
		return eggs;
	}
	
	public float getButter() {
		
		return butter;
	}	
}
