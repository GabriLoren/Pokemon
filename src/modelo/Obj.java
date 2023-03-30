package modelo;

public class Obj {
	
	private int id;
	private String name;
	private double atk;
	private double def;
	private double spDef;
	private double speed;
	private double stamina;

	public Obj(String name) {
		super();
		this.id=0;
		this.name=name;
		this.atk = 1;
		this.def = 1;
		this.spDef = 1;
		this.speed = 1;
		this.stamina = 1;

	}

	public Obj(int id, String name, double atk, double def, double spDef, double speed, double stamina) {
		super();
		this.id=id;
		this.name=name;
		this.atk = atk;
		this.def = def;
		this.spDef = spDef;
		this.speed = speed;
		this.stamina = stamina;

	}
	public String name() {
		return name;
	}

	public double getAtk() {
		return atk;
	}

	public double getDef() {
		return def;
	}

	public double getSpDef() {
		return spDef;
	}

	public double getSpeed() {
		return speed;
	}

	public double getStamina() {
		return stamina;
	}

	@Override
	public String toString() {
		return "Obj [name=" + name + "]";
	}

	
	
}
