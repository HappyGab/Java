
/*
 * Gabriel Koscielniak
 * #041062261
 * 
 * CST8132
 * Professor Daniel Cormier
 * 
 * Lab1
 * 
 * Prints squares with elements of the random array
 * 
 */

package Lab2;

import java.util.Random;

public class Lab2 {
	public static void main(String[] args)
	{
		Lab2 thisLab = new Lab2();
		int counter=97; //ASCII lowercase a.
		Random myrand = new Random(); //For random number generation.
		int rows = myrand.nextInt(5)+1;
		char[][] myArray = new char[rows][]; //Creation of random-height 2D array.
		for (int i=0;i<rows;i++) //This loop creates rows of random length.
		{
			int cols=myrand.nextInt(6); //Value from 0 to 6.
			myArray[i] = new char[cols]; //NB: There may be 0-width rows!
			for (int j=0;j<cols;j++)
			{
				myArray[i][j] = (char)counter++; //Fill array with chars.
			}
		}
		thisLab.printSquare(myArray); //Call to your method.

	}

	public void printSquare(char[][] chararray) {


		//while loop variables
		//square coordinates comes form these

		/* for while loop solution 
		int i2 = 0;
		 */

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

		/* for while loop solution 
		while(i2 < x) {
		 */
		int num = 0;
		
		for(int i2 = 0; i2 < chararray.length; i2++) {
			
			if (chararray[i2].length > num) {
				num = chararray[i2].length;
			}
		}
		for(int i2 = 0; i2 < chararray.length; i2++) {
			//inner loop
			//builds rows of squares
			while(i3 < chararray[i2].length){

				top = top + top1;					

				bar = bar + bar1;

				if(i3 == chararray[i2].length-1) {
					middle = middle + middle1 + " " + chararray[i2][i3]+ "  |";
				}
				else {
					middle = middle + middle1 + " " +  chararray[i2][i3] + "  ";
				}

				res = top + "\n" + bar + "\n" + middle + "\n" + bar + "\n" + top;

				i3++;
			}

			//prints the row built ^
			//resets and prepares variables for the next loop
			if (chararray[i2].length != 0) {
				System.out.println(res);
			}

			/* for while loop solution 
			i2++;
			 */

			i3 = 0;
			middle = "";
			top = "+";
			bar = "|     ";
			res = "";
		}

		System.out.println("Made by : Gabriel Koscielniak");
	}
}
