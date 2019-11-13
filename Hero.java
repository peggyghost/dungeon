import java.util.Scanner;

class Hero {
	public int health;
	public boolean isalive;
	private String name;
        private String Class;
	
	


	Hero(String name, String Class){
		this.name = name;
		this.Class = Class;
		this.health = 100;
		this.isalive = true;

	}
	public String name(){
		return name;
	}
	public void damage(int hit){
		this.health -= hit;
	}
	
	public boolean alive(){
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
	


	public void Soy(){
		for(int i = 0; i < 1; i++){
			System.out.println("Lets do this");
		}
	}
		

	}
	
 		


			

	


	    

