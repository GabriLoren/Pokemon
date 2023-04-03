package pokemon;

public class Move {

	private int id;
	private String name;
	private int power;
	private Types type;
	private String status;
	private int turns;
	private float buff;
	private int staminaCost;
	private int lvlRequirement;

	public Move(int id, String name, int power, Types type, String status, int turns, float buff, int stamina, int lvlReq) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
		this.type = type;
		this.status = status;
		this.turns = turns;
		this.buff = buff;
		this.staminaCost = stamina;
		this.setLvlRequirement(lvlReq);
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public float getBuff() {
		return buff;
	}

	public void setBuff(float buff) {
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

	public static void applyMove() {

	}

}
