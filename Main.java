import java.util.*;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
/**
 * a main class that makes a scanner and a inventory object
 * it prints out the options and then asks what the player wants to do
 * each option utilizes the methods in the other classes, it quites if you press 6 
 * it's in a do while so it never stops unless you wnat to stop
 */
public class Main{
	public static void main(String[] args){
		Scanner bob = new Scanner(System.in);
		Inventory stuff = new Inventory(100000000);	
		Room room = new Room(20,20);
		Room room2 = new Room(20,20);
		Room room3 = new Room(20,20);

		System.out.println(" ");
		System.out.println("                    ~  WELCOME TO ONE ROOM DUNGEON GAME ~");
		System.out.println("      ");
		System.out.println("                 YOU, THE HERO HAS ENTERED THE DEMON'S KINGS ");
		System.out.println("                 CASTLE. SADLY, HIS CASTLE ONLY HAS ONE ROOM"); 
		System.out.println("               BECAUSE HE HAS A SMALL BRAIN AND GOT RIPPED OFF");
		System.out.println("            BY THE MOST FAMOUS AND HANDSOME CON-ARTIST, SUAD PARVEZ.");
		System.out.println("        YOU ARE HERE TO KILL THE DEMON KING, GARRETTE DAYKWON AND ARI.");
		System.out.println("       BECAUSE THEY HAVE STOLEN ALL THE CURRY IN THE LAND OF 'SCHOP SCHOP' ");
		System.out.println("              RESTORE THIS LANDS GLORY AND DEFEAT THE DEMON KING!");
		System.out.println("   ");
		System.out.println("    ");
		System.out.println(" How to play:");
		System.out.println("              You, the Hero, will be represented on the board by the '+' symbol.");
		System.out.println("              Your enemy, the Demon King Garret, will be represented by the ':(' symbol.");
		System.out.println("              He is known for being thirsty and pacing back and forth. Watch out, he is tough as fudge");
		System.out.println("              Ari THE WOMAN will be represented by the '?' symbol.");	
		System.out.println("              She has gone crazy and roams aimlessly around the room, you may need to chase her.");
		System.out.println("       ");	
		System.out.println("              Move throughout the board collecting as many items '<$>' as you can to defeat the game.");
		System.out.println("              If you do happen to run into either enemy, you must dual it out to see who wins!");
		System.out.println("              Preferably you please, bob already went in there and we have no idea where he is..");
		System.out.println("    ");
		System.out.println("                                 Press 'w' to move UP. ");
		System.out.println("                                 Press 's' to move DOWN. ");
		System.out.println("                                 Press 'a' to move LEFT. ");
		System.out.println("                                 Press 'd' to move RIGHT. ");
		System.out.println("                                 Press 'i' to access inventroy ");
		System.out.println("                                 Press 'q' to activate not alive mode");
		System.out.println("  ");

		System.out.println(" ");
		System.out.println("                       WHAT IS YOUR NAME HERO??");
		System.out.println(" ");
		System.out.print("                                  ");
		String Name = bob.next();

		System.out.println(" ");
		System.out.println("                          WHAT IS YOUR CLASS??");
		System.out.println("              (FratBoi)  (JucciBoi)  (NerdBoi)  (Arsalan) ");
		System.out.println(" ");
		System.out.print("                                    ");
		String Class = bob.next();

		Hero bro = new Hero(Name,Class);
		stuff.noobGear();//to give the hero a default gear weapon and armour


		System.out.println(" ");
		System.out.println("             Remember " + bro.name() + ", to see the instrucitons, press 'p'.");
		System.out.println(" ");
		System.out.println("           Now remember not to ask any questions becuase this is a video game");
		System.out.println("   ");
		System.out.println("   ");

		Enemy Garret =new Enemy("Garret THE DEMON KING", new Item(ItemType.weapon,"BasketBall", 4, 70, 70), 200);
		Enemy Ari = new Enemy("Ari THE WOMAN", new Item(ItemType.weapon,"Cellphone", 345,543,60),200);

		String input = " ";

		room.create();

		while(bro.alive()){//keeps going until player is dead 
			System.out.println(" ");
			if(Garret.isAlive() && Ari.isAlive()){
				room.print();//prints out the room
			}
			else if(Garret.isAlive() && !Ari.isAlive()){
				room.printG();
			}
			else if(!Garret.isAlive() && Ari.isAlive()){
				room.printA();
			}

			System.out.println(" ");
			System.out.println("              ");
			System.out.print("                      ");
			input = bob.next();//input from user

			if(input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")){
				room.MOVE(input);//to move the character in the room

				if(room.garretFight() && Garret.isAlive()){
					System.out.println(" WHAT? YOUR FACING " + Garret.getname() + "!! YOU BETTER WATCH OUT.");
					System.out.println(" HE WAS LOOKING AT YOU THROUGH HIS TELESCOPE BEFORE YOU CAME HERE!");
					System.out.println(" AND HE LIKED WHAT HE SAW. PROBABLY ENOUGH TO WANT A BABY WITH YOU!");
					System.out.println(" DON'T ASK HOW I KNOW THAT WE DON'T HAVE TIME");
					System.out.println(" ");
					while(bro.alive() && Garret.isAlive()){
						//enemy damage - the armor is the damage the enemy can deal
						int enemyhit = Garret.power() - stuff.protection();
						//your weapons damage is the damage you can do
						int brohit = stuff.power();
						System.out.println("Press 'k' to attack");
						String attack = bob.next();
						if(attack.equals("k")){
							//the enemy gets damaged by the hero's hit
							Garret.damage(brohit);//the hero's hit is in the parameter
							System.out.println(" ");
							System.out.println("You attacked Garret with your " + stuff.currentWeapon() + ". You did " + brohit + " damage to him!");
							System.out.println(" His health is now " + Garret.health());
							System.out.println(" ");
						}
						else{
							System.out.println(" ");
							System.out.println("your so dumb that wasn't the letter k");
							System.out.println("you deserve to perish!");
							System.out.println(" ");
							bro.kill();
						}
						if(Garret.isAlive() && bro.alive()){
							bro.damage(enemyhit);
							System.out.println(" ");
							System.out.println("Garret hit you with his " + Garret.equippedWeapon() + ". It did " + enemyhit + " damage!");
							System.out.println(" ");
						}
					}//end of while fight
					if(!bro.alive()){
						System.out.println(" ");
						System.out.println(bro.name() + "!?!?!?! YOU CAN'T DIE NOW!!!");
						for(int i = 0 ; i < 6; i++){
							System.out.println("AAAAAAHHHHHHHHHHHHHHH");
						}
						Garret.boyTaunt();
					}//end of losing message
					if(bro.alive()){
						System.out.println(" ");
						System.out.println(" You have defeated " + Garret.getname() + "!!!!!");
						System.out.println(" ");
						bro.flexonGarret();
					}
				}//end of if for garret interaction  interaction

				if(room.ariFight() && Ari.isAlive()){
					System.out.println(" ");
					System.out.println(" HOLY COW IT'S " + Ari.getname() + "!! SHE IS WELL KNOWN FOR COMPLAINING");
					System.out.println(" NO MAN CAN HANDLE THE PURE TEENAGE DRAMA SHE IS CAPABLE OF SUMMONING");
					System.out.println(" IF YOU DON'T BEAT HER QUICK SHE'LL DROWN YOU IN BORING SPEECHES");
					System.out.println(" ");
					while(bro.alive() && Ari.isAlive()){
						//enemy damage - the armor is the damage the enemy can deal
						int enemyhit = Ari.power() - stuff.protection();
						//your weapons damage is the damage you can do
						int brohit = stuff.power();
						System.out.println(" ");
						System.out.println("Press 'k' to attack");
						System.out.println(" ");
						String attack = bob.next();
						if(attack.equals("k")){
							//the enemy gets damaged by the hero's hit
							Ari.damage(brohit);//the hero's hit is in the parameter
							System.out.println(" ");
							System.out.println("You attacked " + Ari.getname() + "  with your " + stuff.currentWeapon() + ". You did " + brohit + " damage to her!");
							System.out.println(" Her health is now " + Ari.health());
							System.out.println(" ");
						}
						else{
							System.out.println(" ");
							System.out.println("your so dumb that wasn't the letter k");
							System.out.println("you deserve to perish");
							System.out.println(" ");
							bro.kill();
						}
						if(Ari.isAlive()&& bro.alive()){
							bro.damage(enemyhit);
							System.out.println(" ");
							System.out.println("Ari hit you with her " + Ari.equippedWeapon() + ". It did " + enemyhit + " damage!");
							Ari.girlTaunt();
							System.out.println(" ");
						}
						System.out.println(" ");
						bro.flexonAri();
					}//end of while fight
					if(!bro.alive()){
						System.out.println(" ");
						System.out.println(bro.name() + "!?!?!?! YOU CAN'T DIE NOW!!!");
						for(int i = 0 ; i < 8; i++){
							System.out.println("AAAAAAHHHHHHHHHHHHHHH");
						}
					}//end of losing message
					if(bro.alive()){
						System.out.println(" ");
						System.out.println(" You have defeated " + Ari.getname() + "!!!!!");
						System.out.println(" ");
						bro.flexonAri();
					}
				}//end of if for ari fight interaction

				if(Garret.isAlive()){
					room.enemymoveGarret();
				}
				if(Ari.isAlive()){
					room.enemymoveAri();
				}	
			}//end of if for movement

			if(input.equals("p")){
				if(Garret.isAlive()){
					room.enemymoveGarret();
				}
				if(Ari.isAlive()){
					room.enemymoveAri();
				}
				System.out.println(" ");
				System.out.println(" How to play:");
				System.out.println("                You, the Hero, will be represented on the board by the '+' symbol.");
				System.out.println("                Your enemy, the Demon King Garret, will be represented by the ':(' symbol.");
				System.out.println("                Ari THE WOMAN will be represented by the '?' symbol.");
				System.out.println("       ");
				System.out.println("                Move throughout the board collecting as many items '<$>' as you can to defeat the game.");
				System.out.println("                If you do happen to run into either enemy, you must dual it out to see  who wins!");
				System.out.println("    ");
				System.out.println("                                   Press 'w' to move UP. ");
				System.out.println("                                   Press 's' to move DOWN. ");
				System.out.println("                                   Press 'a' to move LEFT. ");
				System.out.println("                                   Press 'd' to move RIGHT. ");
				System.out.println("                                   Press 'i' to access inventroy ");
				System.out.println("                                   Press 'q' to activate not alive mode");
				System.out.println(" ");
			}//end of if for printing controls

			if(input.equals("q")){
				bro.kill();
			}//end of if for quit

			if(input.equals("i")){
				boolean go = true;
				if(Garret.isAlive()){
					room3.create2.enemymoveGarret();
				}
				if(Ari.isAlive()){
					room2.create3.enemymoveAri();
				}
				do{
					System.out.println(" ");
					System.out.println(" 1. Print the inventory");
					System.out.println(" 2. Drop an item");
					System.out.println(" 3. Equip weapon");
					System.out.println(" 4. Equip armor");
					System.out.println(" 5. quit");
					System.out.println(" ");
					int choice = bob.nextInt();
					switch(choice){
						case 1://print inventory
							stuff.print();
							break;
							//case 2://add random item
							//	Item thing = ItemGenerator.generate();
							//	stuff.add(thing);
							//	break;
						case 2://drop item
							stuff.drop();	
							break;
						case 3://equp weapon
							stuff.equipWeapon();
							break;
						case 4://equp armor
							stuff.equipArmor();
							break;
						case 5://exit
							try{
							FileOutputStream file = new FileOutputStream("data.txt");
							PrintWriter pw = new PrintWriter(file);
							bro.save(pw);
							pw.close();
							}catch(FileNotFoundException e){
								System.out.println("not found");
							}
							go = false;
							break;
					
					}//end of swtich
				}while(go);//end of do while
			}//end of if of inventory choice


			if(room.itemonfloor()){
				stuff.add(room.pickup());
			}//end of if for checking if item is on the floor.

			if(!Garret.isAlive() && !Ari.isAlive()){
				for(int i = 0 ; i < 5 ; i++){
					System.out.println("     YYYYYYYYAAAAAAAAAAAAAAAAAAAAAAAAYYYYYYYYYYY");
					System.out.println("                     YOU HAVE WON ");
				}
				System.out.println(" ");
				System.out.println("      YOU HAVE DONE IT, YOU HAVE KILLED THE DEMON KING AND HER QUEEN");
				System.out.println("      The curry can now be restored to the land of 'SCHOP SCHOP'");
				System.out.println("             Now you can finally rest in peace and die. ");
				System.out.println("                     Are you ready to die? ");
				System.out.println(" ");
				String response = bob.next();
				System.out.println(" ");
				System.out.println("       What's that?? I can't hear you because I am a virtual machine. Oh well.. lolz You probably said 'yes' ");
				System.out.println("      Thank you for your service " + bro.name() + ". Good game.");
				System.out.println(" ");
				bro.kill();
			}//end of if for winning message 


		}//end of while alive check
	}//end of main

}//end of Main
