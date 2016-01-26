package model;

import java.util.ArrayList;
import java.util.Scanner;

import map.Map;
import player.Player;
import shared.ResourceCard;
import shared.definitions.CatanColor;
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
		return players.get(playerId).canBuildSettlement(loc, setup);
	}
	
	/**
	 * Returns true if building a city is valid
	 * @param playerId
	 * @param loc
	 * @return
	 */
	public boolean canBuildCity(int playerId, VertexLocation loc) {
		return players.get(playerId).canBuildCity(loc);
	}
	
	/**
	 * Returns true if building a road is valid
	 * @param playerId
	 * @param loc
	 * @return
	 */
	public boolean canBuildRoad(int playerId, EdgeLocation loc) {
		return players.get(playerId).canBuildRoad(loc);
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
		if(players.get(playerID) == null || players.get(victimID) == null) {
			System.out.println("Error! Player doesn't exist!");
		}
		
		if(newRobberLocation == null) {
			System.out.println("Hex spot doesn't exist!");
		}
		
		// not done yet
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
		
	}
	
	/**
	 * Plays a year of plenty card, adds resource to Player
	 * @param playerID ID of player playing the card
	 * @param resource1 First resource to receive
	 * @param resource2 Second resource to receive
	 */
	public void yearOfPlenty(int playerID, ResourceType resource1, ResourceType resource2) {
		
	}
	
	/**
	 * Plays a road building card, places two roads at given edges
	 * @param playerID ID of player playing the card
	 * @param roadLocation1 First location to build road
	 * @param roadLocation2 Second location to build road
	 */
	public void roadBuilding(int playerID, EdgeLocation roadLocation1, EdgeLocation roadLocation2) {
		
	}
	
	/**
	 * Plays a knight card, basically robbing player
	 * @param playerID Player robbing
	 * @param victimID Player bing robbed
	 * @param newRobberLocation New location of robber piece
	 */
	public void knight(int playerID, int victimID, HexLocation newRobberLocation) {
		
	}
	
	/**
	 * Plays a monopoly card, gives player all of the given resource in play
	 * @param playerID ID of player playing the card
	 * @param resource Resource to monopolize
	 */
	public void monopoly(int playerID, ResourceType resource) {
		
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
		
	}
	
	/**
	 * Builds a settlement at given locaiton, won't change resources if during setUp
	 * @param playerID ID of player building settlement
	 * @param vertexLocation Location to build settlement
	 * @param setUp True if settlement is being built during initial set up
	 */
	public void buildSettlment(int playerID, VertexLocation vertexLocation, boolean setUp) {
		
	}
	
	/**
	 * Builds a city at given locaiton
	 * @param playerID ID of player building city
	 * @param vertexLocation Location to build city
	 */
	public void buildCity(int playerID, VertexLocation vertexLocation) {
		
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
