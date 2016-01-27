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

// Constructor
	public GameModel(Map map) {
		this.map = map;
		this.bank = Bank.BANK;
	}

// Public methods

	/**
	 *
	 * @return
     */
	public boolean sendChat() {
		return true;
	}

	public boolean acceptTrade() {
		return false;
	}

	public boolean discardCards() {
		return false;
	}

	public boolean rollNumber() {
		return false;
	}

	public boolean buildRoad() {

	}

	public boolean buildSettlement() {
		return false;
	}

	public boolean buildCity() {
		return false;
	}

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
		return false;
	}

	public boolean monopoly() {
		return false;
	}

	public boolean monument() {
		return false;
	}

// Private methods
}
