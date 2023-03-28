package pokemon;

import java.util.LinkedList;

public class Trainer {

	private LinkedList<Pokemon> team;
	private LinkedList<Pokemon> box;
	private int id;
	private String name;
	private int pokedollar;
	private LinkedList<Obj> objects;

	public Trainer(LinkedList<Pokemon> team, LinkedList<Pokemon> box, int id, String name, int pokedollar,
			LinkedList<Obj> objects) {
		super();
		this.team = team;
		this.box = box;
		this.id = id;
		this.name = name;
		this.pokedollar = pokedollar;
		this.objects = objects;
	}

	public LinkedList<Pokemon> getTeam() {
		return team;
	}

	public void setTeam(LinkedList<Pokemon> team) {
		this.team = team;
	}

	public LinkedList<Pokemon> getBox() {
		return box;
	}

	public void setBox(LinkedList<Pokemon> box) {
		this.box = box;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPokedollar() {
		return pokedollar;
	}

	public void setPokedollar(int pokedollar) {
		this.pokedollar = pokedollar;
	}

	public LinkedList<Obj> getObjects() {
		return objects;
	}

	public void setObjects(LinkedList<Obj> objects) {
		this.objects = objects;
	}

	public void moveToTeam(Pokemon poke) {

	}

	public void moveToBox(Pokemon poke) {

	}

	public void train(Pokemon poke) {

	}

	public void capture() {

	}

	public void fight(Trainer trainer) {

	}

	public void breed(Pokemon male, Pokemon female) {

	}
}
