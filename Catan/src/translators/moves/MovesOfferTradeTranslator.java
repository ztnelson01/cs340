package translators.moves;

import translators.GenericTranslator;
/***** Order for ResourceList constructor: brick, ore, sheep, wheat, wood*****/
public class MovesOfferTradeTranslator extends GenericTranslator {
	
	private String type;
	private int playerIndex;
	private ResourceList offer;
	private int receiver;
	
	public MovesOfferTradeTranslator(int playerIndex, ResourceList offer, int receiver) {
		super();
		this.type = "offerTrade";
		this.playerIndex = playerIndex;
		this.offer = offer;
		this.receiver = receiver;
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

	public ResourceList getOffer() {
		return offer;
	}

	public void setOffer(ResourceList offer) {
		this.offer = offer;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
}
