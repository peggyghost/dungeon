import java.util.Scanner;
import java.io.PrintWriter;

class Hero extends Character{
	public int health;
	public boolean isalive;
	private String name;
	private String Class;
	Item weapon;

	Hero(String name, int health, String Class){
		super(name, health);
		this.name = name;
		this.Class = Class;
		this.health = 100;
		this.isalive = true;
		this.weapon = weapon;
	}
	public String getname(){
		return name;
	}


	void save(PrintWriter pw){

                pw.println(name);
		pw.println(Class);
		pw.println(health);
		pw.println(isalive);

        }



	public void damage(int hit){
		this.health -= hit;
	}

	public boolean isAlive(){// Check my parameters and the code in the method.
		if(this.health > 0){
			return true;
		}
		else{
			return false;
		}
	}
	public void kill(){
		this.health = 0;
	}

	public void girlTaunt(){
		System.out.println(this.name + ":YOU'RE SO BOGUS! YOU SHOULD BE LIKE ME, A STRONG INDEPDENT SEXY MAN");
	}

	public void boyTaunt(){
		System.out.println(this.name + "I am SO glad I dumped you. Whew. Dodged a bullet with that one!");
	}

	public void Soy(){
		for(int i = 0; i < 1; i++){
			System.out.println("Lets do this");
		}
	}

	 public String equippedWeapon(){
                return this.weapon.toString();
        }//ending bracket for equip

	public int power(){
                return this.weapon.getPower();
                //return health - damage;
        }
	
	public int health(){
                return this.health;
        }



}











