
/**
 * this item class is to set parameters for the item, the name wieght and value and strenght
 * there is a get wieth method that gets the wiertght 
 * and a get alue method that gets the value 
 * and a get name method that gets the name 
 * and a get type method that gets the type of the item
 * and a to string method that prints out the data into string 
 */
public class Item{
	
	private ItemType type;
	private String name;
	private int weight;
	private int value;
	private int strength;
	
	Item(ItemType type, String name, int weight, int value, int strength){
		this.type = type;
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.strength = strength;

	}//end of item
	
	public int getWeight(){
		return this.weight;
	}//end of get wieght

	public int getValue(){
		return this.value;
	}//end of get value

	public String getName(){
		return this.name;
	}//end of getname
	
	public ItemType getType(){
		return this.type;
	}//end of getType

	public String toString(){
		return name + "  : " + weight + " pounds " + value + " dollars  " + strength+ " Power.";
	}//end of toString

	public int getPower(){
		return strength;
	}//end of power 


}//end of Item
