package player;
import java.util.ArrayList;

import shared.DevelopmentCard;
import shared.ResourceCard;
import shared.definitions.DevCardType;
import shared.definitions.ResourceType;


public class Hand 
{
	/**
	 * Development cards owned by player
	 */
	private ArrayList<DevelopmentCard> developmentCards;
	/**
	 * Resource cards owned by player
	 */
	private ArrayList<ResourceCard> resourceCards;
	/**
	 * Knights owned by player
	 */
	private int knights;
	/**
	 * returns number of total resources owned by player
	 * @return
	 */
	public int getNumResources()
	{
		return resourceCards.size();
	}
	/**
	 * returns number of development cards owned by player
	 * @return
	 */
	public int getNumDevCards()
	{
		return developmentCards.size();
	}
	
	/**
	 * Add resource of type and amount to player hand
	 * @param amount
	 * @param type
	 */
	public void addResources(int amount, ResourceType type)
	{
		
	}
	/**
	 * Remove resources of type and amount from player hand
	 * @param amount
	 * @param type
	 */
	public void removeResources(int amount, ResourceType type)
	{
		
	}
	/**
	 * returns number of resources of specified type in player hand
	 * @param type
	 * @return
	 */
	public int numResourceOfType(ResourceType type)
	{
		return 0;
	}
	/**
	 * Add development card of type to player hand
	 * @param type
	 */
	public void addDevelopmentCard(DevCardType type)
	{
		
	}
	/**
	 * remove development card of specified type from player hand
	 * @param type
	 */
	public void removeDevelopmentCard(DevCardType type)
	{
		
	}
	/**
	 * returns number of knights owned by player
	 * @return
	 */
	public int getArmySize()
	{
		return knights;
	}
	/**
	 * returns development cards owned by player
	 * @return
	 */
	public ArrayList<DevelopmentCard> getDevelopmentCards()
	{
		return developmentCards;
	}
	/**
	 * returns resource cards owned by player
	 * @return
	 */
	public ArrayList<ResourceCard> getResourceCards()
	{
		return resourceCards;
	}
	
}
