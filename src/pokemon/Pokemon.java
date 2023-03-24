package pokemon;

public class Pokemon {

	private int id;
	private String name;
	private String nickname;
	private int vit;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int speed;
	private int stamina;
	private int level;
	private ArrayList<Move> moves;
	private int fertility;
	private boolean gender;
	private Type type;
	private String status;
	private Obj objeto;
	
	public Pokemon() {
		
		this.id = 0;
		this.name = "";
		this.nickname = "";
		this.vit = 0;
		this.atk = 0;
		this.def = 0;
		this.spAtk = 0;
		this.spDef = 0;
		this.speed = 0;
		this.stamina = 0;
		this.level = 0;
		this.moves = new ArrayList<Move>();
		this.fertility = 0;
		this.gender = false;
		this.type = new Type();
		this.status = "";
		this.objeto = new Obj();
		
	public Pokemon(int id, String name, String nickname, int vit, int atk, int def, int spAtk, int spDef, int speed,
			int stamina, int level, ArrayList<Move> moves, int fertility, boolean gender, Type type, String status,
			Obj obj) {
		
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.vit = vit;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.stamina = stamina;
		this.level = level;
		this.moves = moves;
		this.fertility = fertility;
		this.gender = gender;
		this.type = type;
		this.status = status;
		this.obj = obj;
	}
	
	
	

}
