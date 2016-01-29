package translators.moves;

import translators.GenericTranslator;

public class MovesYearOfPlentyTranslator extends GenericTranslator {
	
	private String type;
	private int playerIndex;
	//Resource names must be capitalized
	private String resource1;
	private String resource2;
	
	public MovesYearOfPlentyTranslator(int playerIndex, String resource1, String resource2) {
		super();
		this.type = "Year_of_Plenty";
		this.playerIndex = playerIndex;
		this.resource1 = resource1;
		this.resource2 = resource2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPlayerIndex() {
		return playerIndex;
	}

	public void setPlayerIndex(int playerIndex) {
		this.playerIndex = playerIndex;
	}

	public String getResource1() {
		return resource1;
	}

	public void setResource1(String resource1) {
		this.resource1 = resource1;
	}

	public String getResource2() {
		return resource2;
	}

	public void setResource2(String resource2) {
		this.resource2 = resource2;
	}
}
