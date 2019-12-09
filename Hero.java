/** The Hero class represents a subclass of {@link Character} which the {@link Enemy} battles.
  @author Suad
  @author Arsalan
  @author Paige
  */

import java.util.Scanner;
import java.io.PrintWriter;


public class Hero extends Character{
	public int health;
	public boolean isalive;
	private String name;
	private String Class;
	Item weapon;
	
	/** constructor for the Hero Class.
	  @param name the first name of the Hero.
	  @param health the health of the Hero represented by an integer
	  @param Class the type of class the hero is in.
	  */
	Hero(String name, int health, String Class){
		super(name, health);
		this.name = name;
		this.Class = Class;
		this.health = 100;
		this.isalive = true;
		this.weapon = weapon;
	}
	/** 
	  Gets the name of the Hero.
	  @return this hero's name.
	  */
	public String getname(){
		return name;
	}

	/**
	  Save method that saves the Hero's name, class, health, and if they're alive or not.
	  @param pw the variable for the Print Writer.
	  */
	void save(PrintWriter pw){

                pw.println(name);
		pw.println(Class);
		pw.println(health);
		pw.println(isalive);

        }

		
		//       Hero.save(pw);



/*	Hero(Scanner in){
		name = in.nextLine();
		Class = in.nextLine();
		health = in.nextInt();
		isalive = in.nextBoolean();
		
	}*/

	/**
	  Calculates the amount of damage done by an attack
	  @param hit the amount of power that was used for an attack.
	  */
	public void damage(int hit){
		this.health -= hit;
	}
	
	/**
	  Checks to see if charater is alive or dead.
	  @return a boolean determining if the Character is dead or alive.
	  */
	public boolean isAlive(){
		if(this.health > 0){
			return true;
		}
		else{
			return false;
		}
	}

	/** 
	 Automatically kills the character when method is called by initializing the health to 0.
	*/
	public void kill(){
		this.health = 0;
	}
	
	/**
	  Prints taunts to the screen for the player to read/be intimidated by.
	  */
	public void girlTaunt(){
		System.out.println(this.name + ":YOU'RE SO BOGUS! YOU SHOULD BE LIKE ME, A STRONG INDEPDENT SEXY MAN");
	}
	
	/**
	  Prints taunts to the screen for the player to be read/intimidated by.
	  */
	public void boyTaunt(){
		System.out.println(this.name + "I am SO glad I dumped you. Whew. Dodged a bullet with that one!");
	}
	
	/**
	  Equips a weapon for the Character.
	  @return the selected weapon in a readable format using the .toString() method.
	  */
	 public String equippedWeapon(){
                return this.weapon.toString();
        }//ending bracket for equip

	 /**
	   A method that obtains the amount of power a weapon has.
	   @return the weapons power.
	   */
	public int power(){
                return this.weapon.getPower();
             }
	
	/**
	  A method to retrieve the health of the player.
	  @return the health of the player.
	  */
	public int health(){
                return this.health;
        }



}











