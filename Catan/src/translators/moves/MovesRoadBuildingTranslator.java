package translators.moves;

import translators.GenericTranslator;

public class MovesRoadBuildingTranslator extends GenericTranslator {
	
	private String type;
	private int playerIndex;
	private EdgeLocation spot1;
	private EdgeLocation spot2;
	
	public MovesRoadBuildingTranslator(int playerIndex, EdgeLocation spot1, EdgeLocation spot2) {
		super();
		this.type = "Road_Building";
		this.playerIndex = playerIndex;
		this.spot1 = spot1;
		this.spot2 = spot2;
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

	public EdgeLocation getSpot1() {
		return spot1;
	}

	public void setSpot1(EdgeLocation spot1) {
		this.spot1 = spot1;
	}

	public EdgeLocation getSpot2() {
		return spot2;
	}

	public void setSpot2(EdgeLocation spot2) {
		this.spot2 = spot2;
	}
}
