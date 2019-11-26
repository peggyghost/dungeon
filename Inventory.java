import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * this is an inventory class that has the constructuro that makes the array to holld items and a max weight to 
 * make a limit on how much can be held, 
 * there is a method that adds an item that calls the itme generator to get an item to be added to the inventoryu
 * there is a mthod that gets the total weight that gets the current total wieght 
 * there is a method that prints out the inventory
 * there is a method that drops an item it prints out the inventory and then asks which one the player would drop
 * then there is a method that eqips weapons and armer by printing out the inventory
 * and then asking wihch weapopn or armor they want to equp it only shows the type of the item that coresponds 
 * with the method
 */
public class Inventory{

	private ArrayList<Item> items;
	private int maxWeight;
	private Item equippedWeapon;
	private Item equippedArmor;
	private Item StartingWeapon;
	private Item StartingArmor;

	Inventory(int maxWeight){
		this.maxWeight = maxWeight;
		this.items = new ArrayList<Item>();
		
	}//end of inventory	

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

	public int totalWeight(){
		int total = 0;
		for(int i = 0; i< items.size();i++){
			int bob = items.get(i).getWeight();
			total+= bob;
		}//end of for
		return total;
	}//end of total weight

	public void print(){

		for(int i =0; i< items.size();i++){
			System.out.println(" ");
			System.out.print(i+1);
			System.out.print("  " + items.get(i).toString());
		}//end of for


	}//end of print

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
			this.equippedWeapon = items.get(wing -1);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(" ");
			System.out.println("not to be mean you spleef, but maybe you shoud pick up some items first");
			System.out.println(" ");
		}
	}//end of eqiupWeapon

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
			this.equippedArmor = items.get(yoop -1);
		}
		catch(IndexOutOfBoundsException p){
			System.out.println(" ");
			System.out.println("it smells like broke in here. you don't have any armour");
			System.out.println(" ");
		}
	}//end of equipArmomr

	//this gives out default gear
	public void noobGear(){
		this.equippedWeapon = new Item(ItemType.weapon, "wet napkin", 1, 1, 10);
		this.equippedArmor = new Item(ItemType.weapon, "diaper", 4, 3, 20);
	}
	
	
	public String currentWeapon(){
		return this.equippedWeapon.toString();
	}
	
	public String currentArmor(){
		return this.equippedArmor.toString();
	}

	public int power(){ //returns strength of the weapon
		return this.equippedWeapon.getPower();
	}//end of power

	public int protection(){//returns armor strength
	
		return this.equippedArmor.getPower();


	}//end of protections



}//end of Inventory

