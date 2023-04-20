package pokemon;

public class Obj {

	private int objId;
	private String name;
	private double buff;
	private double debuffs;

	public Obj(int objID, String name, double buff, double debuffs) {
		super();
		this.objId = objID;
		this.name = name;
		this.buff = buff;
		this.debuffs = debuffs;
	}

	public int getObjId() {
		return objId;
	}

	public void setObjId(int objId) {
		this.objId = objId;
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

	@Override
	public String toString() {
		return "Obj [objId=" + objId + ", name=" + name + ", buff=" + buff + ", debuffs=" + debuffs + "]";
	}

}
