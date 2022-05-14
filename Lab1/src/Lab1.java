/*
 * Gabriel Koscielniak
 * #041062261
 * 
 * CST8132
 * Professor Daniel Cormier
 * 
 * Lab1
 * 
 * Prints squares with coordinates
 */



public class Lab1 {

public static void main(String[] args) {
		
		Lab1 l1 = new Lab1();
		System.out.println("\nSize 6 Square:");
		l1.printSquare(6);
		System.out.println("\n5x3 Square:");
		//l1.printSquare(5,3);
		System.out.println("\n3x5 Square:");
		//l1.printSquare(3,5);
		
	}

	public void printSquare(int x) {
		
	
		int i2 = 0;
		int i3 = 0;
		
		String res = "";
		String top = "+";
		String top1 = "-----+";
		String bar1 = "|     ";
		String bar = "|     ";
		String middle = "";
		String middle1 = "| ";
		
	
			
		while(i2 < x) {
			
			while(i3 < x){
					
				top = top + top1;					
					
				bar = bar + bar1;
															
				
				if(i3 == x-1) {
					middle = middle + middle1 + i2 + "," + i3 + " |";
				}
				else {
					middle = middle + middle1 + i2 + "," + i3 + " ";
				}
					
				res = top + "\n" + bar + "\n" + middle + "\n" + bar;
					
				
				i3++;
	
					
			}
			
			System.out.println(res);
			i2++;
			i3 = 0;
				
			middle = "";
			top = "+";
			bar = "|     ";
			res = "";
		}
			
		String bot = "+";
		String bot1 = "-----+";
		
		for (int i = 0; i < x; i++) {
			
			bot = bot + bot1;
		}
		
		System.out.println(bot);

	}
}
