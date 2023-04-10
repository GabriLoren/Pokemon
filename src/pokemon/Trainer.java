package pokemon;

import java.util.LinkedList;
import java.util.Scanner;

public class Trainer {

	private LinkedList<Pokemon> team;
	private LinkedList<Pokemon> box;
	private int id;
	private String name;
	private int pokedollar;
	private LinkedList<Obj> objects;
	private Scanner sc;

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

	// Improves a pokemon's stats by expending pokedollars
	// Scanner is temporary later replaced by SceneBuilder
	public void train(Pokemon poke) {
		System.out.println("Choose training method:");
		System.out.println("0 - Heavy Training");
		System.out.println("1 - Furious Training");
		System.out.println("2 - Functional Training");
		System.out.println("3 - Surreal Training");
		sc = new Scanner(System.in);
		int train = sc.nextInt();
		switch (train) {
		case 0:
			if (this.pokedollar >= (poke.getLvl() * 20)) {
				System.out.println("Pre-training Stats");
				System.out.println("Def: " + poke.getDef());
				System.out.println("S. Def: " + poke.getSdef());
				System.out.println("Vit: " + poke.getVit());
				this.pokedollar = -(poke.getLvl() * 20);
				poke.setDef(poke.getDef() + 5);
				poke.setSdef(poke.getSdef() + 5);
				poke.setVit(poke.getVit() + 5);
				System.out.println("Post-training Stats");
				System.out.println("Def: " + poke.getDef());
				System.out.println("S. Def: " + poke.getSdef());
				System.out.println("Vit: " + poke.getVit());
			} else {
				System.out.println("Not enough Pokedollars");
			}

			break;
		case 1:
			if (this.pokedollar >= (poke.getLvl() * 30)) {
				System.out.println("Pre-training Stats");
				System.out.println("Atk: " + poke.getAtk());
				System.out.println("S. Atk: " + poke.getSatk());
				System.out.println("Spd: " + poke.getSpd());
				this.pokedollar = -(poke.getLvl() * 30);
				poke.setAtk(poke.getAtk() + 5);
				poke.setSatk(poke.getSatk() + 5);
				poke.setSpd(poke.getSpd() + 5);
				System.out.println("Post-training Stats");
				System.out.println("Atk: " + poke.getAtk());
				System.out.println("S. Atk: " + poke.getSatk());
				System.out.println("Spd: " + poke.getSpd());
			} else {
				System.out.println("Not enough Pokedollars");
			}

			break;
		case 2:
			if (this.pokedollar >= (poke.getLvl() * 40)) {
				System.out.println("Pre-training Stats");
				System.out.println("Atk: " + poke.getAtk());
				System.out.println("Def: " + poke.getDef());
				System.out.println("Spd: " + poke.getSpd());
				System.out.println("Vit: " + poke.getVit());
				this.pokedollar = -(poke.getLvl() * 40);
				poke.setAtk(poke.getAtk() + 5);
				poke.setDef(poke.getDef() + 5);
				poke.setSpd(poke.getSpd() + 5);
				poke.setVit(poke.getVit() + 5);
				System.out.println("Post-training Stats");
				System.out.println("Atk: " + poke.getAtk());
				System.out.println("Def: " + poke.getDef());
				System.out.println("Spd: " + poke.getSpd());
				System.out.println("Vit: " + poke.getVit());
			} else {
				System.out.println("Not enough Pokedollars");
			}

			break;
		case 3:
			if (this.pokedollar >= (poke.getLvl() * 40)) {
				System.out.println("Pre-training Stats");
				System.out.println("S. Atk: " + poke.getSatk());
				System.out.println("S. Def: " + poke.getDef());
				System.out.println("Spd: " + poke.getSpd());
				System.out.println("Vit: " + poke.getVit());
				this.pokedollar = -(poke.getLvl() * 40);
				poke.setAtk(poke.getSatk() + 5);
				poke.setDef(poke.getDef() + 5);
				poke.setSpd(poke.getSpd() + 5);
				poke.setVit(poke.getVit() + 5);
				System.out.println("Post-training Stats");
				System.out.println("S. Atk: " + poke.getSatk());
				System.out.println("S. Def: " + poke.getSdef());
				System.out.println("Spd: " + poke.getSpd());
				System.out.println("Vit: " + poke.getVit());
			} else {
				System.out.println("Not enough Pokedollars");
			}

			break;
		default:
			break;
		}
	}

	public void capture() {

	}

	public void fight(Trainer trainer) {

	}

	public void breed(Pokemon male, Pokemon female) {

	}
}
