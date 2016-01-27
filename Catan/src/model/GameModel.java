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
	private Map map;
	private Bank bank;
	private ArrayList<Player> players;
	private int playerIndex;

// Constructor
	public GameModel(Map map, int playerIndex) {
		this.map = map;
		this.bank = Bank.BANK;
		this.playerIndex = playerIndex;

		players.add(new Player(0, CatanColor.RED , "Player1"));
		players.add(new Player(1, CatanColor.GREEN, "Player2"));
		players.add(new Player(2, CatanColor.ORANGE, "Player3"));
		players.add(new Player(3, CatanColor.BLUE, "Player4"));
	}

// Public methods

	/**
	 *
	 * @return
     */
	public boolean sendChat(String message) {
		return true;
	}

	public boolean acceptTrade() {
		return false;
	}

	public boolean discardCards() {
		return false;
	}

	public boolean rollNumber(int number) {

		return false;
	}

	/**
	 * Returns a boolean whether or not the player can build a road at the given location
	 * @param free
	 * @param loc
     * @return
     */
	public boolean buildRoad(boolean free, EdgeLocation loc) {
		boolean canBuild;
		if(map.canBuildRoad(free, loc)) {
			canBuild = true;
		} else {
			canBuild = false;
		}

		if(!canBuild) {
			return false;
		}

		if(free) {
			if (!players.get(playerIndex).canBuildRoad(loc)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns a boolean whether or not the player can build a road at the given location
	 * @param free
	 * @param loc
     * @return
     */
	public boolean buildSettlement(boolean free, VertexLocation loc) {

		boolean canBuild;
		if(map.canBuildSettlement(free, loc)) {
			canBuild = true;
		} else {
			canBuild = false;
		}

		if(!canBuild) {
			return false;
		}

		if(free) {
			if (!players.get(playerIndex).canBuildSettlement(loc)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns a boolean whether or not the player can build a city at the given location
	 * @param free
	 * @param loc
     * @return
     */
	public boolean buildCity(boolean free, VertexLocation loc) {
		boolean canBuild;
		if(map.canBuildCity(free, loc)) {
			canBuild = true;
		} else {
			canBuild = false;
		}

		if(!canBuild) {
			return false;
		}

		if(free) {
			if (!players.get(playerIndex).canBuildCity(loc)) {
				return false;
			}
		}

		return true;	}

	public boolean offerTrade() {
		return false;
	}

	public boolean maritimeTrade() {
		return false;
	}

	public boolean robPlayer() {
		return false;
	}

	public boolean finishTurn() {
		return false;
	}

	public boolean buyDevCard() {
		return false;
	}

	public boolean soldier() {
		return false;
	}

	public boolean yearOfPlenty() {
		return false;
	}


	public boolean roadBuilding() {

	}

	public boolean monopoly() {
		return false;
	}

	public boolean monument(int playerID) {
		ArrayList<DevelopmentCard> cards = players.get(playerID).getPlayerHand().getDevelopmentCards();
		int count = 0;

		for(DevelopmentCard dc : cards) {
			if(dc.getType() == DevCardType.MONUMENT) {
				count++;
			}
		}
		int difference = 10 - count;

		if(difference >= players.get(playerID).getVictoryPoints()) {
			return true;
		} else {
			return false;
		}
	}

// Private methods
}
