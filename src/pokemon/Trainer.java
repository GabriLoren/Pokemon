package pokemon;

import java.util.LinkedList;

public class Trainer {

	private String name;
	private LinkedList<Pokemon> equipoPokemon;

//	public Trainer() {
//		super();
//		this.name = "";
//		this.equipoPokemon = new Pokemon[6];
//	}

	public Trainer(String name, LinkedList<Pokemon> equipoPokemon) {
		super();
		this.name = name;
		this.equipoPokemon = equipoPokemon;
	}

	public String getName() {
		return name;
	}

	public LinkedList<Pokemon> getEquipoPokemon() {
		return equipoPokemon;
	}

}
