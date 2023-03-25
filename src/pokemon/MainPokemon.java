package pokemon;

public class MainPokemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Obj obj = new Obj(1, "piedra", 0, 1.5, 0, 0, 0);

		Pokemon pokemon1 = new Pokemon();
		Pokemon pokemon2 = new Pokemon();

		Move move1 = new Move(1, Category.ATK, 10, Types.NORMAL, " ", 0, 0);
		
		Move move2 = new Move(1, Category.ATK, 20, Types.NORMAL, " ", 0, 0);
		
		Battle battal1=new Battle();
		
		Battle battal2=new Battle();
		
		
		battal1.pelea(pokemon1, pokemon2, move1);
			
		battal2.pelea(pokemon2, pokemon1, move2);	
			
		
		

	}

}
