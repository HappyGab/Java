package lab4;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	private ArrayList<Card> playerDeck = new ArrayList<Card>();

	private String name;
	private int wins;

	public Player(String name) {

		this.name = name;
		this.wins = 0;
	}

	public void addCard(Card cardToAdd) {

		playerDeck.add(cardToAdd);

	}

	public String getHand() {

		String pDeck = "";

		for (int i = 0; i < playerDeck.size(); i++) {

			pDeck = pDeck + playerDeck.get(i).getShortName() + " ";
		}

		return pDeck;
	}

	public void handWon() {

		wins = wins + 1;
	}

	public int getScore() {

		return wins;
	}

	public String getName() {

		return name;
	}

	public void reset() {

		playerDeck.clear();
		wins = 0;
	}

	public Card playCard() {

		Random rng = new Random();
		int rng1 = rng.nextInt(playerDeck.size());
		Card cardToPlay = playerDeck.get(rng1);
		playerDeck.remove(rng1);
		
		return cardToPlay;
	}
}
