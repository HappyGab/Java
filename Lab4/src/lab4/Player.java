package lab4;

import java.util.ArrayList;
import java.util.Random;

/**
 * this class is for the players, they each have their own instance of it
 * it contains the methods for the players
 * @author gabko
 * @version 1.0
 * @since 1.8
 */
public class Player {

	private ArrayList<Card> playerDeck = new ArrayList<Card>();

	private String name;
	private int wins;

	/**
	 * Constructor
	 * @param name : this is the name entered for the player
	 */
	public Player(String name) {

		this.name = name;
		this.wins = 0;
	}

	/**
	 * this method changes the name for the player
	 * @param name : this is the name entered for the player
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * This method adds a card the the players hand
	 * @param cardToAdd : the card to be added the the players hand
	 */
	public void addCard(Card cardToAdd) {

		playerDeck.add(cardToAdd);

	}

	/**
	 * This method returns the hand of the player
	 * @return the hand of the player
	 */
	public String getHand() {

		String pDeck = "";

		for (int i = 0; i < playerDeck.size(); i++) {

			pDeck = pDeck + playerDeck.get(i).getShortName() + " ";
		}

		return pDeck;
	}

	/**
	 * This method adds 1 to the win counter of the player
	 * @return void
	 */
	public void handWon() {

		wins = wins + 1;
	}

	/**
	 * This method returns the amount of wins the player has
	 * @return the amount of wins the player has
	 */
	public int getScore() {

		return wins;
	}

	/**
	 * this method returns the name of the player
	 * @return the name of the player
	 */
	public String getName() {

		return name;
	}

	/**
	 * This method resets the hand and win counter of the player
	 * @return void
	 */
	public void reset() {

		playerDeck.clear();
		wins = 0;
	}

	/**
	 * this method chooses what card the player plays
	 * @return the card the player plays
	 */
	public Card playCard() {

		Random rng = new Random();
		int rng1 = rng.nextInt(playerDeck.size());
		Card cardToPlay = playerDeck.get(rng1);
		playerDeck.remove(rng1);
		
		return cardToPlay;
	}
}
