package modelo;

public class Obj {

	private int id;
	private String name;
	private int precio;
	private double atk;
	private double def;
	private double spDef;
	private double spAtk;
	private double speed;
	private double stamina;
	private int cantidad;

	public Obj() {
		super();
		this.id = 0;
		this.name = "";
		this.atk = 1;
		this.def = 1;
		this.spDef = 1;
		this.speed = 1;
		this.stamina = 1;

	}

	public Obj(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.atk = 1;
		this.def = 1;
		this.spDef = 1;
		this.speed = 1;
		this.stamina = 1;

	}
	
	public Obj(Obj o) {
		super();
		this.id = o.id;
		this.name = o.name;
		this.precio=o.precio;
		this.atk = o.atk;
		this.def = o.def;
		this.spDef = o.spDef;
		this.spAtk = o.spAtk;
		this.speed = o.speed;
		this.stamina = o.stamina;
		this.cantidad = o.cantidad;
	}

	public Obj(int id, String name, int precio, double atk, double def, double spDef, double spAtk, double speed,
			double stamina, int cantidad) {
		super();
		this.id = id;
		this.name = name;
		this.setPrecio(precio);
		this.atk = atk;
		this.def = def;
		this.spDef = spDef;
		this.spAtk = spAtk;
		this.speed = speed;
		this.stamina = stamina;
		this.cantidad = cantidad;
	}

	public Obj(int id, String name, int precio, double atk, double def, double spDef, double spAtk, double speed,
			double stamina) {
		super();
		this.id = id;
		this.name = name;
		this.setPrecio(precio);
		this.atk = atk;
		this.def = def;
		this.spDef = spDef;
		this.spAtk = spAtk;
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

	public void setName(String name) {
		this.name = name;
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

	public double getSpAtk() {
		return spAtk;
	}

	public void setSpAtk(double spAtk) {
		this.spAtk = spAtk;
	}

	public void setAtk(double atk) {
		this.atk = atk;
	}

	public void setDef(double def) {
		this.def = def;
	}

	public void setSpDef(double spDef) {
		this.spDef = spDef;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setStamina(double stamina) {
		this.stamina = stamina;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
