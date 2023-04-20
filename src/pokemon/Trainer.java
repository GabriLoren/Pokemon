package pokemon;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Trainer {
	
	// Generates a random quantity of Pokedollars between 800 and 1000
	private int PokedollarGenerator() {
		Random r = new Random();
		int low = 800;
		int high = 1000;
		int result = r.nextInt(high-low) + low;
		return result;
	}

	private LinkedList<Pokemon> team;
	private LinkedList<Pokemon> box;
	private int id;
	private String name;
	private int pokedollar;
	private LinkedList<Obj> objects;
	private Scanner sc;

	public Trainer() {
		this.team = new LinkedList<>();
		this.box = new LinkedList<>();
		this.id = 0;
		this.name = "";
		this.pokedollar = PokedollarGenerator();
		this.objects = new LinkedList<>();
	}
	
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

	// Adds a Pokemon to team if the team is not full, if the added Pokemon was in
	// the box it gets removed from it
	public void moveToTeam(Pokemon poke) {
		if (this.team.size() < 6) {
			this.team.add(poke);
			for (int i = 0; i <= this.box.size(); i++) {
				if (this.box.get(i).equals(poke)) {
					this.box.remove(i);
				}
			}
		} else {
			System.out.println("Team is full");
		}
	}

	// Adds a pokemon to box, if the added Pokemon was in the team it gets removed
	// from it
	public void moveToBox(Pokemon poke) {
		this.box.add(poke);
		for (int i = 0; i <= this.team.size(); i++) {
			if (this.team.get(i).equals(poke)) {
				this.team.remove(i);
			}
		}
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
				this.pokedollar -= (poke.getLvl() * 20);
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
				this.pokedollar -= (poke.getLvl() * 30);
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
				this.pokedollar -= (poke.getLvl() * 40);
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
				this.pokedollar -= (poke.getLvl() * 40);
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

	// Pokemon p is temporary, later to test the method I will make a collection of
	// pokemon and randomly select one which later will be replaced by the database
	// If the trainer's team is not full the Pokemon gets added to the team
	// otherwise
	// it is added to the box
	public void capture() {
		Pokemon p = new Pokemon();
		if (this.team.size() < 6) {
			this.team.add(p);
		} else {
			this.box.add(p);
		}
	}

	// Creates a new battle with another trainer as rival
	public void fight(Trainer trainer) {
	}

	// Pokemon name???? new pokemon??? parent's name randomly selected???
	public void breed(Pokemon male, Pokemon female) {

	}

	@Override
	public String toString() {
		return "Trainer [team=" + team + ", box=" + box + ", id=" + id + ", name=" + name + ", pokedollar=" + pokedollar
				+ ", objects=" + objects + ", sc=" + sc + "]";
	}
}
