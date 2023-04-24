package pokemon;

public class Obj {

	private int objId;
	private String name;
	private double buff;
	private double debuff;

	public Obj(int objID, String name, double buff, double debuff) {
		super();
		this.objId = objID;
		this.name = name;
		this.buff = buff;
		this.debuff = debuff;
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

	public double getDebuff() {
		return debuff;
	}

	public void setDebuff(double debuff) {
		this.debuff = debuff;
	}

	@Override
	public String toString() {
		return "Obj [objId=" + objId + ", name=" + name + ", buff=" + buff + ", debuff=" + debuff + "]";
	}

}
