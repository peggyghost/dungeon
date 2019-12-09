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
	public void blank(int yee){
		for(int i =0; i < yee ; i++){
			System.out.println(" ");
		}
	}//end of blank method

	/**
	 * this is the method that initiates the ari dream, it's a flash back that goes back in time that lets the uesr know what
	 * happend back in the past, your choices affects ari's stats
	 */
	public void ariDream(){
		Dreams.blank(100);		
		System.out.println("         Ari, what a time that was. We met in the land of BING BANG, not to be confused with BING BONG  ");
		System.out.println("         Everything was so nice back then");
	}//end of ariDream




}//end of Dreams class	
