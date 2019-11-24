
abstract class Character{

	private String name;
	private int health;


	public Character(String name, int health){
	       this.name = name;
	       this.health = health;
	}

	public String getname(){
		return name;
	}

	public int health(){
		return health;
	}

	public void damage(int hit){
		this.health -=hit;
	}

	public boolean isAlive() {
		if(this.health <= 0) {
			return false;
		}
		return true;
	}

	public abstract void taunts();

}

		
