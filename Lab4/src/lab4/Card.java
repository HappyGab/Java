package lab4;

public class Card implements CardTemplate{

	int rankNum;
	int suitNum;
	
	public Card(int suitNum, int rankNum) {
		
		this.rankNum = rankNum;
		this.suitNum = suitNum;
	}
	
	public String getShortName() {
		
		String res = rankShort[rankNum] + " of " + suitShort[suitNum];
		return res;
	}

	public String getLongName() {
		
		String res = rankLong[rankNum] + " of " + suitLong[suitNum];
		return res;
	}

}
