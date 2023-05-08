package modelo;

import java.util.LinkedList;
import java.util.Random;

public class Pokemon {
	
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
			if (this.spAtk > this.maxSatk) {
				this.setSpAtk(maxSatk);
			}
			if (this.maxSdef > this.maxSdef) {
				this.setSpDef(maxSdef);
			}
			if (this.speed > this.maxSpd) {
				this.setSpeed(maxSpd);
			}
		}

	private int id;
	private String name;
	private String nickname;
	private Types type1;
	private Types type2;
	private int vit;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int speed;
	private int stamina;
	private int level;
	private boolean equipo;
	private int exp;
	private String imagen;
	private Obj object;
	private LinkedList<Move> moves;
	private Status status;
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
	static int fertility;
	

	public Pokemon(int id, String name, String nickname, Types type1, Types type2, int vit, int atk, int def, int spAtk,
			int spDef, int speed, int stamina, int level, boolean equipo, int exp, String imagen, int fertility) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.type1 = type1;
		this.type2 = type2;
		this.vit = vit;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.stamina = stamina;
		this.level = level;
		this.equipo = equipo;
		this.exp = exp;
		this.imagen = imagen;
		this.moves = new LinkedList<Move>();
		this.status = null;
		this.fertility=fertility;
	}

	public Pokemon(Pokemon p) {

		this.id = p.id;
		this.name = p.name;
		this.nickname = p.nickname;
		this.vit = p.vit;
		this.atk = p.atk;
		this.def = p.def;
		this.spAtk = p.spAtk;
		this.spDef = p.spDef;
		this.speed = p.speed;
		this.stamina = p.stamina;
		this.level = p.level;
		this.equipo = p.equipo;
		this.status = p.status;
		this.moves = p.moves;
		this.imagen = p.imagen;
		this.object = p.object;
		this.exp = p.exp;

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

	public int getSpAtk() {
		return spAtk;
	}

	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}

	public int getSpDef() {
		return spDef;
	}

	public void setSpDef(int spDef) {
		this.spDef = spDef;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public LinkedList<Move> getMoves() {
		return moves;
	}

	public void setMoves(LinkedList<Move> moves) {
		this.moves = moves;
	}

	public Types getType() {
		return type1;
	}

	public void setType(Types type) {
		this.type1 = type;
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

	public boolean getEquipo() {
		return equipo;
	}

	public void setEquipo(boolean equipo) {
		this.equipo = equipo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Types getType2() {
		return type2;
	}

	public void setType2(Types type2) {
		this.type2 = type2;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
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

	// si el mote es una palabrota devuelve falso
	public static boolean comprobarMote(String mote) {

		if (mote.equalsIgnoreCase("mierda"))
			return false;
		else
			return true;

	}

	// pone el objeto al pokemon
	public void apllyObj(Obj objetc) {

		this.object = objetc;

		this.atk *= objetc.getAtk();
		this.def *= objetc.getDef();
		this.spAtk = 0;
		this.spDef = 0;
		this.speed = 0;
		this.stamina = 0;

	}

	public void recuperarEstamina() {

		stamina += 20;
	}
	
	// A Pokemon levels up when its exp value equals or exceeds 10 * lvl, then
		// its exp value gets reduced by the same amount and its level increased by 1
		// and all its stats increase by a random number between 1
		// and 5 which is generated by calling the randomStats() method
		public void levelUp() {
			this.level++;
			this.exp -= this.getLevel() * 10;
			this.vit += randomStats();
			this.atk += randomStats();
			this.def += randomStats();
			this.spAtk += randomStats();
			this.spDef += randomStats();
			this.speed += randomStats();
			checkMaxStats();
		}

}
