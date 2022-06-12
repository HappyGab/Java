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

public abstract class Piece {

	// true = piece is black, false = piece is white
	boolean isBlack = true;

	// method in the following abstract classes
	// uses various ways to find the possible moves for each piece
	// completely ignores the rest of the pieces on the board (for now at least)
	protected abstract void getValidMoves(int row, int col);

	// method in the following abstract classes
	// returns the symbol of each piece
	protected abstract String getSymbol();

	// method in the following abstract classes
	// returns the color and name of the piece
	protected abstract String getName();
}

/*
 * Pawn methods
 */
class Pawn extends Piece {

	protected String getSymbol() {

		if (isBlack == false) {
			return ("p");
		}

		return ("P");
	}

	protected String getName() {

		String color;
		String res;

		if (isBlack == true) {
			color = "black";
		} else {
			color = "white";
		}

		res = color + " pawn";

		return res;

	}

	protected void getValidMoves(int row, int col) {

		String res = "";

		if (isBlack != true) {

			if (row == 2) {

				res = (row + 1) + "," + col + "  " + (row + 2) + "," + col;
			}
		} else {
			res = (row + 1) + "," + col;
		}

		if (isBlack == true) {

			if (row == 7) {

				res = (row - 1) + "," + col + " and " + (row - 2) + "," + col;
			}
		} else {
			res = (row - 1) + "," + col;
		}

		res = this.getName() + ", valid moves : " + res + "\n";
		System.out.println(res);
	}
}

/*
 * Rook methods
 */
class Rook extends Piece {

	protected String getSymbol() {

		if (isBlack == false) {
			return ("r");
		}

		return ("R");
	}

	protected String getName() {

		String color;
		String res;

		if (isBlack == true) {
			color = "black";
		} else {
			color = "white";
		}

		res = color + " rook";

		return res;

	}

	protected void getValidMoves(int row, int col) {

		String res = "";

		for (int i = 1; i <= 8; i++) {

			if (i != col) {
				res = res + row + "," + i + "  ";
			}
		}

		res = res + "and\n";

		for (int i2 = 1; i2 <= 8; i2++) {

			if (i2 != row) {
				res = res + i2 + "," + col + "  ";
			}
		}

		res = this.getName() + ", valid moves : " + res + "\n";
		System.out.println(res);
	}
}

/*
 * Knight methods
 */
class Knight extends Piece {

	protected String getSymbol() {

		if (isBlack == false) {
			return ("n");
		}

		return ("N");
	}

	protected String getName() {

		String color;
		String res;

		if (isBlack == true) {
			color = "black";
		} else {
			color = "white";
		}

		res = color + " knight";

		return res;

	}

	protected void getValidMoves(int row, int col) {

		String res = "";

		int newR;
		int newC;

		newR = row + 2;
		newC = col + 1;

		if (newR <= 8 && newR >= 1 && newC <= 8 && newC >= 1) {
			res = res + newR + "," + newC + "  ";
		}

		newR = row + 2;
		newC = col - 1;

		if (newR <= 8 && newR >= 1 && newC <= 8 && newC >= 1) {
			res = res + newR + "," + newC + "  ";
		}

		newR = row - 2;
		newC = col + 1;

		if (newR <= 8 && newR >= 1 && newC <= 8 && newC >= 1) {
			res = res + newR + "," + newC + "  ";
		}

		newR = row - 2;
		newC = col - 1;

		if (newR <= 8 && newR >= 1 && newC <= 8 && newC >= 1) {
			res = res + newR + "," + newC + "  ";
		}

		newR = row + 1;
		newC = col + 2;

		if (newR <= 8 && newR >= 1 && newC <= 8 && newC >= 1) {
			res = res + newR + "," + newC + "  ";
		}

		newR = row + 1;
		newC = col - 2;

		if (newR <= 8 && newR >= 1 && newC <= 8 && newC >= 1) {
			res = res + newR + "," + newC + "  ";
		}

		newR = row - 1;
		newC = col + 2;

		if (newR <= 8 && newR >= 1 && newC <= 8 && newC >= 1) {
			res = res + newR + "," + newC + "  ";
		}

		newR = row - 1;
		newC = col - 2;

		if (newR <= 8 && newR >= 1 && newC <= 8 && newC >= 1) {
			res = res + newR + "," + newC + "  ";
		}

		res = this.getName() + ", valid moves : " + res + "\n";
		System.out.println(res);
	}
}

/*
 * Bishop methods
 */
