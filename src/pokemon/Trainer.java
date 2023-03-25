package pokemon;

public class Trainer {
	


	private String name;
	private Pokemon[] equipoPokemon;
	
	
	public Trainer() {
		super();
		this.name = "";
		this.equipoPokemon = new Pokemon[6];
	}

	
	public Trainer(String name, Pokemon[] equipoPokemon) {
		super();
		this.name = name;
		this.equipoPokemon = equipoPokemon;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Pokemon[] getEquipoPokemon() {
		return equipoPokemon;
	}


	public void setEquipoPokemon(Pokemon[] equipoPokemon) {
		this.equipoPokemon = equipoPokemon;
	}
	
	
	

}
