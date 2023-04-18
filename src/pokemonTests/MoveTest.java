package pokemonTests;

import pokemon.Move;
import pokemon.MoveCategory;
import pokemon.Types;

public class MoveTest {
	
	public static void main(String[] args) {

		Move tackle = new Move(0, "Tackle", MoveCategory.ATTACK, 35, Types.NORMAL, null, 0, 0, 0, 1);
		
		System.out.println(tackle.toString());
		tackle.applyStaminaCost();
		System.out.println(tackle.toString());
		
		Move defenseCurl = new Move();
		
		defenseCurl.setId(1);
		defenseCurl.setName("Defense Curl");
		defenseCurl.setCategory(MoveCategory.BUFF);
		defenseCurl.setType(Types.NORMAL);
		defenseCurl.setTurns(5);
	}

}
