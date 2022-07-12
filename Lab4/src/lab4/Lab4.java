package lab4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the main Class, it holds the methods that make the game run *
 * 
 * @author gabriel Koscielniak
 * @version 1.0
 * @since 1.8
 *
 */
public class Lab4 {

	private ArrayList<Card> deck = new ArrayList<Card>();

	private Player p1 = new Player("Player 1");
	private Player p2 = new Player("Player 2");
	private Player p3 = new Player("Player 3");
	private Player p4 = new Player("Player 4");

	/**
	 * This method has a loop that runs the game for as long as the user does not instruct to quit
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {

		Lab4 l4 = new Lab4();

		l4.namePlayers();

		boolean playAgain = true;

		while (playAgain == true) {

			l4.startGame();

			Scanner keyboard = new Scanner(System.in);

			int round = 0;

			Random rng = new Random();
			int rng1 = rng.nextInt(4);
			int lastWinner = rng1;

			Boolean keepPlay = true;

			while (keepPlay == true) {

				round = round + 1;

				if (round < 13) {
					lastWinner = l4.playRound(round, lastWinner);

					System.out.println("\nEnter \"q\" to quit, anything else to play another round");
					String keepPlayInput = keyboard.nextLine();

					if (keepPlayInput.equals("q")) {
						System.out.println("\n" + l4.Champion());
						keepPlay = false;

						System.out.println("\nEnter \"y\" to play another match, anything else to quit");
						String playAgainInput = keyboard.nextLine();
						if (playAgainInput.equals("y")) {
							playAgain = true;
						} else {
							System.out.println("Thank you for playing! \nMade by Gabriel Koscielniak");
							playAgain = false;
						}
					}
				} else if (round == 13) {
					lastWinner = l4.playRound(round, lastWinner);
					System.out.println("\n" + l4.Champion());
					keepPlay = false;

					System.out.println("\nEnter \"y\" to play another match, anything else to quit");
					String playAgainInput = keyboard.nextLine();
					if (playAgainInput.equals("y")) {

						playAgain = true;
					} else {
						System.out.println("\nThank you for playing! \nMade by Gabriel Koscielniak");
						playAgain = false;
					}
				}
			}
		}

	}

	/**
	 * This method is to name the players at the start of the game
	 * @return void
	 */
	public void namePlayers() {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to Auto-Cards! \n\nLet's name the four players");

		System.out.print("Enter player 1's name: ");
		p1.setName(keyboard.nextLine());

		System.out.print("Enter player 2's name: ");
		p2.setName(keyboard.nextLine());

		System.out.print("Enter player 3's name: ");
		p3.setName(keyboard.nextLine());

		System.out.print("Enter player 4's name: ");
		p4.setName(keyboard.nextLine());
	}

	/**
	 * This method resets the players, the deck, and then deals the cards to the players
	 * @return void
	 */
	public void startGame() {

		deck.clear();
		p1.reset();
		p2.reset();
		p3.reset();
		p4.reset();

		for (int i = 0; i < 4; i++) {
			for (int i2 = 0; i2 < 13; i2++) {

				Card baseCard = new Card(i, i2);
				deck.add(baseCard);

			}
		}

		Random rng = new Random();

		for (int i = 0; i < 13; i++) {

			int rng1 = rng.nextInt(deck.size());
			p1.addCard(deck.get(rng1));
			deck.remove(rng1);

			int rng2 = rng.nextInt(deck.size());
			p2.addCard(deck.get(rng2));
			deck.remove(rng2);

			int rng3 = rng.nextInt(deck.size());
			p3.addCard(deck.get(rng3));
			deck.remove(rng3);

			int rng4 = rng.nextInt(deck.size());
			p4.addCard(deck.get(rng4));
			deck.remove(rng4);
		}
	}

	/**
	 * this method maks the player play in the correct order and selects a random winner for the round
	 * @param round : the number of the round being played
	 * @param lastWinner : the number assigned to player that won the last round
	 * @return the number assigned to the player that wins the round
	 */
	public int playRound(int round, int lastWinner) {

		System.out.println("Round: " + round + "\n");

		System.out.println(p1.getName() + "(" + p1.getScore() + " hands won) :" + p1.getHand());
		System.out.println(p2.getName() + "(" + p2.getScore() + " hands won) :" + p2.getHand());
		System.out.println(p3.getName() + "(" + p3.getScore() + " hands won) :" + p3.getHand());
		System.out.println(p4.getName() + "(" + p4.getScore() + " hands won) :" + p4.getHand());
		System.out.println("");

		int nextPlayer = 0;

		for (int i = lastWinner; i < lastWinner + 4; i++) {

			nextPlayer = i % 4;

			Card cardPlayed = new Card(0, 0);

			if (nextPlayer == 0) {
				cardPlayed = p1.playCard();
				System.out.println(p1.getName() + " plays " + cardPlayed.getLongName());
				deck.add(cardPlayed);
			} else if (nextPlayer == 1) {
				cardPlayed = p2.playCard();
				System.out.println(p2.getName() + " plays " + cardPlayed.getLongName());
				deck.add(cardPlayed);
			} else if (nextPlayer == 2) {
				cardPlayed = p3.playCard();
				System.out.println(p3.getName() + " plays " + cardPlayed.getLongName());
				deck.add(cardPlayed);
			} else if (nextPlayer == 3) {
				cardPlayed = p4.playCard();
				System.out.println(p4.getName() + " plays " + cardPlayed.getLongName());
				deck.add(cardPlayed);
			}
		}

		System.out.println("");

		Random rng = new Random();
		int winner = rng.nextInt(4);

		if (winner == 0) {
			System.out.println(p1.getName() + " wins this round!");
			p1.handWon();
		} else if (winner == 1) {
			System.out.println(p2.getName() + " wins this round!");
			p2.handWon();
		} else if (winner == 2) {
			System.out.println(p3.getName() + " wins this round!");
			p3.handWon();
		} else if (winner == 3) {
			System.out.println(p4.getName() + " wins this round!");
			p4.handWon();
		}

		return winner;
	}

	/**
	 * this method counts the wins of every player, and determines the winner
	 * @return the winner of the match
	 */
	public String Champion() {

		Player winner = p1;

		Player[] playerList = { p1, p2, p3, p4 };

		String res = "";

		for (int i = 1; i <= 3; i++) {

			if (winner.getScore() > playerList[i].getScore()) {
				res = (winner.getName() + " has won the match!");
			} else if (winner.getScore() < playerList[i].getScore()) {
				winner = playerList[i];
				res = (winner.getName() + " has won the match!");
			}
		}

		String tiedPlayers = winner.getName();

		for (int i = 1; i <= 3; i++) {

			if (winner.getName().equals(playerList[i].getName())) {
				// nothing happens :D
			} else {
				if (winner.getScore() == playerList[i].getScore()) {

					tiedPlayers = tiedPlayers + " and " + playerList[i].getName();
					res = tiedPlayers + " have tied!";
				}
			}
		}

		return res;
	}
}
