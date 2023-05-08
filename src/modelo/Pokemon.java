package modelo;

import java.util.LinkedList;

public class Pokemon {

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
	
	
	
	
	
	
	
	
	

	public Pokemon(int id, String name, String nickname, Types type1, Types type2, int vit, int atk, int def, int spAtk,
			int spDef, int speed, int stamina, int level, boolean equipo, int exp, String imagen, Obj object,
			LinkedList<Move> moves, Status status) {
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
		this.object = object;
		this.moves = moves;
		this.status = status;
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

}
