/**
  An Enemy represents the object in the game in which the {@link Hero} battles and ultimately tries to avoid throughout the game.
 @author Suad 
@author Arsalan
@author Paige
*/


import java.util.*;
import java.io.PrintWriter;




class Enemy extends Character {

	String name;
	int health;
	Item weapon;


//	public  Enemy(String name, Item Weapon, int health) {
//		this.name = name;
//		this.weapon = Weapon;
//		this.health = health;
	/** 
	  Constructor for the Enemy class.
	  @param name the name of the Enemy.
	  @param health the health of the enemy.
	  @param Weapon a weapon from the {@link Item} class.
	  */
	public  Enemy(String name, int health, Item Weapon) {
		super(name, health);
		this.weapon = Weapon;
		this.name = name;
		this.health = health;
	}
	
	/**
	  Gets the health of the enemy.
	  @return the health of the enemy.
	  */
	public int health(){
		return this.health;
	}

	/**
	  A method that determines if the Enemy is dead or alive.
	  @return a boolean.
	  */
	public boolean isAlive() {
		if (this.health <= 0) {
			return false;
		}
		return true;
	}

	/**
	  Calculates the amount of damage done by an attack.
	  @param hit the amount of power used for an attack.
	  */
	public void damage(int hit){
		this.health -= hit;
	}
	
	/**
	  A method that obtains the amount of power a weapon has.
	  @return the weapons power.
	  */
	public int power(){
		return this.weapon.getPower();
		//return health - damage;
	}
	
	/**
	  Method gets the current equipped weapon.
	  @return the current weapon in a readable formet using the toString() method.
	  */
	public String equippedWeapon(){
		return this.weapon.toString();
	}//ending bracket for equip


	/**
	  Prints a taunt to the screen for the player to read/be intimidated by using a switch statement and random number generator.
	*/
	public void girlTaunt(){

		Random rand = new Random();

		int i = rand.nextInt()%3;

		switch (i){
			case 0:
				System.out.println("ARI: ahhh booo wahh wahhh I don't know what to do!!");
				break;
			case 1:
				System.out.println("ARI: i'll fake a pregnancy test...!");
				break;
			case 2:
				System.out.println("ARI: I will CONSENSUALLY  beat the cashews out of you.");
				break;
			default:
				break;

		}
	}//end of girlTaunt


	/**
	  Prints a taunt to the screen for the player to read/be intimidated by using a switch statement and a random number generator.
	  */
	public void boyTaunt(){
		Random rand = new Random();
		int i = rand.nextInt()%3;

		switch (i){
			case 0:
				System.out.println("GARRET: Oh no why don't you love me???????");
				break;
			case 1:
				System.out.println("GARRET: You better watch yourself, i'll threaten you with a marriage propsal!!");

				break;
			case 2:
				System.out.println( "GARRET: If I beat you up, my wife's boyfriend said that he'll buy me a nintendo switch");
				break;
			default:
				break;
		}
		System.out.println(" ");
	}

	/** retrieves the name of the Enemy.
	  @return the name of the enemy.
	  */
	public String getname(){
		return name;
	}


	/*
	   A method used to save the Enemy's stats.
	   @param pw the variable used for the Print Writer.
	   */
	void save(PrintWriter pw){
//		pw.println(name);
//		pw.println(weapon);
		pw.println(health);
	}

/*	Enemy(Scanner in){
		name = in.nextLine();
		weapon = in.nextLine();
		health = in.nextInt();
		for (Item weapon: Weapon){

	}*/
	
	/**
	  Automatically kills the charater when the method is called by initializing the health to 0.
	  */
	public void kill(){
                this.health = 0;
        }



}
