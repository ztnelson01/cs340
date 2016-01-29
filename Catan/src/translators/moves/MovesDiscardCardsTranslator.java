package translators.moves;

import translators.GenericTranslator;

public class MovesDiscardCardsTranslator extends GenericTranslator {
	
	private String type;
	private int playerIndex;
	private ResourceList discardedCards;
	
	public MovesDiscardCardsTranslator(int playerIndex, ResourceList discardedCards) {
		super();
		this.type = "discardCards";
		this.playerIndex = playerIndex;
		this.discardedCards = discardedCards;
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

	public ResourceList getDiscardedCards() {
		return discardedCards;
	}

	public void setDiscardedCards(ResourceList discardedCards) {
		this.discardedCards = discardedCards;
	}
}
