package modelo;

public class Move {

	private int id;
	private String name;
	private String category;
	private int power;
	private Types type;
	private String status;
	private int turns;
	private double buff;
	private int staminaCost;

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

	public Move(String name, int id, String category, int power, Types type, String status, int turns, double buff,
			int staminaCost) {
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
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public int getPower() {
		return power;
	}

	public Types getType() {
		return type;
	}

	public String getStatus() {
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

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setType(Types type) {
		this.type = type;
	}

	public void setStatus(String status) {
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

	@Override
	public String toString() {

		return name + " " + category + " power=" + power;

	}

}