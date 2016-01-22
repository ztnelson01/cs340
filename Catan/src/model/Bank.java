package model;

import java.util.ArrayList;
import shared.*;
import shared.definitions.ResourceType;

public class Bank 
{
	/**
	 * singleton
	 */
	public static Bank BANK = new Bank();
	/**
	 * Deck of development cards
	 */
	private ArrayList<DevelopmentCard> bankDevelopmentCards;
	/**
	 * List of all available resource cards
	 */
	private ArrayList<ResourceCard> bankResourceCards;
	
	private Bank()
	{
		generateStartingResources();
	}
	/**
	 * Populate deck of development cards and maximum number of resource cards
	 */
	public void generateStartingResources()
	{
		
	}
	/**
	 * add amount of type resources to the bank
	 * @param amount
	 * @param type
	 */
	public void addResources(int amount, ResourceType type)
	{
		
	}
	/**
	 * remove amount resources of type from the bank
	 * @param amount
	 * @param type
	 */
	public void removeResources(int amount, ResourceType type)
	{
		
	}
	/**
	 * Remove returns number of resources of type remaining in the bank
	 * @param type
	 * @return
	 */
	
	public int numResourceRemaining(ResourceType type)
	{
		return 0;
	}
	/**
	 * returns development cards
	 * @return
	 */
	public ArrayList<DevelopmentCard> getDevelopmentCards()
	{
		return bankDevelopmentCards;
	}
	/**
	 * returns resource cards
	 * @return
	 */
	public ArrayList<ResourceCard> getResourceCards()
	{
		return bankResourceCards;
	}
}
