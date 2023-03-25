package pokemon;

public class Move {

	private int id;
	private Category category;
	private int power;
	private Types type;
	private String status;
	private int turns;
	private double buff;
	
	public Move() {
		super();
		this.id = 0;
		this.category = Category.ATK;
		this.power = 0;
		this.type = Types.NORMAL;
		this.status = "";
		this.turns = 0;
		this.buff = 0;
	}
	
	public Move(int id, Category category, int power, Types type, String status, int turns, double buff) {
		super();
		this.id = id;
		this.category = category;
		this.power = power;
		this.type = type;
		this.status = status;
		this.turns = turns;
		this.buff = buff;
	}

	public int getId() {
		return id;
	}

	public Category getCategory() {
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
	
	
}