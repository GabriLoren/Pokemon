package modelo;

public class Move {

	private int id;
	private String name;
	private MoveCategory category;
	private int power;
	private Types type;
	private Status status;
	private int turns;
	private double buff;
	private int staminaCost;
	private Stats stat;
	private DmgTypes dmgTypes;
	private int lvlRequirement;
	

//	public Move() {
//		super();
//		this.id = 0;
//		this.category = Category.ATK;
//		this.power = 0;
//		this.type = Types.NORMAL;
//		this.status = "";
//		this.turns = 0;
//		this.buff = 0;
//	}

	public Move(String name) {
		super();
		this.name = name;

	}

	public Move(String name, int id, MoveCategory category, int power, Types type, Status status, int turns, double buff,
			int staminaCost, Stats stat, DmgTypes dmgType, int lvlRequirement) {
		super();
		this.name = name;
		this.id = id;
		this.category = category;
		this.power = power;
		this.type = type;
		this.status = status;
		this.turns = turns;
		this.buff = buff;
		this.staminaCost=staminaCost;
		this.stat = stat;
		this.dmgTypes = dmgType;
		this.setLvlRequirement(lvlRequirement);
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public MoveCategory getCategory() {
		return category;
	}

	public int getPower() {
		return power;
	}

	public Types getType() {
		return type;
	}

	public Status getStatus() {
		return status;
	}

	public int getTurns() {
		return turns;
	}

	public double getBuff() {
		return buff;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(MoveCategory category) {
		this.category = category;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public void setBuff(double buff) {
		this.buff = buff;
	}

	public int getStaminaCost() {
		return staminaCost;
	}

	public void setStaminaCost(int staminaCost) {
		this.staminaCost = staminaCost;
	}

	public Stats getStat() {
		return stat;
	}

	public void setStat(Stats stat) {
		this.stat = stat;
	}

	public DmgTypes getDmgTypes() {
		return dmgTypes;
	}

	public void setDmgTypes(DmgTypes dmgTypes) {
		this.dmgTypes = dmgTypes;
	}

	public int getLvlRequirement() {
		return lvlRequirement;
	}

	public void setLvlRequirement(int lvlRequirement) {
		this.lvlRequirement = lvlRequirement;
	}

	@Override
	public String toString() {

		return name + " " + category + " power=" + power;

	}

}
