package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import map.Map;
import player.Player;
import shared.DevelopmentCard;
import shared.ResourceCard;
import shared.definitions.CatanColor;
import shared.definitions.DevCardType;
import shared.definitions.ResourceType;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;

public class GameModel {
	
	private int version;
	private Map map;
	private Bank bank;
	private ArrayList<Player> players;
	private Player currentTurn;
	
// Construtor
	/**
	 * The only constructor in this class
	 */
	public GameModel() {
		// Set up the map and bank
		map = new Map();
		bank = Bank.BANK;
		
		// Set up the players
		players.add(new Player(0, CatanColor.RED , "Player1"));
		players.add(new Player(1, CatanColor.GREEN, "Player2"));
		players.add(new Player(2, CatanColor.ORANGE, "Player3"));
		players.add(new Player(3, CatanColor.BLUE, "Player4"));	
		currentTurn = players.get(0);
	}
	
// Public methods
	
	/**
	 * Plays the game
	 */
	public void playGame() {
		startSetUp();
	}
	
	/**
	 * Returns true if building a settlement is valid
	 * @param playerId
	 * @param loc
	 * @return
	 */
	public boolean canBuildSettlement(int playerId, VertexLocation loc, boolean setup){
		return players.get(playerId).canBuildSettlement(); && players.canBuildSettlement(playerId, loc, setup);
	}
	
	/**
	 * Returns true if building a city is valid
	 * @param playerId
	 * @param loc
	 * @return
	 */
	public boolean canBuildCity(int playerId, VertexLocation loc) {
		return players.get(playerId).canBuildCity() && map.canBuildCity(playerId, loc);
	}
	
	/**
	 * Returns true if building a road is valid
	 * @param playerId
	 * @param loc
	 * @return
	 */
	public boolean canBuildRoad(int playerId, EdgeLocation loc) {
		return players.get(playerId).canBuildRoad() && map.canBuildRoad(playerId, loc);
	}
	
	/**
	 * Returns true if trading with another player is valid
	 * @param playerId
	 * @param playerId
	 * @return
	 */
	public boolean canMaritimeTrade(int playerId, int playerId2) {
		if(players.get(playerId) == null || players.get(playerId2) == null) {
			System.out.println("Error! The player doesn't exist!");
		}
		
		ArrayList<ResourceCard> one = players.get(playerId).getPlayerHand().getResourceCards();
		ArrayList<ResourceCard> two = players.get(playerId2).getPlayerHand().getResourceCards();

		if(one.size() == 0 || two.size() == 0) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Returns true if trading with the bank is valid
	 * @param playerId
	 * @return
	 */
	public boolean canDomesticTrade(int playerId) {
		ArrayList<ResourceCard> resources = players.get(playerId).getPlayerHand().getResourceCards();
		int wood = 0;
		int brick = 0;
		int wool = 0;
		int wheat = 0;
		int ore = 0;
		
		
		for(ResourceCard rc : resources) {
			switch(rc.getType()) {
				case WOOD: wood++; break;
				case BRICK: brick++; break;
				case SHEEP: wool++; break;
				case WHEAT: wheat++; break;
				case ORE: ore++; break;
				default: System.out.println("Error! The resource type doesn't exist!");
			}
		}
		
		if(wood >= 4) {
			return true;
		}
		if(brick >= 4) {
			return true;
		}
		if(wool >= 4) {
			return true;
		}
		if(wheat >= 4) {
			return true;
		}
		if(ore >= 4) {
			return true;
		}
		
		return false;
	}
	
	
// Private methods	
	/**
	 * Runs the beginning setup of the game
	 */
	private void startSetUp() {
		
	}
	
	/**
	 * Player take's his/her turn
	 * @param playerId
	 */
	private void takeTurn(int playerId) {
		
	}
	
	/**
	 * Incriments the turn
	 */
	private void updateTurn() {
		version++;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}


	
// Getters and setters
	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}

