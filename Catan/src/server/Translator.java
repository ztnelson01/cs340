package server;

import java.util.ArrayList;

import model.GameModel;
import shared.definitions.ResourceType;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.locations.VertexLocation;

/**
 * 
 * Static class that translates between Java and JSON
 * All ToJSON methods take given parameters and make the necessary JSON model for the server call
 * fromJSON method takes JSON GameModel
 *
 */
public class Translator {
	
	public static Translator TRANSLATOR = new Translator();
	
	private Translator(){
	
	};
	
	public String userLoginToJSON(String username, String password){return null;};
	
	public String userRegisterToJSON(String username, String password){return null;};
	
	public String listGamesToJSON(){return null;};
	
	public String createGameToJSON(String name, boolean randomTiles, boolean randomNumbers, boolean randomPorts){return null;};
	
	public String joinGameToJSON(int gameID, String color){return null;};
	
	public GameModel getModelfromJSON(int versionID){return null;};
	
	public String addAIToJSON(String AIname){return null;};
	
	public String listAIsToJSON(){return null;};

	public String sendChatToJSON(int playerID, String content){return null;};
	
	public String rollNumberToJSON(int playerID, int numberRolled){return null;};

	public String robPlayerToJSON(int playerID, int victimID, HexLocation newRobberLocation){return null;};
	
	public String finishTurnToJSON(int playerID){return null;};
	
	public String buyDevCardToJSON(int playerID){return null;};
	
	public String yearOfPlentyToJSON(int playerID, ResourceType resource1, ResourceType resource2){return null;};

	public String roadBuildingToJSON(int playerID, EdgeLocation roadLocation1, EdgeLocation roadLocation2){return null;};
	
	public String knightToJSON(int playerID, int victimID, HexLocation newRobberLocation){return null;};
	
	public String monopolyToJSON(int playerID, ResourceType resource){return null;};
	
	public String monumentToJSON(int playerID){return null;};
	
	public String buildRoadToJSON(int playerID, EdgeLocation roadLocation, boolean setUp){return null;};
	
	public String buildSettlmentToJSON(int playerID, VertexLocation vertexLocation, boolean setUp){return null;};
	
	public String buildCityToJSON(int playerID, VertexLocation vertexLocation){return null;};
	
	public String offerTradeToJSON(int playerID, ArrayList<ResourceType> resourceGive,  ArrayList<ResourceType> resourceReceive, int receiverID){return null;};
	
	public String acceptTradeToJSON(int playerID, boolean accept){return null;}
	
	public String maritimeTradeToJSON(int playerID, int ratio, ResourceType inputResource, ResourceType outputResource){return null;};
	
	public String discardCardsToJSON(int playerID, ArrayList<ResourceType> resources){return null;};
}
