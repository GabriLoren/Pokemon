package pokemon;

import java.util.LinkedList;
import java.util.Random;

public class Pokemon {

	private static final int STAMINA = 100;
	
	// Generates a number between 1 and 5
	private static int randomStats() {
		Random r = new Random();
		return r.nextInt(5 - 1) + 1;
	}

	private int pokedexNum;
	private String name;
	private String nickname;
	private int vit;
	private int atk;
	private int def;
	private int satk;
	private int sdef;
	private int spd;
	private int stamina;
	private int lvl;
	private LinkedList<Move> moves;
	private int fertility;
	private boolean gender;
	private Types type1, type2;
	private String status;
	private Obj object;
	private int exp;

	public Pokemon(int id, String name, String nickname, int vit, int atk, int def, int satk, int sdef, int speed,
			int stamina, int lvl, LinkedList<Move> moves, int fertility, boolean gender, Types type1, Types type2,
			String status, Obj object, int exp) {
		super();
		this.pokedexNum = id;
		this.name = name;
		this.nickname = nickname;
		this.vit = vit;
		this.atk = atk;
		this.def = def;
		this.satk = satk;
		this.sdef = sdef;
		this.spd = speed;
		this.stamina = stamina;
		this.lvl = lvl;
		this.moves = moves;
		this.fertility = fertility;
		this.gender = gender;
		this.type1 = type1;
		this.type2 = type2;
		this.status = status;
		this.object = object;
		this.exp = exp;
	}

	public int getId() {
		return pokedexNum;
	}

	public void setId(int id) {
		this.pokedexNum = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSatk() {
		return satk;
	}

	public void setSatk(int satk) {
		this.satk = satk;
	}

	public int getSdef() {
		return sdef;
	}

	public void setSdef(int sdef) {
		this.sdef = sdef;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int speed) {
		this.spd = speed;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public LinkedList<Move> getMoves() {
		return moves;
	}

	public void setMoves(LinkedList<Move> moves) {
		this.moves = moves;
	}

	public int getFertility() {
		return fertility;
	}

	public void setFertility(int fertility) {
		this.fertility = fertility;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Types getType() {
		return type1;
	}

	public void setType(Types type1) {
		this.type1 = type1;
	}

	public Types getType2() {
		return type2;
	}

	public void setType2(Types type2) {
		this.type2 = type2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Obj getObject() {
		return object;
	}

	public void setObject(Obj object) {
		this.object = object;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	// A Pokemon level ups when its exp value equals or exceeds 10 * lvl, then its
	// level increases by 1 and all its stats increase by a random number between 1
	// and 5 which is generated by calling the randomStats() method
	public void levelUp() {
		this.lvl++;
		this.vit += randomStats();
		this.atk += randomStats();
		this.def += randomStats();
		this.satk += randomStats();
		this.sdef += randomStats();
		this.spd += randomStats();
	}

	// A pokemon uses 1 of its moves to attack, if it is a normal attack, it can
	// only be used if the pokemon stamina is greater than or equal to the stamina
	// cost of attack
	public void attack() {
		if (this.moves.get(0).getStaminaCost() <= this.stamina) {
			this.stamina -= this.moves.get(0).getStaminaCost();
		} else {
			System.out.println("Not enough stamina!");
		}
	}

	// Checks if your pokemon's types has advantage or disadvantage against a specific type
	public String typeCheck(Types defType) {
		if (TypeChart.getTypeAdvantage(defType, this.type1).equals(EffectValues.INEFFECTIVE)
				|| TypeChart.getTypeAdvantage(defType, this.type2).equals(EffectValues.INEFFECTIVE)) {
			return "Ineffective";
		} else if (TypeChart.getTypeAdvantage(defType, this.type1).equals(EffectValues.ADVANTAGE)
				|| TypeChart.getTypeAdvantage(defType, this.type2).equals(EffectValues.ADVANTAGE)) {
			return "Advantage";
		} else if (TypeChart.getTypeAdvantage(defType, this.type1).equals(EffectValues.WEAK)
				|| TypeChart.getTypeAdvantage(defType, this.type2).equals(EffectValues.WEAK)) {
			return "Weak";
		} else {
			return "Neutral";
		}
	}

	//Sets a pokemon's stamina to the default value
	public void rest() {
		this.stamina = STAMINA;
	}

	public void learnMove() {

	}

}