	/**
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	
// Server methods
	/**
	 * Rolls the dice
	 * @param playerID
	 * @param numberRolled
	 * @
	 */
	public void rollNumber(int playerID, int numberRolled) {
		// I dont see the need of this method? Brian
	}
	
	/**
	 * Robs a player and moves robber
	 * @param playerID Player robbing
	 * @param victimID Player being robbed
	 * @param newRobberLocation New location of the robber piece
	 */
	public void robPlayer(int playerID, int victimID, HexLocation newRobberLocation) {
		// Error checking
		if(players.get(playerID) == null) {
			System.out.println("Error! Player doesn't exist!");
		}
		
		if(newRobberLocation == null) {
			System.out.println("Hex spot doesn't exist!");
		}
		
		// Rob the player
		if(players.get(victimID) != null) {
			// Get a random card
			Random randCard = new Random();
			int handSize = players.get(victimID).getPlayerHand().getResourceCards().size();
			int cardPos = randCard.nextInt(handSize);
			ResourceType stolenType = players.get(victimID).getPlayerHand().getResourceCards().get(cardPos).getType();
			
			// Do the stealing
			players.get(victimID).getPlayerHand().removeResources(1, stolenType);
			players.get(playerID).getPlayerHand().addResources(1, stolenType);
		}
	}
	
	/**
	 * Ends the turn of the player
	 * @param playerID ID of player finished their turn
	 */
	public void finishTurn(int playerID) {
		
	}
	
