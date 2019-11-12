import java.util.Random;

/**
 * this clas to generate random items for the inventory,
 * it generates a random nuber that goes through cases for said random numbver, it returns
 * the item and it's data that acompanied with it
 */
public class ItemGenerator{


public static Item generate(){
                Random fate = new Random();
                int gen = fate.nextInt(10);
                switch(gen){
                        case 0:
				gen = fate.nextInt(10);
				return new Item(ItemType.weapon, "Divorce Papers",1000 , 1 , 70);
                                
                        case 1:
				gen = fate.nextInt(10);
				return new Item(ItemType.weapon, "Plan B",999, 2, 80);
                                
                        case 2:
				gen = fate.nextInt(10);
				return new Item(ItemType.weapon, "A Gun That Gives you Deppresion", 1001, 20, 99);
                                
                        case 3:
				gen = fate.nextInt(10);
				return new Item(ItemType.weapon, "A Spork", 1, 3, 21);
                                
                        case 4:
				gen = fate.nextInt(10);
				return new Item(ItemType.armor,"Gucci Jacket", 30,10,60);
				
			case 5: 
				gen = fate.nextInt(10);
				return new Item(ItemType.armor,"Timbs", 900, 1,50);
				
			case 6:
				gen = fate.nextInt(10);
				return new Item(ItemType.armor,"Door", 500, 20, 30);
				
			case 7:
				gen = fate.nextInt(10);
				return new Item(ItemType.other,"twinkies", 0 , 1, 0);
				
			case 8:
				gen = fate.nextInt(10);
				return new Item(ItemType.other,"Paige's code", 9987343, 12, 12);
				
			case 9:
				gen = fate.nextInt(10);
				return new Item(ItemType.other, "suad's diary",234 ,23,234);
			
		}//end of switch
		return new Item(ItemType.other,"Deez nuts, gottem", 420, 69, 0);	
        }//end of generate
}//end of class
