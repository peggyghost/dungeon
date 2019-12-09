import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * this is an inventory class that has the constructor that makes the array to hold items and a max weight to 
 * make a limit on how much can be held, 
 * there is a method that adds an item that calls the itme generator to get an item to be added to the inventoryu
 * there is a mthod that gets the total weight that gets the current total wieght 
 * there is a method that prints out the inventory
 * there is a method that drops an item it prints out the inventory and then asks which one the player would drop
 * then there is a method that eqips weapons and armer by printing out the inventory
 * and then asking wihch weapopn or armor they want to equp it only shows the type of the item that coresponds 
 * with the method
 @author Suad
 @author Arsalan
 @author Paige
 */
public class Inventory{

	private ArrayList<Item> items;
	private int maxWeight;
	private Item equippedWeapon;
	private Item equippedArmor;
	private Item StartingWeapon;
	private Item StartingArmor;

/** The constructor for the Inventory and creates a new array list of items.
  @param maxWeight the maximum weight of the inventory that a player can carry at one time.
  */
	Inventory(int maxWeight){
		this.maxWeight = maxWeight;
		this.items = new ArrayList<Item>();
		
	}//end of inventory	

	/** A method that adds an item to the array list only if it's less than or equal to the max weight.
	  @param item could vary from a weapon or armor.
	  @return a boolean if item does exceed max weight along with an error message printed to the screen.
	  */
	public boolean add(Item item){
		int big = totalWeight();
		if(big + item.getWeight() <= maxWeight){
			this.items.add(item);
			return true;
		}//end of if
		System.out.println(" ");
		System.out.println(" You are carrying too much stuff");
		System.out.println(" ");
		return false;
	}//end of add

	/**
	  retrieves the total weight of the players collected items.
	  @return total returns the total weight.
	  */
	public int totalWeight(){
		int total = 0;
		for(int i = 0; i< items.size();i++){
			int bob = items.get(i).getWeight();
			total+= bob;
		}//end of for
		return total;
	}//end of total weight


	/**
	  A method that prints the items to the screen in a user friendly readable format.
	  */
	public void print(){

		for(int i =0; i< items.size();i++){
			System.out.println(" ");
			System.out.print(i+1);
			System.out.print("  " + items.get(i).toString());
		}//end of for


	}//end of print

	/**
	  A method that drops an item for the inventory which is an array list of items.
	  @throws IndexOutOfBoundsException if the player attempts to drop an item that is currently not equipped, an exception will be thrown. 
	  */
	public void drop(){
		Scanner bob = new Scanner(System.in);
		this.print();
		System.out.println(" ");
		System.out.println(" WHAT DO YE WANT REMOVED PUNY HUMAN" );
		System.out.println(" ");
		int choice = bob.nextInt();
		try{
			items.remove(choice - 1);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(" ");
                        System.out.println("what?? are you trying to drop air? you have nothing, your're broke");
                        System.out.println(" ");
		}
	}//end of drop

	/**
	  Equips a weapon that the player wants to carry and battle with throughout the game. If the inventory is empty, and exception is thrown.
	  @throws IndexOutOfBoundsException if the player tries to equip a weapon when the inventory is empty.
	  */
  	  public void equipWeapon(){
		Scanner tim = new Scanner(System.in);
		for(int i =0; i < items.size(); i++){
			if(items.get(i).getType() == ItemType.weapon){
				System.out.println(" ");
				System.out.print(i+1);
				System.out.print(" " + items.get(i).toString());
			}//end of if
		}//end of for
		System.out.println(" ");
		System.out.println(" WHAT METHOD OF DESTRUCTION WOULD YOU LIKE? ");
		System.out.println(" ");
		int wing = tim.nextInt();
		try{
			this.equippedWeapon = items.get(wing -1);//selects the number the user chooses but subtracts a number to match the array list position of chosesn thing
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(" ");
			System.out.println("not to be mean you spleef, but maybe you shoud pick up some items first");
			System.out.println(" ");
		}
	}//end of eqiupWeapon

	/**
	  A method that equips armor for the player to carry around with in the game and use in battles.
	  @throws IndexOutOfBoundsException if the inventory of armor is currently empty.
	  */
	public void equipArmor(){
		Scanner yop = new Scanner(System.in);
		for(int i = 0; i<items.size();i++){
			if(items.get(i).getType() == ItemType.armor){
				System.out.println(" ");
                                System.out.print(i+1);
                                System.out.print(" "+ items.get(i).toString());
			}//end of if
		}//end of for
		System.out.println(" ");
                System.out.println(" WHAT ARMOR OF SAVING GRACE WOULD YOU LIKE? ");
		System.out.println(" ");
		int yoop = yop.nextInt();
		try{
			this.equippedArmor = items.get(yoop -1);//selects the number the user chooses but subtracts a number to match the array list position of chosesn thing
		}
		catch(IndexOutOfBoundsException p){
			System.out.println(" ");
			System.out.println("it smells like broke in here. you don't have any armour");
			System.out.println(" ");
		}
	}//end of equipArmomr

	/** 
	 This method equips the player with the default weapon and armor.
	  */
	public void noobGear(){
		this.equippedWeapon = new Item(ItemType.weapon, "wet napkin", 1, 1, 10);
		this.equippedArmor = new Item(ItemType.armor, "diaper", 4, 3, 20);
	}

	/**
	 *this method is to give the player god level gear if they now a cheat code
	 */
	public void godGear(){
		this.equippedWeapon = new Item(ItemType.weapon, "SMOULDER FACE TECHNIQUE", 0 , 0, 999);
		this.equippedArmor = new Item(ItemType.armor, "SUAD'S JACKET", 0 , 990 , 999);
	}//end of godGear
	
	/**
	  A method that displays the current weapon to the screen.
	  @return the current weapon.
	  */
	public String currentWeapon(){
		return this.equippedWeapon.toString();
	}
	
	/**
	  A method that displays the current armor to the screen.
	  @return the current armor.
	  */
	public String currentArmor(){
		return this.equippedArmor.toString();
	}

	/**
	  A method that returns the current strength of the weapon.
	  @return the current strength.
	  */
	public int power(){ 
		return this.equippedWeapon.getPower();
	}//end of power

	/**
	  A method that returns the armor strength.
	  @return the strength of the armor.
	  */
	public int protection(){
	
		return this.equippedArmor.getPower();


	}//end of protections

	void save(PrintWriter pw){
		Item equipp = this.equippedWeapon;
		pw.println(equipp);
	}//end of save method

	void save2(PrintWriter pw){
		Item equipp = this.equippedArmor;
		pw.println(equipp);
	}//end of save2 method

	void save3(PrintWriter pw){
		for(int i =0; i< items.size();i++){
                        pw.println(" ");
                        pw.print(i+1);
                        pw.print("  " + items.get(i).toString());
                }//end of for loop
	}//end of save3 method





}//end of Inventory