	/**
	 * Adds a development card to given player
	 * @param playerID ID of player buying card
	 */
	public void buyDevCard(int playerID) {
		// Error checking
		if(players.get(playerID) == null) {
			System.out.println("Error! The player doesn't exist!");
		}
		
		// More error checking - does the player have enough resources to buy a development card?
		ArrayList<ResourceCard> tempHand = players.get(playerID).getPlayerHand().getResourceCards();
		int numWool = 0;
		int numWheat = 0;
		int numOre = 0;
		for(ResourceCard rc : tempHand) {
			if(rc.getType() == ResourceType.SHEEP) {
				numWool++;
			}
			if(rc.getType() == ResourceType.WHEAT) {
				numWheat++;
			}
			if(rc.getType() == ResourceType.ORE) {
				numOre++;
			}
		}
		if(numWool == 0) {
			System.out.println("Error! There is not enough sheep to build a road!");
		}
		if(numWheat == 0) {
			System.out.println("Error! There is not enough wheat to build a road!");
		}
		if(numOre == 0) {
			System.out.println("Error! There is not enough ore to build a road!");
		}
		
		// Remove the resources from the player's hand
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.SHEEP);
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.WHEAT);
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.ORE);

		// Gives the player a new development card
		// Not done yet
	}
	
	/**
	 * Plays a year of plenty card, adds resource to Player
	 * @param playerID ID of player playing the card
	 * @param resource1 First resource to receive
	 * @param resource2 Second resource to receive
	 */
	public void yearOfPlenty(int playerID, ResourceType resource1, ResourceType resource2) {
		// Error checking
		if(players.get(playerID) == null) {
			System.out.println("Error! The player doesn't exist!");
		}
		
		// Add the cards to the player's hand
		players.get(playerID).getPlayerHand().addResources(1, resource1);
		players.get(playerID).getPlayerHand().addResources(1, resource2);

	}
	
	/**
	 * Plays a road building card, places two roads at given edges
	 * @param playerID ID of player playing the card
	 * @param roadLocation1 First location to build road
	 * @param roadLocation2 Second location to build road
	 */
	public void roadBuilding(int playerID, EdgeLocation roadLocation1, EdgeLocation roadLocation2) {
	/*	// Error Checking
		if(players.get(playerID) == null) {
			System.out.println("Error! The player doesn't exist!");
		}
		if(roadLocation1 == null) {
			System.out.println("Error! roadLocation1 doesn't exist!");
		}
		if(roadLocation2 == null) {
			System.out.println("Error! roadLocation2 doesn't exist!");
		}
		ArrayList<ResourceCard> tempHand = players.get(playerID).getPlayerHand().getResourceCards();
		int numWood = 0;
		int numBrick = 0;
		for(ResourceCard rc : tempHand) {
			if(rc.getType() == ResourceType.WOOD) {
				numWood++;
			}
			if(rc.getType() == ResourceType.BRICK) {
				numBrick++;
			}
		}
		if(numWood == 0) {
			System.out.println("Error! There is not enough lumber to build a road!");
		}
		if(numBrick == 0) {
			System.out.println("Error! There is not enough brick to build a road!");
		}
		
		// Check if it's possible to build a road at the given location
		if(canBuildRoad(playerID, roadLocation1)) {
			
		} else {
			System.out.println("Error! Canont build a road at the given location");
		}*/
		
	}
	
	/**
	 * Plays a knight card, basically robbing player
	 * @param playerID Player robbing
	 * @param victimID Player bing robbed
	 * @param newRobberLocation New location of robber piece
	 */
	public void knight(int playerID, int victimID, HexLocation newRobberLocation) {
		// Error checking is done in the robPlayer method
		robPlayer(playerID, victimID, newRobberLocation);
		
		// More error checking
		if(newRobberLocation == null) {
			System.out.println("Error! The new robber location doesn't exist!");
		}
		
		// Update the robber's position
		map.setRobberLocation(newRobberLocation);
		
	}
	
	/**
	 * Plays a monopoly card, gives player all of the given resource in play
	 * @param playerID ID of player playing the card
	 * @param resource Resource to monopolize
	 */
	public void monopoly(int playerID, ResourceType resource) {
		// Error checking
		ArrayList<DevelopmentCard> cards = players.get(playerID).getPlayerHand().getDevelopmentCards();
		boolean exist = false;
		for(DevelopmentCard temp : cards) {
			if(temp.getType() == DevCardType.MONOPOLY) {
				exist = true;
			}
		}
		if(!exist) {
			System.out.println("Error! The player doesn't have a monopoly card!");
		}
		
		// Remove all the resources
		int numOfResources = 0;
		for(Player temp : players) {
			ArrayList<ResourceCard> tempHand = temp.getPlayerHand().getResourceCards();
			int playerAmount = 0;
			for(ResourceCard rc : tempHand) {
				if(rc.getType() == resource) {
					playerAmount++;
				}
			}
			temp.getPlayerHand().removeResources(playerAmount, resource);
			
			numOfResources += playerAmount;
		}
		
		// Give all the resources to the player
		players.get(playerID).getPlayerHand().addResources(numOfResources, resource);
		
	}
	
	/**
	 * Plays a monument card, gives player a victory point
	 * @param playerID ID of player playing the card
	 */
	public void monument(int playerID) {
		players.get(playerID).setVictoryPoints(players.get(playerID).getVictoryPoints()+1);
	}
	
	/**
	 * Builds a road at given location, won't change resources if during setUp
	 * @param playerID ID of player building road
	 * @param roadLocation Location to build road
	 * @param setUp True if road is being built during initial set up
	 */
	public void buildRoad(int playerID, EdgeLocation roadLocation, boolean setUp) {
		// Error checking
		boolean canBuild = canBuildRoad(playerID, roadLocation);
		if(!canBuild) {
			System.out.println("Error! The player cannot build a road at this spot!");
		}
		
		// Build the road
		map.buildRoad(playerID, roadLocation);
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.BRICK);
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.WOOD);

	}
	
	/**
	 * Builds a settlement at given locaiton, won't change resources if during setUp
	 * @param playerID ID of player building settlement
	 * @param vertexLocation Location to build settlement
	 * @param setUp True if settlement is being built during initial set up
	 */
	public void buildSettlment(int playerID, VertexLocation vertexLocation, boolean setUp) {
		// Error checking
		boolean canBuild = canBuildSettlement(playerID, vertexLocation, setUp);
		if(!canBuild) {
			System.out.println("Error! The player cannot build a settlement at this spot!");
		}
		
		// Build the road
		map.buildSettlement(playerID, vertexLocation, setUp);
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.BRICK);
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.WOOD);
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.WHEAT);
		players.get(playerID).getPlayerHand().removeResources(1, ResourceType.SHEEP);

	}
	
	/**
	 * Builds a city at given locaiton
	 * @param playerID ID of player building city
	 * @param vertexLocation Location to build city
	 */
	public void buildCity(int playerID, VertexLocation vertexLocation) {
		// Error checking
		boolean canBuild = canBuildCity(playerID, vertexLocation);
		if(!canBuild) {
			System.out.println("Error! The player cannot build a city at this spot!");
		}
		
		// Build the road
		map.buildCity(playerID, vertexLocation);
		players.get(playerID).getPlayerHand().removeResources(2, ResourceType.WHEAT);
		players.get(playerID).getPlayerHand().removeResources(3, ResourceType.ORE);

	}
	
	/**
	 * Sends a trade offer from one player to another
	 * @param playerID ID of player sending trade
	 * @param resourceGive resouces offered
	 * @param resourceReceive resources to get from receiver
	 * @param receiverID ID of player being offered trade
	 */
	public void offerTrade(int playerID, ArrayList<ResourceType> resourceGive,
			ArrayList<ResourceType> resourceReceive, 
			int receiverID) {
		// Error checking
		if(players.get(playerID) == null) {
			System.out.println("Error! playerID doesn't exist!");
		}
		if(players.get(receiverID) == null) {
			System.out.println("Error! receiverID doesn't exist!");
		}
		if(resourceGive == null) {
			System.out.println("Error! resourceGive doesn't exist!");
		}
		if(resourceReceive == null) {
			System.out.println("Error! resourceRecieve doesn't exist!");
		}
		
		// Remove the resources from the players
		for(ResourceType rt : resourceGive) {
			players.get(playerID).getPlayerHand().removeResources(1, rt);
		}
		for(ResourceType rt : resourceReceive) {
			players.get(receiverID).getPlayerHand().removeResources(1, rt);
		}
		
		// Give the players their new resources
		for(ResourceType rt : resourceGive) {
			players.get(receiverID).getPlayerHand().addResources(1, rt);
		}
		for(ResourceType rt : resourceReceive) {
			players.get(playerID).getPlayerHand().addResources(1, rt);
		}
	}
	
	/**
	 * Used to accept or reject a trade offer
	 * @param playerID ID of player accepting or rejecting trade
	 * @param accept True if player accepted trade
	 */
	public void acceptTrade(int playerID, boolean accept) {
	}
	
	/**
	 * Used to execute trades involving ports
	 * @param playerID ID of player trading
	 * @param ratio Ratio of trade(ie for 3:1 the value of ratio would be 3)
	 * @param inputResource Resource player gives
	 * @param outputResource Resource player receives
	 */
	public void maritimeTrade(int playerID, int ratio, ResourceType inputResource, ResourceType outputResource) {
		// Error checking
		if(players.get(playerID) == null) {
			System.out.println("Error! Player doesn't exist!");
		}
		
		// Setup
		ArrayList<ResourceCard> hand = players.get(playerID).getPlayerHand().getResourceCards();
		
		
		// More error checking
		int numResources = 0;
		for(ResourceCard temp : hand) {
			if(temp.getType() == inputResource) {
				numResources++;
			}
		}
		
		if(numResources < ratio) {
			System.out.println("Error! Player doesn't have enough resources to trade! numResoures = " + numResources);
		}
		
		// Make the change
		players.get(playerID).getPlayerHand().removeResources(ratio, inputResource);
		
		
		// Add the card that the bank gives to the player
		players.get(playerID).getPlayerHand().addResources(1, outputResource);
				
	}
	
}
