package lab3;

import java.util.Scanner;

public class Lab3 {

	public static void main(String[] args) {

		Lab3 l3 = new Lab3();

		// 8x8 array, is the empty chess board
		Piece[][] board = new Piece[8][8];

		// fills the default board with all the peices on their starting spots
		for (int i = 0; i < 8; i++) {

			for (int i2 = 0; i2 < 8; i2++) {

				if (i == 0 || i == 7) {

					if (i2 == 0 || i2 == 7) {

						Rook r = new Rook();
						board[i][i2] = r;

						if (i == 0) {
							board[i][i2].isBlack = false;
						}
					} else if (i2 == 1 || i2 == 6) {

						Knight n = new Knight();
						board[i][i2] = n;

						if (i == 0) {
							board[i][i2].isBlack = false;
						}
					} else if (i2 == 2 || i2 == 5) {

						Bishop b = new Bishop();
						board[i][i2] = b;

						if (i == 0) {
							board[i][i2].isBlack = false;
						}
					} else if (i2 == 3) {

						King k = new King();
						board[i][i2] = k;

						if (i == 0) {
							board[i][i2].isBlack = false;
						}
					} else if (i2 == 4) {

						Queen q = new Queen();
						board[i][i2] = q;

						if (i == 0) {
							board[i][i2].isBlack = false;
						}
					}
				} else if (i == 1 || i == 6) {

					Pawn p = new Pawn();
					board[i][i2] = p;

					if (i == 1) {
						board[i][i2].isBlack = false;
					}
				} else {

					Empty e = new Empty();
					board[i][i2] = e;
				}
			}
		}

		// prints the chess board
		l3.printBoard(board);

		Scanner keyboard = new Scanner(System.in);

		boolean keepPlay = true;

		System.out.println("1. Move a piece. \n2. Check a piece for valid moves. \n3. Redraw the board. \nQ. Quit.");

 		while (keepPlay == true) {

			int row = 0;
			int col = 0;
			int newRow = 0;
			int newCol = 0;

			String playerIn = keyboard.nextLine();

			if (playerIn.equals("Q") || playerIn.equals("q")) {
				keepPlay = false;
			} else if (playerIn.equals("1")) {

				System.out.println("\nWhat piece do you want to move?\n");
				System.out.println("Enter row number:");
				String rowStr = keyboard.nextLine();
				System.out.println("Enter row number:");
				String colStr = keyboard.nextLine();

				row = Integer.parseInt(rowStr) - 1;
				col = Integer.parseInt(colStr) - 1;

				if (board[row][col].getSymbol().equals(" ")) {

					System.out.println("This space is empty\n");
				} else {

					System.out.println("\nWhere do you want to move the " + board[row][col].getName() + "?\n");
					System.out.println("Enter row number:");
					newRow = keyboard.nextInt() - 1;
					System.out.println("Enter row number:");
					newCol = keyboard.nextInt() - 1;

					board[newRow][newCol] = board[row][col];
					Empty e = new Empty();
					board[row][col] = e;
					System.out.println("");
				}
			} else if (playerIn.equals("3")) {
				l3.printBoard(board);
			}
			playerIn = "";
			System.out.println("1. Move a piece. \n2. Check a piece for valid moves. \n3. Redraw the board. \nQ. Quit.");
		}
	}

	public void printBoard(Piece board[][]) {

		// prints top coords
		System.out.println("    1     2     3     4     5     6     7     8");

		// while loop variables
		// square coordinates comes form these

		/*
		 * for while loop solution int i2 = 0;
		 */
		int i3 = 0;

		// default text blocks to build the squares
		String res = "";
		String top = "  +";
		String top1 = "-----+";
		String bar1 = "|     ";
		String bar = "  |     ";
		String middle = "  ";
		String middle1 = "| ";

		// outer loop
		// determines how many rows there are

		/*
		 * for while loop solution while(i2 < x) {
		 */

		for (int i2 = 0; i2 < 8; i2++) {

			// inner loop
			// builds rows of squares
			while (i3 < 8) {

				top = top + top1;

				bar = bar + bar1;

				if (i3 == 0) {
					middle = i2 + 1 + " " + middle1 + " " + board[i2][i3].getSymbol() + "  ";
				} else if (i3 == 8 - 1) {
					middle = middle + middle1 + " " + board[i2][i3].getSymbol() + "  |";
				} else {
					middle = middle + middle1 + " " + board[i2][i3].getSymbol() + "  ";
				}

				res = top + "\n" + bar + "\n" + middle + "\n" + bar;

				i3++;
			}

			// prints the row built ^
			// resets and prepares variables for the next loop
			System.out.println(res);

			/*
			 * for while loop solution i2++;
			 */

			i3 = 0;
			middle = "  ";
			top = "  +";
			bar = "  |     ";
			res = "";
		}

		// builds the bottom line
		String bot = "  +";
		String bot1 = "-----+";

		for (int i = 0; i < 8; i++) {

			bot = bot + bot1;
		}

		System.out.println(bot);

	}

}