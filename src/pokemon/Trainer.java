package pokemon;

import java.util.LinkedList;

public class Trainer {

	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;
	private LinkedList<Pokemon> equipoPokemon;

//	public Trainer() {
//		super();
//		this.name = "";
//		this.equipoPokemon = new Pokemon[6];
//	}
	
	public Trainer(int id) {
		super();
		this.id=id;
		this.name = "";
		this.equipoPokemon = new LinkedList<Pokemon>();
	}

	public Trainer(int id, String name) {
		super();
		this.id=id;
		this.name = name;
		this.equipoPokemon = new LinkedList<Pokemon>();
	}

	public String getName() {
		return name;
	}

	public LinkedList<Pokemon> getEquipoPokemon() {
		return equipoPokemon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEquipoPokemon(LinkedList<Pokemon> equipoPokemon) {
		this.equipoPokemon = equipoPokemon;
	}

}
