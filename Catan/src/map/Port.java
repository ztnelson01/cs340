package map;

import java.util.HashSet;



public class Port {

	private PortType type;
	
	public enum PortType
	{
		
		WOOD, BRICK, SHEEP, WHEAT, ORE, THREE
	}
	
	
	
	public Port() {
		
	}

	/**
	 * @return the PortType (wood, wheat, 3 for 1, etc..)
	 */
	public PortType getType() {
		return type;
	}

	/**
	 * @param type the PortType to set
	 */
	public void setType(PortType type) {
		this.type = type;
	}
	
	
	
	
	
}
