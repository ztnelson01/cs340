package translators.moves;

import shared.definitions.ResourceType;
import translators.GenericTranslator;

public class MovesMonopolyTranslator extends GenericTranslator {
	
	private String type;
	private String resource;
	private int playerIndex;
	
	public MovesMonopolyTranslator(int playerIndex, ResourceType resource) {
		super();
		this.type = "Monopoly";
		this.resource = resourceTranslate(resource);
		this.playerIndex = playerIndex;
	}
	
	private String resourceTranslate(ResourceType type){
		switch(type){
			case WOOD: return "Wood";
			case BRICK: return "Brick";
			case ORE: return "Ore";
			case WHEAT: return "Wheat";
			case SHEEP: return "Sheep";
		}
		return "";
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

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}
