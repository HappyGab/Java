package lab3;

public abstract class Peice {

	boolean isBlack;
	
	protected abstract void getValidMoves (int row, int col);
	protected abstract String getSymbol();
	protected abstract String getName();
}

/*
 * Pawn
 */
class Pawn extends Peice{
	
	protected String getSymbol() {
		
		return("p");
	}
	
	protected String getName() {
		
		String color;
		String res;
		
		if (isBlack == true) {
			color = "black";
		}
		else {
			color = "white";
		}
		
		res = color + " peice";
		
		return res;
		
	}
	
	protected void getValidMoves(int row, int col) {
		
		
	}
}

/*
 * Rook
 */
class Rook extends Peice{
	
	protected String getSymbol() {
		
		return("r");
	}
	
	protected String getName() {
		
		String color;
		String res;
		
		if (isBlack == true) {
			color = "black";
		}
		else {
			color = "white";
		}
		
		res = color + " peice";
		
		return res;
		
	}
	
	protected void getValidMoves(int row, int col) {
		
		
	}
}

/*
 * Knight
 */
class Knight extends Peice{
	
	protected String getSymbol() {
		
		return("n");
	}
	
	protected String getName() {
		
		String color;
		String res;
		
		if (isBlack == true) {
			color = "black";
		}
		else {
			color = "white";
		}
		
		res = color + " peice";
		
		return res;
		
	}
	
	protected void getValidMoves(int row, int col) {
		
		
	}
}

/*
 * Bishop
 */
class Bishop extends Peice{
	
	protected String getSymbol() {
		
		return("b");
	}
	
	protected String getName() {
		
		String color;
		String res;
		
		if (isBlack == true) {
			color = "black";
		}
		else {
			color = "white";
		}
		
		res = color + " peice";
		
		return res;
		
	}
	
	protected void getValidMoves(int row, int col) {
		
		
	}
}

/*
 * King
 */
class King extends Peice{
	
	protected String getSymbol() {
		
		return("k");
	}
	
	protected String getName() {
		
		String color;
		String res;
		
		if (isBlack == true) {
			color = "black";
		}
		else {
			color = "white";
		}
		
		res = color + " peice";
		
		return res;
		
	}
	
	protected void getValidMoves(int row, int col) {
		
		
	}
}

/*
 * Queen
 */
class Queen extends Peice{
	
	protected String getSymbol() {
		
		return("q");
	}
	
	protected String getName() {
		
		String color;
		String res;
		
		if (isBlack == true) {
			color = "black";
		}
		else {
			color = "white";
		}
		
		res = color + " peice";
		
		return res;
		
	}
	
	protected void getValidMoves(int row, int col) {
		
		
	}
}