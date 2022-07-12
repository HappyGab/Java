package lab4;

/**
 * This class implements CardTemplate, it contains the methods of cards
 * @author gabko
 * @version 1.0
 * @since 1.8
 */
public class Card implements CardTemplate {

	private int rankNum;
	private int suitNum;

	/**
	 * Constructor
	 * @param suitNum : the number assigned to the suit of the card
	 * @param rankNum : the number assigned to the rank of the card
	 */
	public Card(int suitNum, int rankNum) {

		this.rankNum = rankNum;
		this.suitNum = suitNum;
	}

	/**
	 * This method returns the short name of the card
	 * @return res : the short name of the card
	 */
	public String getShortName() {

		String res = rankShort[rankNum] + suitShort[suitNum];
		return res;
	}

	/**
	 * This method returns the long name of the card
	 * @return res : the long name of the card
	 */
	public String getLongName() {

		String res = rankLong[rankNum] + " of " + suitLong[suitNum];
		return res;
	}

}
