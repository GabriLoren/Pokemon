package pokemon;

public class Move {

	private int id;
	private String category;
	private int power;
	private Types type;
	private String status;
	private int turns;
	private double buff;
	
	public Move() {
		super();
		this.id = 0;
		this.category = "";
		this.power = 0;
		this.type = new Type();
		this.status = "";
		this.turns = 0;
		this.buff = 0;
	}
	
	public Move(int id, String category, int power, Types type, String status, int turns, double buff) {
		super();
		this.id = id;
		this.category = category;
		this.power = power;
		this.type = type;
		this.status = status;
		this.turns = turns;
		this.buff = buff;
	}
	
}
