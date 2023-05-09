package modelo;

import java.util.LinkedList;
import java.util.Random;

public class Pokemon {

	private int id;
	private int idPokedex;
	private String name;
	private String nickname;
	private int vit;
	private int atk = 0;
	private int def;
	private int spAtk;
	private int spDef;
	private int speed;
	private int stamina;
	private int level;
	private LinkedList<Move> moves;
//	private Move move; //Hago pruebas con un solo movimiento
	private int fertility;
	private boolean gender;
	private Types type1;
	private Types type2;
	private String status;
	private Obj object;
	private String equipo;
	private String imagen;
	private String nombreObjeto;
	private int exp;

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
		this.fertility = p.fertility;
		this.status = p.status;
		this.moves = p.moves;
		this.imagen = p.imagen;

	}

	public Pokemon(int id, String name, String nickname, int vit, int atk, int def, int spAtk, int spDef, int speed,
			int stamina, int level) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.vit = vit;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.stamina = stamina;
		this.level = level;

//		this.moves = moves;
//		this.status = status;

	}

	// constructor para la crianza
	public Pokemon(int id, int idPokedex, String nickname, int vit, int atk, int def, int spAtk, int spDef, int speed,
			int level, int fertility, String equipo) {
		super();
		this.id = id;
		this.idPokedex = idPokedex;
		this.nickname = nickname;
		this.vit = vit;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.stamina = stamina;
		this.level = level;
		this.equipo = equipo;
		this.fertility = fertility;
		this.moves = new LinkedList<Move>();

	}

	public Pokemon(int id, int idPokedex, String name, String nickname, int vit, int atk, int def, int spAtk, int spDef,
			int speed, int stamina, int level, int fertility, String equipo, String status, String imagen, int exp) {
		super();
		this.id = id;
		this.idPokedex = idPokedex;
		this.name = name;
		this.nickname = nickname;
		this.vit = vit;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.stamina = stamina;
		this.level = level;
		this.equipo = equipo;
		this.fertility = fertility;
		this.moves = new LinkedList<Move>();
		this.status = status;
		this.setImagen(imagen);
		this.exp=exp;

	}

	public Pokemon(int id, String name, int vit, int atk, int def, int spAtk, int spDef, int speed, int stamina,
			int level, int fertility, String imagen, Types tipo1, Types tipo2) {
		super();
		this.id = id;
		this.name = name;
		this.vit = vit;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.stamina = stamina;
		this.level = level;
		this.moves = new LinkedList<Move>();
		this.status = status;
		this.fertility = fertility;
		this.setImagen(imagen);
		this.type1 = tipo1;
		this.setType2(tipo2);

	}

//	public Pokemon(String name, String mote) {
//
//		this.id = id;
//		this.name = name;
//		this.nickname = mote;
//		this.vit = 100;
//		this.atk = 0;
//		this.def = 20;
//		this.spAtk = 0;
//		this.spDef = 0;
//		this.speed = 0;
//		this.stamina = 0;
//		this.level = 0;
//		this.moves = new LinkedList<Move>();
//		this.fertility = 0;
//		this.gender = false;
//		this.type1 = Types.NORMAL;
//		this.status = "";
////		this.object = new Obj();
//
//	}

	public Pokemon(String name, LinkedList<Move> moves) {

		this.id = 0;
		this.name = name;
		this.nickname = "";
		this.vit = 100;
		this.atk = 0;
		this.def = 20;
		this.spAtk = 0;
		this.spDef = 0;
		this.speed = 0;
		this.stamina = 0;
		this.level = 0;
		this.moves = moves;
		this.fertility = 0;
		this.gender = false;
		this.type1 = Types.NORMAL;
		this.status = "";
//		this.object = new Obj();

	}

//	public Pokemon(int id, String name, String nickname, int vit, int atk, int def, int spAtk, int spDef, int speed,
//			int stamina, int level, ArrayList<Move> moves, int fertility, boolean gender, Types type, String status,
//			Obj obj) {
//
//		this.id = id;
//		this.name = name;
//		this.nickname = nickname;
//		this.vit = vit;
//		this.atk = atk;
//		this.def = def;
//		this.spAtk = spAtk;
//		this.spDef = spDef;
//		this.speed = speed;
//		this.stamina = stamina;
//		this.level = level;
//		this.moves = moves;
//		
//		this.fertility = fertility;
//		this.gender = gender;
//		this.type = type;
//		this.status = status;
//		this.object = obj;
//	}

	public Pokemon(int id, String name, int vit) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.vit = vit;
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

//	public Move getMove() {//Pruebo con un solo movimiento
//	return move;
//}

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

	public Types getType1() {
		return type1;
	}

	public void setType1(Types type) {
		this.type1 = type;
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

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getIdPokedex() {
		return idPokedex;
	}

	public void setIdPokedex(int idPokedex) {
		this.idPokedex = idPokedex;
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

	// Generates a number between 1 and 5
	private static int randomStats() {
		Random r = new Random();
		return r.nextInt(5 - 1) + 1;
	}

	// A Pokemon levels up when its exp value equals or exceeds 10 * lvl, then
	// its exp value gets reduced by the same amount and its level increased by 1
	// and all its stats increase by a random number between 1
	// and 5 which is generated by calling the randomStats() method
	public void levelUp() {
		this.setExp(this.getExp() - this.getLevel() * 10);
		this.level++;
		this.vit += randomStats();
		this.atk += randomStats();
		this.def += randomStats();
		this.spAtk += randomStats();
		this.spDef += randomStats();
		this.speed += randomStats();
	}

	// Active pokemon gets experience after defeating a pokemon based on the
	// following formula ([POKEMON_LEVEL] + [RIVAL_POKEMON_LEVEL] * 10) / 4, then if
	// the exp value of the pokemon exceeds or equals its level times 10 it levels
	// up
	public void giveExp(Pokemon pr) {
		this.setExp(this.getExp() + ((this.getLevel() + pr.getLevel() * 10) / 4));
		while (this.getExp() >= (this.getLevel() * 10)) {
			this.levelUp();
		}
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", nickname=" + nickname + ", vit=" + vit + ", atk=" + atk
				+ ", def=" + def + ", spAtk=" + spAtk + ", spDef=" + spDef + ", speed=" + speed + ", stamina=" + stamina
				+ ", level=" + level + ", moves=" + moves + ", fertility=" + fertility + ", gender=" + gender
				+ ", type=" + type1 + ", status=" + status + ", object=" + object + ", equipo=" + equipo + "]";
	}

//	@Override
//	public String toString() {
//		return "Pokemon [id=" + id + ", name=" + name + ", nickname=" + nickname + ", vit=" + vit + ", atk=" + atk
//				+ ", def=" + def + ", spAtk=" + spAtk + ", spDef=" + spDef + ", speed=" + speed + ", stamina=" + stamina
//				+ ", level=" + level + ", moves=" + moves + ", fertility=" + fertility + ", gender=" + gender
//				+ ", type=" + type + ", status=" + status + ", object=" + object + "]";
//	}

}

//	@Override
//	public String toString() {
//		return "Pokemon [id=" + id + ", name=" + name + ", nickname=" + nickname + ", vit=" + vit + ", atk=" + atk
//				+ ", def=" + def + ", spAtk=" + spAtk + ", spDef=" + spDef + ", speed=" + speed + ", stamina=" + stamina
//				+ ", level=" + level + ", moves=" + moves + ", fertility=" + fertility + ", gender=" + gender
//				+ ", type=" + type + ", status=" + status + ", object=" + object + "]";
//	}
