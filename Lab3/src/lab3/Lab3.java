/*
 * Gabriel Koscielniak
 * #041062261
 * 
 * CST8132
 * Professor Daniel Cormier
 * 
 * Lab 3
 * 
 * Playable chess game with no rules implemented
 * 
 */

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

					board[i][i2] = null;
				}
			}
		}

		// prints the chess board
		l3.printBoard(board);

		// keyboard input reader
		Scanner keyboard = new Scanner(System.in);

		// looping variable
		// true = keep playing, false = stop playing
		boolean keepPlay = true;

		
		while (keepPlay == true) {

			// prints the menu
			System.out
					.println("1. Move a piece. \n2. Check a piece for valid moves. \n3. Redraw the board. \nQ. Quit.");

			// default values for the row and column
			int row = 0;
			int col = 0;
			int newRow = 0;
			int newCol = 0;

			// player inputs what he wants to do
			String playerIn = keyboard.nextLine();

			// player inputs q or Q, looping variable becomes false
			if (playerIn.equals("Q") || playerIn.equals("q")) {

				keepPlay = false;

				// player inputs 1, moving a piece options come up
			} else if (playerIn.equals("1")) {

				// player inputs coords of the piece he wants to move
				System.out.println("\nWhat piece do you want to move?\n");
				System.out.println("Enter row number:");
				String rowStr = keyboard.nextLine();
				System.out.println("Enter column number:");
				String colStr = keyboard.nextLine();

				row = Integer.parseInt(rowStr) - 1;
				col = Integer.parseInt(colStr) - 1;

				// checks if the square exists and is empty
				if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {

					if (board[row][col] == null) {

						System.out.println("This space is empty\n");
					} else {

						/**************************************************************************************
						 * bug here 
						 * if this block of code does something, the while loop (line 100) will
						 * loop once more, but ignore all interactive stuff and print some things 
						 * I have no clue why 
						 * Everything works fine after that
						 * ************************************************************************************
						 */

						// asks the player where he wants to move his piece
						System.out.println("\nWhere do you want to move the " + board[row][col].getName() + "?\n");
						System.out.println("Enter row number:");
						newRow = keyboard.nextInt() - 1;
						System.out.println("Enter column number:");
						newCol = keyboard.nextInt() - 1;

						// checks if the coords are on the board, moves the piece if yes
						if (newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7) {
							board[newRow][newCol] = board[row][col];
							board[row][col] = null;
						} else {
							System.out.println("invalid input, this square is not on the board");
						}
						String temp = keyboard.nextLine();
						System.out.println("");

					}
				} else {
					System.out.println("invalid input, this square is not on the board\n");
				}

				// player inputs 2, asks what piece he wants to check the valid moves of
			} else if (playerIn.equals("2")) {
				System.out.println("\nCheck valid moves for what peice?\n");
				System.out.println("Enter row number:");
				String rowStr = keyboard.nextLine();
				System.out.println("Enter column number:");
				String colStr = keyboard.nextLine();

				row = Integer.parseInt(rowStr) - 1;
				col = Integer.parseInt(colStr) - 1;

				// checks if the coords are on the board, check the moves if yes
				if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
					if (board[row][col] == null) {

						System.out.println("This space is empty\n");
					} else {
						board[row][col].getValidMoves(row + 1, col + 1);
					}
				} else {
					System.out.println("invalid input, this square is not on the board\n");
				}

				// player inputs 3, prints the updated chess board
			} else if (playerIn.equals("3")) {
				l3.printBoard(board);

				// player inputs something invalid
			} else {
				System.out.println("Invalid input\n");
			}
		}
	}

	// prints the chess board
	public void printBoard(Piece board[][]) {

		// prints top coords
		System.out.println("     1     2     3     4     5     6     7     8");

		// while loop variables
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
		for (int i2 = 0; i2 < 8; i2++) {

			// inner loop
			// builds rows of squares and their piece, if there is one
			while (i3 < 8) {

				top = top + top1;

				bar = bar + bar1;

				if (i3 == 0) {
					if (board[i2][i3] != null) {
						middle = i2 + 1 + " " + middle1 + " " + board[i2][i3].getSymbol() + "  ";
					} else {
						middle = i2 + 1 + " " + middle1 + " " + "   ";
					}
				} else if (i3 == 8 - 1) {
					if (board[i2][i3] != null) {
						middle = middle + middle1 + " " + board[i2][i3].getSymbol() + "  |";
					} else {
						middle = middle + middle1 + "    |";
					}
				} else {
					if (board[i2][i3] != null) {
						middle = middle + middle1 + " " + board[i2][i3].getSymbol() + "  ";
					} else {
						middle = middle + middle1 + "    ";
					}
				}

				res = top + "\n" + bar + "\n" + middle + "\n" + bar;

				i3++;
			}

			// prints the row built ^
			// resets and prepares variables for the next loop
			System.out.println(res);

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