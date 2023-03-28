package pokemon;

import java.util.LinkedList;

public class Pokemon {

	private int id;
	private String name;
	private String nickname;
	private int vit;
	private int atk;
	private int def;
	private int satk;
	private int sdef;
	private int speed;
	private int stamina;
	private int lvl;
	private LinkedList<Move> moves;
	private int fertility;
	private boolean gender;
	private Types type;
	private String status;
	private Obj object;

	public Pokemon(int id, String name, String nickname, int vit, int atk, int def, int satk, int sdef, int speed,
			int stamina, int lvl, LinkedList<Move> moves, int fertility, boolean gender, Types type, String status,
			Obj object) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.vit = vit;
		this.atk = atk;
		this.def = def;
		this.satk = satk;
		this.sdef = sdef;
		this.speed = speed;
		this.stamina = stamina;
		this.lvl = lvl;
		this.moves = moves;
		this.fertility = fertility;
		this.gender = gender;
		this.type = type;
		this.status = status;
		this.object = object;
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

	public static void levelUp() {

	}

	public static void attack() {

	}

	public static void typeCheck() {

	}

	public static void rest() {

	}

	public static void learnMove() {

	}

}
