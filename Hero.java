import java.util.Scanner;
import java.io.PrintWriter;

class Hero {
	public int health;
	public boolean isalive;
	private String name;
        private String Class;
	//private String ability;
	//private String Extraability;
	//private boolean Attack;
	//public boolean fight;	
//	void save(PrintWriter pw){
///		pw.println(name);
//		Hero.save(pw);
//	}










	Hero(String name, String Class){
		this.name = name;
		this.Class = Class;
		this.health = 100;
		this.isalive = true;
	//	 if (Class.equals("FratBoi")){
          //              this.ability = "Immunity";
	//		Enemy.damage = 0;
	//		health = 100;
          //      }
            //    else if(Class.equals("JucciBoi")){
              //          this.ability = "six abs";
	//		health = 200;
          //      }
            //    else if(Class.equals("NerdBoi")){
              //          this.ability = "Four Eyes";
		//	damage = (damage/damage+30)*100;
		//	health = 100;
//
  //              }
    //            else if(Class.equals("Arsalan")){
      //                 this.ability = "God";
	//	       health = 500;
	//	       damage = (damage/70)*100;
          //      }
	}
	public String name(){
		return name;
	}


	void save(PrintWriter pw){
                pw.println(name);
		pw.println(Class);
		pw.println(health);
		pw.println(isalive);

        }

	Hero(Scanner in){
		name = in.nextLine();
		Class = in.nextLine();
		health = in.nextInt();
		isalive = in.nextBoolean();

	}


	public void damage(int hit){//Hit was never initialized anywere hence I dont know if its going to work,
		//Like, how the fuck is the program going to know what hit does. It doesnt understand English.
		//Since Suad said its going to work, I am not going to say anything, I will investigate later.
		//Nvm after doing some research it makes sense.
		//
		//lol you head ass
		this.health -= hit;
	}
	
	public boolean alive(){// Check my parameters and the code in the method.
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

	public void flexonAri(){
		System.out.println(this.name + ":YOU'RE SO BOGUS! YOU SHOULD BE LIKE ME, A STRONG INDEPDENT SEXY MAN");
	}

	public void flexonGarret(){
		System.out.println(this.name + "I am SO glad I dumped you. Whew. Dodged a bullet with that one!");
	}
	

//	public String interact(int position){//please check my parameters again might have to change variables
//		if(enemy.position == hero.position){
//			System.out.println("OH BOY TIME TO BEAT SOME ASS");
//			fight = true;
//			return fight;
//		}
//		else {
//			System.out.println("NOBODY HOME EHH LETS MOVE ON");
//			fight = false;
//			return fight;
//		}
//	}

//	public void attack(boolean fight){//Double Check might have to change variables
//		if(fight = true){
//			Attack = true;
//			Enemy.health = Enemy.health - Hero.weapon;
//		}
//		else{
//			Attack = false;
//		}
//	}



	//public Item StartingWeapon(Itemtype.weapon){
		//Might have to make a separate Item Generator class just for weapons. I dont know how to give the hero
		//just the weapon from the Itemgenerator.

	public void Soy(){
		for(int i = 0; i < 1; i++){
			System.out.println("Lets do this");
		}
	}
		

	}
	
 		


			

	


	    

