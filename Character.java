/**
*  A character represents a player in the game The Character class is an abstract class which creates a new player and in itializes the playes name and health status.
*  @author Suad
*  @author Arsalan
*  @author Paige
  */


import java.io.PrintWriter;

public abstract class Character{

	private String name;
	private int health;

/**
  Creates a new character with their given name and health.
  @param name the name of the character.
  @param health the health of the character.
  */
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
	
	/**
	  Method to save the abstract Character class.
	  @param pw the variable name for the print writer.
	  */
	void save(PrintWriter pw){
		pw.println(name);
		pw.println(health);
	}



}


