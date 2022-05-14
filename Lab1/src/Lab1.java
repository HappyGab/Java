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

	//main class
	//creates new Lab1 object
	public static void main(String[] args) {

		Lab1 l1 = new Lab1();
		System.out.println("\nSize 6 Square:");
		l1.printSquare(6);
		System.out.println("\n5x3 Square:");
		l1.printSquare(5,3);
		System.out.println("\n3x5 Square:");
		l1.printSquare(3,5);
	}

	//method to print the square with 1 argument
	public void printSquare(int x) {

		//while loop variables
		//square coordinates comes form these
		int i2 = 0;
		int i3 = 0;

		//default text blocks to build the squares
		String res = "";
		String top = "+";
		String top1 = "-----+";
		String bar1 = "|     ";
		String bar = "|     ";
		String middle = "";
		String middle1 = "| ";

		//outer loop
		//determines how many rows there are
		while(i2 < x) {
			
			//inner loop
			//builds rows of squares
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

			//prints the row built ^
			//resets and prepares variables for the next loop
			System.out.println(res);
			
			i2++;
			i3 = 0;
			middle = "";
			top = "+";
			bar = "|     ";
			res = "";
		}

		//builds the bottom line
		String bot = "+";
		String bot1 = "-----+";

		for (int i = 0; i < x; i++) {

			bot = bot + bot1;
		}

		System.out.println(bot);

	}


	//method to print the square with 2 argument
	public void printSquare(int y, int x) {

		//while loop variables
		//square coordinates comes form these
		int i2 = 0;
		int i3 = 0;

		//default text blocks to build the squares
		String res = "";
		String top = "+";
		String top1 = "-----+";
		String bar1 = "|     ";
		String bar = "|     ";
		String middle = "";
		String middle1 = "| ";

		//outer loop
		//determines how many rows there are
		while(i2 < x) {

			//inner loop
			//builds rows of squares
			while(i3 < y){

				top = top + top1;					

				bar = bar + bar1;

				if(i3 == y-1) {
					middle = middle + middle1 + i2 + "," + i3 + " |";
				}
				else {
					middle = middle + middle1 + i2 + "," + i3 + " ";
				}

				res = top + "\n" + bar + "\n" + middle + "\n" + bar;

				i3++;
			}

			//prints the row built ^
			//resets and prepares variables for the next loop
			System.out.println(res);
			
			i2++;
			i3 = 0;
			middle = "";
			top = "+";
			bar = "|     ";
			res = "";
		}

		//builds the bottom line
		String bot = "+";
		String bot1 = "-----+";

		for (int i = 0; i < y; i++) {

			bot = bot + bot1;
		}

		System.out.println(bot);

	}
}
