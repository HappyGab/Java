package lab4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab4 {

	private ArrayList<Card> deck = new ArrayList<Card>();
	
	private Player p1 = new Player("Player 1");
	private Player p2 = new Player("Player 2");
	private Player p3 = new Player("Player 3");
	private Player p4 = new Player("Player 4");
	
	public static void main(String[] args) {

		Lab4 l4 = new Lab4();
		
		l4.startGame();
		
		Scanner keyboard = new Scanner(System.in);
				
		int round = 0;
		
		Random rng = new Random();
		int rng1 = rng.nextInt(4);
		int lastWinner = rng1;
		
		Boolean keepPlay = true;
		
		while (keepPlay == true) {
			
			round  = round +1;
			
			lastWinner = l4.playRound(round, lastWinner);
			
			
			System.out.println("\nEnter \"q\" to quit, anything else to play another round");
			String keepPlayInput = keyboard.nextLine();
			if (keepPlayInput.equals("q")) {
				keepPlay = false;
			}
		}
		

	}

	public void startGame() {
		
		deck.clear();
		
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
			}
			else if (nextPlayer == 1) {
				cardPlayed = p2.playCard();
				System.out.println(p2.getName() + " plays " + cardPlayed.getLongName());
				deck.add(cardPlayed);
			}
			else if (nextPlayer == 2) {
				cardPlayed = p3.playCard();
				System.out.println(p3.getName() + " plays " + cardPlayed.getLongName());
				deck.add(cardPlayed);
			}
			else if (nextPlayer == 3) {
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
		}
		else if (winner == 1) {
			System.out.println(p2.getName() + " wins this round!");
			p2.handWon();
		}
		else if (winner == 2) {
			System.out.println(p3.getName() + " wins this round!");
			p3.handWon();
		}
		else if (winner == 3) {
			System.out.println(p4.getName() + " wins this round!");
			p4.handWon();
		}
		
		return winner;
	}
}
