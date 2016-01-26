package map;

import java.util.HashMap;
import java.util.HashSet;
import shared.locations.HexLocation;

/*
 * 
 * I'm making the game model now and I think that the map class should have a method updateRobberPosition/setRobberPosition
 * This way I can update it easily from the Game model class
 * The robber should be kept in the hexes themselves but it i think it should be update from the gamemodel to
 * the map then to the hexes. let me know what you guys think
 * 
 * Brian
 *
 */

public class Map {

	private HashMap<HexLocation, TerrainHex> hexes;
	
	public Map(){
		hexes = new HashMap<HexLocation, TerrainHex>();
		
		buildHexes();
	}
	
	/**
	 * 
	 * Creates and assembles TerrainHex objects to be stored in a HashMap to be used throughout the game
	 * 
	 **/
	public void buildHexes(){
		
	}
	
	/**
	 * adds Vertex objects to the correct TerrainHex (multiple Hexes can and will share a Vertex)
	 */
	public void addCorners(){
		
	}
	
	/**
	 * adds Edge objects to the correct TerrainHex (multiple hexes can and will share an edge)
	 */
	public void addEdges(){
		
	}
	
	/**
	 * adds Port objects to the correct Vertex objects
	 */
	public void addPorts(){
		
	}

	
	
	
	
	
}
