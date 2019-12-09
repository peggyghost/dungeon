import java.util.*;
import java.io.PrintWriter;




class Enemy extends Character {

	String name;
	int health;
	Item weapon;


	public  Enemy(String name, int health, Item Weapon) {
		super(name, health);
		this.weapon = Weapon;
		this.name = name;
		this.health = health;
	}

	public int health(){
		return this.health;
	}

	public boolean isAlive() {
		if (this.health <= 0) {
			return false;
		}
		return true;
	}

	public void damage(int hit){
		this.health -= hit;
	}

	public int power(){
		return this.weapon.getPower();
		//return health - damage;
	}

	public String equippedWeapon(){
		return this.weapon.toString();
	}//ending bracket for equip

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
	public String getname(){
		return name;
	}


	void save(PrintWriter pw){
		pw.println(health);
	}

	
	public void kill(){
                this.health = 0;
        }



}
