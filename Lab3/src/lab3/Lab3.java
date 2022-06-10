package lab3;

public class Lab3 {

	public static void main(String[] args) {
		
		Lab3 l3 = new Lab3();
		l3.printBoard();
	}
	
	public void printBoard() {

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
		
		for(int i2 = 0; i2 < 8; i2++) {
			
			//inner loop
			//builds rows of squares
			while(i3 < 8){

				top = top + top1;					

				bar = bar + bar1;

				if(i3 == 8-1) {
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
			
			/* for while loop solution 
			i2++;
			*/
			
			i3 = 0;
			middle = "";
			top = "+";
			bar = "|     ";
			res = "";
		}

		//builds the bottom line
		String bot = "+";
		String bot1 = "-----+";

		for (int i = 0; i < 8; i++) {

			bot = bot + bot1;
		}

		System.out.println(bot);

	}
}