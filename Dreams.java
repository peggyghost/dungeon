import java.util.Scanner;

public class Dreams{
	
	int sad;

	/**
	 *constructor that makes a sadness meter basically a number variable for the flashbacks
	 */
	Dreams(){
		this.sad = 0;
	}
	/**
	 *this method is to return the meter value in intigers  on how sad the dream was
	 @return sad 
	 */
	public int getSadness(){
		return this.sad;
	}//end of getsadness

	/**
	 *this method is to print out a pretty picture
	 */
	public void scene(){
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("     _");
		System.out.println("    |_|");
		System.out.println("                           __");
		System.out.println("                          |  |");
		System.out.println("       ``            __   |  |              ``");
		System.out.println("    ``   ``         |  |  |  |__               ``");
		System.out.println("                  __|  |__|  |  |");
		System.out.println("                 |  |  |  |  |  |");
		System.out.println("                 |  |  |  |  |  |__");
		System.out.println("_________________|  |  |  |  |  |  |_______________________");
		System.out.println(" ");
		System.out.println("     ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("          ~~~~~~~~~~~~~~~~~~~~~~~~~                    ");
		System.out.println("        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}//end of scene

	/**
	 * this method is to print out a black space
	 */
	public static void blank(int yee){
		for(int i =0; i < yee ; i++){
			System.out.println(" ");
		}
	}//end of blank method

	/**
	 * this is the method that initiates the ari dream, it's a flash back that goes back in time that lets the uesr know what
	 * happend back in the past, your choices affects ari's stats
	 */
	public void ariDream(){
		Scanner bob = new Scanner(System.in);
		Dreams.blank(100);		
		System.out.println("         Ari, what a time that was. We met in the land of BING BANG, not to be confused with BING BONG  ");
		System.out.println("         Everything was so nice back then, what happend???");
		String blip = bob.next();
		Dreams.blank(2);
		System.out.println("                              7 years ago ");
		System.out.println(" ");
		blip = bob.next();
		System.out.println("        ");
		System.out.println("        Ari and i were sitting next to a tree, a beutiful tree, it grows curry, such delicious curry");
		System.out.println("        Ari's head rested on my shoulder, we were both are comfortable, we felt the warm breeze of the BING BANG");
		System.out.println("        Did i punched Ari? or gave her a kiss      'punch'   'kiss'");
		String choice = bob.next();
		if(choice.equals("kiss")){
			this.sad++;
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("        oh yeah i reached in for a kiss, but i accidently missed and kissed her dad instead");
			System.out.println("        ");
			System.out.println("        Ari:  Hey what the heck?!!?! That's my dad!!");
			System.out.println("        ");
			System.out.println("        Man, that was really akward. i had to do somthing to make it up");
			System.out.println("        Did i punched Ari? or gave her some flowers?   'punch'  'flowers'");
			System.out.println("        ");
			choice = bob.next();
			if(choice.equals("punch")){
				System.out.println("        Oh yeah i punched Ari, but i was so weak/small body and Ari was such a strong woman that ");
				System.out.println("        It didn't hurt whatsoever and she though i were flirting with her");
				System.out.println("        ");
				System.out.println("        Ari:  oooh i like a man that can consensually take charge");
				System.out.println("        Ari:  You remind me of Roy Paino; I love that man, just like i love you");
				System.out.println("        ");
				System.out.println("        That's a very serious statment she just made, i've only known her for a week and Roy Paino is ");
				System.out.println("        almost as strong as michael jackson, which is pretty lit if you ask me.");
				System.out.println("        Did i tell her to slow things down? or felt the same tell her tospeed it up?   'slow'   'fast'");
				choice = bob.next();
				if(choice.equals("slow")){
					this.sad++;
					System.out.println("        ");
					System.out.println("        that's right, i told  her i  want to take things slow since our astrology signs don't match");
					System.out.println("        i also gave her some twinkies 2 days ago and now my house is on fire and my cat is missing");
					System.out.println("        ");
					System.out.println("        Ari:  SLOW ? SLOW!!??? AFTER ALL WE'VE BEEN THROUGH? GOD I CAN'T BELIVE YOU ");
					System.out.println("        Ari:  I don't think you really care about our relationship.... sad face");
					System.out.println("        ");
					Dreams.blank(100);
					System.out.println("        So that's what happend huh? She's probably in the room i'm about to go into... ");
					System.out.println("        Jeff from HR told me she went crazy, she just roams the area, doging and weaving anything that come by");
					System.out.println("        If i want to save this land i need to defeat her before she steals more curry");
					Dreams.blank(100);
				}//end of slow if
			}//end of punch if
			else if(choice.equals("flowers")){
				
			}//end of flowers
		}//end of kiss choice
	}//end of ariDream




}//end of Dreams class	
