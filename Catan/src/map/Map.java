package map;

import java.util.HashMap;
import java.util.HashSet;

import shared.locations.HexLocation;

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
