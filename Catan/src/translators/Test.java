package translators;

import translators.games.*;
import translators.user.*;
import shared.locations.HexLocation;
import translators.game.*;
import translators.moves.*;


//Test main to see if translator objects produce desired output
public class Test {

	public Test(){};
	
	public static void main(String[] args){
		GenericTranslator test = new MovesAcceptTradeTranslator(1, false);
		String output = test.translate();
		System.out.println(output);
	}
}
	
