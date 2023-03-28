package pokemon;

public class Obj {

	private String name;
	private double buff;
	private double debuffs;

	public Obj(String name, double buff, double debuffs) {
		super();
		this.name = name;
		this.buff = buff;
		this.debuffs = debuffs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBuff() {
		return buff;
	}

	public void setBuff(double buff) {
		this.buff = buff;
	}

	public double getDebuffs() {
		return debuffs;
	}

	public void setDebuffs(double debuffs) {
		this.debuffs = debuffs;
	}

}
