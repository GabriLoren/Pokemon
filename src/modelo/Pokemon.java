package modelo;

import java.util.LinkedList;

public class Pokemon {



	private int id;
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
	private Types type;
	private String status;
	private Obj object;

	public Pokemon(String name, String mote) {

		this.id = id;
		this.name = name;
		this.nickname = mote;
		this.vit = 100;
		this.atk = 0;
		this.def = 20;
		this.spAtk = 0;
		this.spDef = 0;
		this.speed = 0;
		this.stamina = 0;
		this.level = 0;
		this.moves = new LinkedList<Move>();
		this.fertility = 0;
		this.gender = false;
		this.type = Types.NORMAL;
		this.status = "";
//		this.object = new Obj();

	}

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
		this.type = Types.NORMAL;
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

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
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

	@Override
	public String toString() {
		return " [name " + name + " nickname " + nickname + "]\n";
	}
	

}

//	@Override
//	public String toString() {
//		return "Pokemon [id=" + id + ", name=" + name + ", nickname=" + nickname + ", vit=" + vit + ", atk=" + atk
//				+ ", def=" + def + ", spAtk=" + spAtk + ", spDef=" + spDef + ", speed=" + speed + ", stamina=" + stamina
//				+ ", level=" + level + ", moves=" + moves + ", fertility=" + fertility + ", gender=" + gender
//				+ ", type=" + type + ", status=" + status + ", object=" + object + "]";
//	}
