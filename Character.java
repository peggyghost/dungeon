
abstract class Character{

	private String name;
	private int health;


	public Character(String name, int health){
		this.name = name;
		this.health = health;

	}
	public abstract void damage(int hit);
	public abstract String getname();
	public abstract boolean isAlive();
	public abstract void girlTaunt();
	public abstract void boyTaunt();
	public abstract void kill();
	public abstract int power();
	public abstract int health();
	public abstract String equippedWeapon();



}


