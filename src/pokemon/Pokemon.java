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

	// Checks the pokemon's stats and if they are greater than their max value they
	// get set to the max
	public void checkMaxStats() {
		if (this.vit > this.maxVit) {
			this.setVit(maxVit);
		}
		if (this.atk > this.maxAtk) {
			this.setAtk(maxAtk);
		}
		if (this.def > this.maxDef) {
			this.setDef(maxDef);
		}
		if (this.satk > this.maxSatk) {
			this.setSatk(maxSatk);
		}
		if (this.maxSdef > this.maxSdef) {
			this.setSdef(maxSdef);
		}
		if (this.spd > this.maxSpd) {
			this.setSpd(maxSpd);
		}
	}

	private int pokedexNum;
	private int trainerId;
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
	private char gender;
	private Types type1, type2;
	private Status status;
	private Obj object;
	private int exp;
	private String sprite;
	private int baseVit;
	private int baseAtk;
	private int baseDef;
	private int baseSatk;
	private int baseSdef;
	private int baseSpd;
	private int maxVit;
	private int maxAtk;
	private int maxDef;
	private int maxSatk;
	private int maxSdef;
	private int maxSpd;
	private int evolutionLvl;

	public Pokemon() {
		this.pokedexNum = 0;
		this.trainerId = 0;
		this.name = "";
		this.nickname = "";
		this.vit = 0;
		this.atk = 0;
		this.def = 0;
		this.satk = 0;
		this.sdef = 0;
		this.spd = 0;
		this.stamina = STAMINA;
		this.lvl = 1;
		this.moves = new LinkedList<Move>();
		this.fertility = 5;
		this.gender = ' ';
		this.type1 = null;
		this.type2 = null;
		this.status = null;
		this.object = null;
		this.exp = 0;
		this.sprite = "";
		this.baseVit = 0;
		this.baseAtk = 0;
		this.baseDef = 0;
		this.baseSatk = 0;
		this.baseSdef = 0;
		this.baseSpd = 0;
		this.maxVit = 0;
		this.maxAtk = 0;
		this.maxDef = 0;
		this.maxSatk = 0;
		this.maxSdef = 0;
		this.maxSpd = 0;
		this.evolutionLvl = 0;
	}

	public Pokemon(int id, int trainerId, String name, String nickname, int vit, int atk, int def, int satk, int sdef,
			int speed, int stamina, int lvl, LinkedList<Move> moves, int fertility, char gender, Types type1,
			Types type2, Status status, Obj object, int exp, String sprite, int baseVit, int baseAtk, int baseDef,
			int baseSatk, int baseSdef, int baseSpd, int maxVit, int maxAtk, int maxDef, int maxSatk, int maxSdef,
			int maxSpd, int evolutionLvl) {
		super();
		this.pokedexNum = id;
		this.trainerId = trainerId;
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
		this.sprite = sprite;
		this.baseVit = baseVit;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
		this.baseSatk = baseSatk;
		this.baseSdef = baseSdef;
		this.baseSpd = baseSpd;
		this.maxVit = maxVit;
		this.maxAtk = maxAtk;
		this.maxDef = maxDef;
		this.maxSatk = maxSatk;
		this.maxSdef = maxSdef;
		this.maxSpd = maxSpd;
	}

	public int getPokedexNum() {
		return pokedexNum;
	}

	public void setPokedexNum(int id) {
		this.pokedexNum = id;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Types getType1() {
		return type1;
	}

	public void setType1(Types type1) {
		this.type1 = type1;
	}

	public Types getType2() {
		return type2;
	}

	public void setType2(Types type2) {
		this.type2 = type2;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}

	public int getBaseVit() {
		return baseVit;
	}

	public void setBaseVit(int baseVit) {
		this.baseVit = baseVit;
	}

	public int getBaseAtk() {
		return baseAtk;
	}

	public void setBaseAtk(int baseAtk) {
		this.baseAtk = baseAtk;
	}

	public int getBaseDef() {
		return baseDef;
	}

	public void setBaseDef(int baseDef) {
		this.baseDef = baseDef;
	}

	public int getBaseSatk() {
		return baseSatk;
	}

	public void setBaseSatk(int baseSatk) {
		this.baseSatk = baseSatk;
	}

	public int getBaseSdef() {
		return baseSdef;
	}

	public void setBaseSdef(int baseSdef) {
		this.baseSdef = baseSdef;
	}

	public int getBaseSpd() {
		return baseSpd;
	}

	public void setBaseSpd(int baseSpd) {
		this.baseSpd = baseSpd;
	}

	public int getMaxVit() {
		return maxVit;
	}

	public void setMaxVit(int maxVit) {
		this.maxVit = maxVit;
	}

	public int getMaxAtk() {
		return maxAtk;
	}

	public void setMaxAtk(int maxAtk) {
		this.maxAtk = maxAtk;
	}

	public int getMaxDef() {
		return maxDef;
	}

	public void setMaxDef(int maxDef) {
		this.maxDef = maxDef;
	}

	public int getMaxSatk() {
		return maxSatk;
	}

	public void setMaxSatk(int maxSatk) {
		this.maxSatk = maxSatk;
	}

	public int getMaxSdef() {
		return maxSdef;
	}

	public void setMaxSdef(int maxSdef) {
		this.maxSdef = maxSdef;
	}

	public int getMaxSpd() {
		return maxSpd;
	}

	public void setMaxSpd(int maxSpd) {
		this.maxSpd = maxSpd;
	}

	public int getEvolutionLvl() {
		return evolutionLvl;
	}

	public void setEvolutionLvl(int evolutionLvl) {
		this.evolutionLvl = evolutionLvl;
	}

	// A Pokemon levels up when its exp value equals or exceeds 10 * lvl, then its
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
		checkMaxStats();
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

	// Checks if your pokemon's types has advantage or disadvantage against a
	// specific type
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

	// Sets a pokemon's stamina to the default value
	public void rest() {
		this.stamina = STAMINA;
	}

	// We need a temporary collection of Pokemon which will be later replaced or
	// filled by the database
	public void learnMove() {

	}

}
