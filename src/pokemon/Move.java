package pokemon;

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
	private int lvlRequirement;
	private Stats stat;
	private DmgTypes dmgType;

	public Move() {
		this.id = 0;
		this.name = "";
		this.category = null;
		this.power = 0;
		this.type = null;
		this.status = null;
		this.turns = 0;
		this.buff = 0;
		this.staminaCost = 0;
		this.lvlRequirement = 0;
		this.stat = null;
		this.setDmgType(null);
	}

	public Move(int id, String name, MoveCategory category, int power, Types type, Status status, int turns,
			double buff, int stamina, int lvlReq, Stats stat, DmgTypes dmgType) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.power = power;
		this.type = type;
		this.status = status;
		this.turns = turns;
		this.buff = buff;
		this.staminaCost = stamina;
		this.lvlRequirement = lvlReq;
		this.stat = stat;
		this.setDmgType(dmgType);
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

	public MoveCategory getCategory() {
		return category;
	}

	public void setCategory(MoveCategory category) {
		this.category = category;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public Types getType() {
		return type;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public double getBuff() {
		return buff;
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

	public int getLvlRequirement() {
		return lvlRequirement;
	}

	public void setLvlRequirement(int lvlRequirement) {
		this.lvlRequirement = lvlRequirement;
	}

	public Stats getStat() {
		return stat;
	}

	public void setStat(Stats stat) {
		this.stat = stat;
	}

	public DmgTypes getDmgType() {
		return dmgType;
	}

	public void setDmgType(DmgTypes dmgType) {
		this.dmgType = dmgType;
	}

	// Sets a StaminaCost depending on the category of the move, if the move is an
	// attack the stamina cost is equal to its power divided by 2 otherwise its
	// stamina cost is equal to the amount of turns it is active times 10
	public void applyStaminaCost() {
		if (this.getCategory().equals(MoveCategory.ATTACK)) {
			this.setStaminaCost(this.getPower() / 2);
		} else {
			this.setStaminaCost(this.getTurns() * 10);
		}
	}

	@Override
	public String toString() {
		return "Move [id=" + id + ", name=" + name + ", category=" + category + ", power=" + power + ", type=" + type
				+ ", status=" + status + ", turns=" + turns + ", buff=" + buff + ", staminaCost=" + staminaCost
				+ ", lvlRequirement=" + lvlRequirement + "]";
	}

}
