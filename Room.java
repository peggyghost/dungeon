import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
class Room implements Serializable{

	private static final long serialVersionUid = 1L;
	
	private String[][] area;
	private int[][] position;
	private int[][] Garret;
	private int[][] Ari;
	private Item[][] Items;
	private Random fate = new Random();

	Room(){
		this.area = new String[20][20];
		this.position = new int[20][20];
		this.Garret = new int[20][20];
		this.Ari = new int[20][20];
		this.Items = new Item[20][20];
	}//end of room constructor
	
	/*	public static void Rooms(String[][] area, int[][] position, int[][] Garret, int[][] Ari, Item[][] Items){
		this.area = area;
		this.position = position;
		this.Garret = Garret;
		this.Ari = Ari;
		this.Items = Items;
	}

	//PAIGES ADDED CODE

	public int[][] getPosition(){
		return position;
	}

	public String[][] getArea(){
		return area;
	}

	public int[][] getGarret(){
		return Garret[i][p];
	}

	public int[][] getAri(){
		return Ari;
	}

	public Item[][] getItem(){
		return Items;
	}*/

	//get position method  for x and y

	public void create(){
		//creating board to keep track of player postion with 1 or 0. 0 if not there 1 if they are there
		for(int i = 0; i <this.position.length; i++){
			for(int p = 0; p < this.position.length; p++){
				this.position[i][p] = 0;//filling with zero
			}
		}//end of position making board
		this.position[1][1] = 1;//putting player in this position

		//creating board to keep track of garret
		for(int i = 0; i <this.Garret.length; i++){
                        for(int p = 0; p < this.Garret.length; p++){
                                this.Garret[i][p] = 0;//filling with zero
                        }
                }//end of garret board
		this.Garret[18][10] = 1;//putts garret there

		//creating board to keep track of ari
		for(int i = 0; i <this.Ari.length; i++){
                        for(int p = 0; p < this.Ari.length; p++){
                                this.Ari[i][p] = 0;//filling with zero
                        }
                }
		this.Ari[7][11] = 1;//putts ari there

		//makes board that tells if item is there
		for(int i = 0; i <this.Items.length; i++){
                        for(int p = 0; p < this.Items.length; p++){
                                this.Items[i][p] = null;//filling with null
                        }
                }//end of filling board that has items

		//makes border of room
		for(int i = 0; i < this.area.length; i++){
			for(int p = 0; p<this.area.length; p++){
				if(i==0){
					this.area[i][p] = "[ ]";
				}
				else if (p==0 || p==19){
					this.area[i][p] = "[ ]";
				}
				else if(i==19){
					this.area[i][p] = "[ ]";
				}
				else{
				this.area[i][p] = "   ";
				}
			}//end of innner for
		}//end of outter for
		for(int i = 4; i< 5 ; i++){
			for(int p = 4; p < 7; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 4; i< 5 ; i++){
                        for(int p = 4; p < 7; p++){
                                this.area[p][i] = "[ ]";
                        }
      		}
		for(int i = 7; i< 8 ; i++){
           		 for(int p = 2; p < 7; p++){
                		this.area[i][p] = "[ ]";
            		}
        	}
        	for(int i = 17; i< 18 ; i++){
            		for(int p = 13; p < 17; p++){
                		this.area[i][p] = "[ ]";
            		}	
        	}
        	for(int i = 14; i< 15 ; i++){
            		for(int p = 13; p < 17; p++){
                		this.area[p][i] = "[ ]";
            		}	
        	}	
        	for(int i = 11; i< 12 ; i++){
            		for(int p = 10; p < 17; p++){
                		this.area[i][p] = "[ ]";
            		}
        	}
        	for(int i = 15; i< 16 ; i++){
            		for(int p = 3; p < 6; p++){
                		this.area[i][p] = "[ ]";
            		}
        	}
        	for(int i = 16; i< 17 ; i++){
            		for(int p = 6; p < 13; p++){
                		this.area[p][i] = "[ ]";
            		}
        	}
        	for(int i = 12; i< 13 ; i++){
            		for(int p = 5; p < 10; p++){
                		this.area[i][p] = "[ ]";
            		}
			System.out.println("  ");
        	}//end of for that creates walls	
		
		//for loop that distributes items
		int y = 0;
		int x = 0;
		for(int i = 0;i<10;i++){
			Item thing = ItemGenerator.generate();//making an item
			boolean good = false;
			while(!good){//makes coordates until there is nothing in the way
				y = fate.nextInt(20);//getting coordiantaes 
				x = fate.nextInt(20);
				if(this.Items[y][x]==null && this.area[y][x] != "[ ]"){
					good = true;
				}//end of if
				else{ 
					good = false;
				}
			}//end of while
			Items[y][x] = thing;
		}//end of for that distributes items on board

	}//end of create
	
	public boolean garretFight(){
		int XG = 0;
                int YG = 0;
                int Xyou = 1;
                int Yyou = 1;
                for(int i = 0 ; i < this.Garret.length;i++){
                        for(int p = 0; p < this.Garret.length;p++){
                                if(this.Garret[i][p] == 1){
                                        YG = i;
                                        XG = p;
                                }
                                if(this.position[i][p] == 1){
                                        Yyou = i;
                                        Xyou = p;
                                }
                        }
                }//end of outter for
                if(YG==Yyou && XG==Xyou){
                        return true;
                }
                return false;
	}//end of garretFight

	public boolean ariFight(){
		int Xari = 0;
		int Yari = 0;
		int Xyou = 1;
		int Yyou = 1;
		for(int i = 0 ; i < this.Ari.length;i++){
			for(int p = 0; p < this.Ari.length;p++){
				if(this.Ari[i][p] == 1){
					Yari = i;
					Xari = p;
				}
				if(this.position[i][p] == 1){
					Yyou = i;
					Xyou = p;
				}
			}
		}//end of outter for
		if(Yari==Yyou && Xari==Xyou){
			return true;
		}
		return false;
	}//end of ariFight

	public boolean itemonfloor(){
		int XI = 0;
                int YI = 0;
                int Xyou = 1;
                int Yyou = 1;
                for(int i = 0 ; i < this.Items.length;i++){
                        for(int p = 0; p < this.Items.length;p++){
                                if(this.Items[i][p] != null && this.position[i][p] == 1){
                                        YI = i;
                                        XI = p;
					Yyou = i;
					Xyou = p;
                                }
                        }
                }//end of outter for
                if(YI==Yyou && XI==Xyou){
                        return true;
                }
                return false;
	}//end of itemonfloor

	private int count =0;
	public void enemymoveGarret(){
		int YEG = 0;
                int XEG = 0;
		int[] turns = new int[]{0,0,0,0,0,2,1,1,1,1,1,3};
                for(int i = 0 ; i < this.Garret.length;i++){
                        for(int p = 0; p < this.Garret.length;p++){
                                if(this.Garret[i][p] == 1){
                                        YEG = i;
                                        XEG = p;
                                }
                        }
                }
                //int move = fate.nextInt(4);// 0 is left, 1 is right , 2 is up , 3 is down
		
		int move = turns[count];
                switch(move){//first block is up and down second block is left and right
                        case 0:
                                if(this.area[YEG][XEG-1] != "[ ]"){
                                        this.Garret[YEG][XEG-1] = 1;//to turn left
                                        this.Garret[YEG][XEG] = 0;
					count++;
					if(count == 12){
						count = 0;
					}
                                }
                                break;
                        case 1:
                                if(this.area[YEG][XEG+1] != "[ ]"){
                                        this.Garret[YEG][XEG+1] = 1;//to turn right
                                        this.Garret[YEG][XEG] = 0;
					count++;
                                        if(count == 12){
                                                count = 0;
                                        }
                                }
                                break;
                        case 2:
                                if(this.area[YEG-1][XEG] != "[ ]"){
                                        this.Garret[YEG-1][XEG] = 1;//to turn up
                                        this.Garret[YEG][XEG] = 0;
					count++;
                                        if(count == 12){
                                                count = 0;
                                        }
                                }
                                break;
                        case 3:
                                if(this.area[YEG+1][XEG] != "[ ]"){
                                        this.Garret[YEG+1][XEG] = 1;//to turn down
                                        this.Garret[YEG][XEG] = 0;
					count++;
                                        if(count == 12){
                                                count = 0;
                                        }
                                }
                                break;
                }//end of switch	
	}//end bracket for enemy move
	
	public void enemymoveAri(){
		int YEari = 0;
		int XEari = 0;
		for(int i = 0 ; i < this.Ari.length;i++){
                        for(int p = 0; p < this.Ari.length;p++){
                                if(this.Ari[i][p] == 1){
                                        YEari = i;
                                        XEari = p;
                                }
			}
		}
		int move = fate.nextInt(4);// 0 is left, 1 is right , 2 is up , 3 is down
		switch(move){//first block is up and down second block is left and right
			case 0:
				if(this.area[YEari][XEari-1] != "[ ]"){
					this.Ari[YEari][XEari-1] = 1;//to turn left
					this.Ari[YEari][XEari] = 0;
				}
				break;
			case 1:
				if(this.area[YEari][XEari+1] != "[ ]"){
                                        this.Ari[YEari][XEari+1] = 1;//to turn right
                                	this.Ari[YEari][XEari] = 0;
				}
                                break; 
			case 2:
				if(this.area[YEari-1][XEari] != "[ ]"){
                                        this.Ari[YEari-1][XEari] = 1;//to turn up
                                	this.Ari[YEari][XEari] = 0;
				}
                                break;
			case 3:
				if(this.area[YEari+1][XEari] != "[ ]"){
                                        this.Ari[YEari +1][XEari] = 1;//to turn down
                                	this.Ari[YEari][XEari] = 0;
				}
                                break;
		}//end of switch
	}//end of anemy move ari

	public Item pickup(){
		for(int i= 0; i< this.Items.length;i++){
			for(int p = 0; p < this.Items.length; p++){
				if(this.Items[i][p] != null && this.position[i][p] == 1){
					Item loot = Items[i][p];
					Items[i][p] = null;
					return loot;
				}
			}
		}
		return new Item(ItemType.other, "dust", 0,0,0);
	}//end of pickup

	public void MOVE(String input){
		int YM=0;
		int XM=0;
		for(int i = 0; i<this.position.length;i++){
			for(int p =0; p<this.position.length;p++){
				if(this.position[i][p] == 1){
					YM = i;
					XM = p;
//					System.out.println("i is " + i);
//					System.out.println("P is " + p);
//					System.out.println("YM is " + YM);
//					System.out.println("XM is " + XM);
				}
			}
		}
		switch(input){//first block is up and down second block is left and right
                        case "a":
                                if(this.area[YM][XM-1] != "[ ]"){
                                        this.position[YM][XM-1] = 1;//to turn left
                                        this.position[YM][XM] = 0;
//					System.out.println("new YM is " + YM);
  //                                      System.out.println("new XM is " + XM);
                                }
                                break;
                        case "d":
                                if(this.area[YM][XM+1] != "[ ]"){
                                        this.position[YM][XM+1] = 1;//to turn right
                                        this.position[YM][XM] = 0;
//					System.out.println("new YM is " + YM);
  //                                      System.out.println("new XM is " + XM);
                                }
                                break;
                        case "w":
                                if(this.area[YM-1][XM] != "[ ]"){
                                        this.position[YM-1][XM] = 1;//to turn up
                                        this.position[YM][XM] = 0;
//					System.out.println("new YM is " + YM);
  //                                      System.out.println("new XM is " + XM);
                                }
                                break;
                        case "s":
                                if(this.area[YM+1][XM] != "[ ]"){
                                        this.position[YM+1][XM] = 1;//to turn down
                                        this.position[YM][XM] = 0;
//					System.out.println("new YM is " + YM);
//                                        System.out.println("new XM is " + XM);
                                }
                                break;
                }//end of switch
	}//end of move

	public void printG(){
		for(int i = 0; i < this.area.length;i++){
                        System.out.println(" ");
                        System.out.print("                       ");
                        for(int p = 0 ; p < this.area.length; p++){
                                if(this.Garret[i][p] == 1){
                                        System.out.print(":( ");
                                }
                                else if(this.position[i][p] ==1){
                                        System.out.print(" + ");
                                }
                                else if(this.Items[i][p] != null){
                                        System.out.print("<$>");
                                }
                                else{
                                System.out.print(this.area[i][p]);
                                }
                        }//end of inner for print
                }//end of outter for print
	}

	public void printA(){
		for(int i = 0; i < this.area.length;i++){
                        System.out.println(" ");
                        System.out.print("                       ");
                        for(int p = 0 ; p < this.area.length; p++){
                                
                                if(this.Ari[i][p] ==1){
                                        System.out.print(" ? ");
                                }
                                else if(this.position[i][p] ==1){
                                        System.out.print(" + ");
                              	}
                                else if(this.Items[i][p] != null){
                                        System.out.print("<$>");
                                }
                                else{
                                System.out.print(this.area[i][p]);
                                }
                        }//end of inner for print
                }//end of outter for print
	}

	public void print(){
//		for(int i = 0; i< 40; i++){
//			System.out.println(" ");
//		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("                                         ~ ONE ROOM DUNGEON GAME ~");
//		for(int i = 0 ; i < this.area.length; i++){
//			for(int p = 0 ; p < this.area.length; p++){
//				if(this.Garret[i][p] == 1){
//					this.area[i][p] = ":( ";
//				}//end of garret
//				if(this.Ari[i][p]==1){
//					this.area[i][p] = " ? ";
//				}//end of ari
//				if(this.position[i][p]==1){
//					this.area[i][p] = " + ";
//				}//end of user
//				if(this.Items[i][p]!=null){
//					this.area[i][p] = "<$>";
//				}//end of item
//			}
//		}
//		for(int i = 0; i< 200;i++){
//			System.out.println(" ");
//		}
		for(int i = 0; i < this.area.length;i++){
			System.out.println(" ");
			System.out.print("                       ");
			for(int p = 0 ; p < this.area.length; p++){
				if(this.Garret[i][p] == 1){
					System.out.print(":( ");
				}
				else if(this.Ari[i][p] ==1){
					System.out.print(" ? ");
				}
				else if(this.position[i][p] ==1){
					System.out.print(" + ");
				}
				else if(this.Items[i][p] != null){
					System.out.print("<$>");
				}
				else{
				System.out.print(this.area[i][p]);
				}
			}//end of inner for print
		}//end of outter for print
		
	}//end of print

}//end of class Room
