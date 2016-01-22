package trade;

import shared.definitions.ResourceType;

public class MaritimeTrade 
{
	/**
	 * type of resource being recieved by player
	 */
	private ResourceType typeRecieve;
	/**
	 * type of resource being sent by player
	 */
	private ResourceType typeSend;
	/**
	 * player taking this trade action
	 */
	private int playerID;
	
	/**
	 * sets up necessary information for maritime trade
	 * @param typeRecieve
	 * @param typeSend
	 */
	public MaritimeTrade(ResourceType typeRecieve, ResourceType typeSend, int playerID)
	{
		this.typeRecieve = typeRecieve;
		this.typeSend = typeSend;
		this.playerID = playerID;
		
	}
	
	/**
	 * determines whether player can trade with bank
	 */
	public boolean canTrade(ResourceType typeLose, ResourceType typeRecieve, int Player)
	{
		return true;
	}
}
