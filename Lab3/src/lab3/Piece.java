package lab3;

public abstract class Piece {

	boolean isBlack = true;

	protected abstract void getValidMoves(int row, int col);

	protected abstract String getSymbol();

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

	}
}

/*
 * Empty space methods
 */
class Empty extends Piece {

	protected String getSymbol() {

		return (" ");
	}

	protected String getName() {

		return "Empty space";

	}

	protected void getValidMoves(int row, int col) {

	}
}