class Bishop extends Piece {

	protected String getSymbol() {

		if (isBlack == false) {
			return ("b");
		}

		return ("B");
	}

	protected String getName() {

		String color;
		String res;

		if (isBlack == true) {
			color = "black";
		} else {
			color = "white";
		}

		res = color + " bishop";

		return res;

	}

	protected void getValidMoves(int row, int col) {

		String res = "";

		int newR = row;
		int newC = col;

		while (newR > 1 && newC > 1) {
			newR = newR - 1;
			newC = newC - 1;
			res = res + newR + "," + newC + "  ";
		}

		newR = row;
		newC = col;

		while (newR < 8 && newC > 1) {
			newR = newR + 1;
			newC = newC - 1;
			res = res + newR + "," + newC + "  ";
		}

		newR = row;
		newC = col;

		while (newR > 1 && newC < 8) {
			newR = newR - 1;
			newC = newC + 1;
			res = res + newR + "," + newC + "  ";
		}

		newR = row;
		newC = col;

		while (newR < 8 && newC < 8) {
			newR = newR + 1;
			newC = newC + 1;
			res = res + newR + "," + newC + "  ";
		}

		res = this.getName() + ", valid moves : " + res + "\n";
		System.out.println(res);
	}
}

/*
 * King methods
 */
class King extends Piece {

	protected String getSymbol() {

		if (isBlack == false) {
			return ("k");
		}

		return ("K");
	}

	protected String getName() {

		String color;
		String res;

		if (isBlack == true) {
			color = "black";
		} else {
			color = "white";
		}

		res = color + " king";

		return res;

	}

	protected void getValidMoves(int row, int col) {

		String res = "";

		int newR = row;
		int newC = col;

		if (newR - 1 >= 1 && newC - 1 >= 1) {
			res = res + (newR - 1) + "," + (newC - 1) + "  ";
		}
		if (newC - 1 >= 1) {
			res = res + (newR) + "," + (newC - 1) + "  ";
		}
		if (newR + 1 <= 8 && newC - 1 >= 1) {
			res = res + (newR + 1) + "," + (newC - 1) + "  ";
		}
		if (newR - 1 >= 1) {
			res = res + (newR - 1) + "," + (newC) + "  ";
		}
		if (newR + 1 <= 8) {
			res = res + (newR + 1) + "," + (newC) + "  ";
		}
		if (newR - 1 >= 1 && newC + 1 <= 8) {
			res = res + (newR - 1) + "," + (newC + 1) + "  ";
		}
		if (newC + 1 <= 8) {
			res = res + (newR) + "," + (newC + 1) + "  ";
		}
		if (newR + 1 <= 8 && newC + 1 <= 8) {
			res = res + (newR + 1) + "," + (newC + 1) + "  ";
		}

		res = this.getName() + ", valid moves : " + res + "\n";
		System.out.println(res);
	}
}

/*
 * Queen methods
 */
class Queen extends Piece {

	protected String getSymbol() {

		if (isBlack == false) {
			return ("q");
		}

		return ("Q");
	}

	protected String getName() {

		String color;
		String res;

		if (isBlack == true) {
			color = "black";
		} else {
			color = "white";
		}

		res = color + " queen";

		return res;

	}

	protected void getValidMoves(int row, int col) {

		String res = "";

		int newR = row;
		int newC = col;

		while (newR > 1 && newC > 1) {
			newR = newR - 1;
			newC = newC - 1;
			res = res + newR + "," + newC + "  ";
		}

		newR = row;
		newC = col;

		while (newR < 8 && newC > 1) {
			newR = newR + 1;
			newC = newC - 1;
			res = res + newR + "," + newC + "  ";
		}

		newR = row;
		newC = col;

		while (newR > 1 && newC < 8) {
			newR = newR - 1;
			newC = newC + 1;
			res = res + newR + "," + newC + "  ";
		}

		newR = row;
		newC = col;

		while (newR < 8 && newC < 8) {
			newR = newR + 1;
			newC = newC + 1;
			res = res + newR + "," + newC + "  ";
		}

		res = res + "and\n";

		for (int i = 1; i <= 8; i++) {

			if (i != col) {
				res = res + row + "," + i + "  ";
			}
		}

		res = res + "and\n";

		for (int i2 = 1; i2 <= 8; i2++) {

			if (i2 != row) {
				res = res + i2 + "," + col + "  ";
			}
		}
		res = this.getName() + ", valid moves : " + res + "\n";
		System.out.println(res);
	}
}
