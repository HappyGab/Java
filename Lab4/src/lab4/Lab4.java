package lab4;

import java.util.ArrayList;

public class Lab4 {

	public static void main(String[] args) {

		ArrayList <Card> deck = new ArrayList<Card>();
		
		for (int i = 0; i < 4; i++) {
			for (int i2 = 0; i2 < 13; i2++) {
				
				Card baseCard = new Card(i, i2);
				deck.add(baseCard);
				
			}
		}
		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();

		for (int i = 0; i < 13; i++) {
			
			p1.playerDeck.add(deck.get(rng1));
			
		}
	}

} 	
