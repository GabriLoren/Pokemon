package modelo;

public class Obj {
	
	private int id;
	private String name;
	private int precio;
	private double atk;
	private double def;
	private double spDef;
	private double speed;
	private double stamina;
	
	public Obj() {
		super();
		this.id=0;
		this.name=name;
		this.atk = 1;
		this.def = 1;
		this.spDef = 1;
		this.speed = 1;
		this.stamina = 1;

	}

	public Obj(int id,String name) {
		super();
		this.id=id;
		this.name=name;
		this.atk = 1;
		this.def = 1;
		this.spDef = 1;
		this.speed = 1;
		this.stamina = 1;

	}

	public Obj(int id, String name, int precio, double atk, double def, double spDef, double speed, double stamina) {
		super();
		this.id=id;
		this.name=name;
		this.precio=precio;
		this.atk = atk;
		this.def = def;
		this.spDef = spDef;
		this.speed = speed;
		this.stamina = stamina;

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
		return  name;
	}

	
	
}
