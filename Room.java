import java.util.ArrayList;
import java.util.Random;
class Room{

	private String[][] area;
	private int[][] position;
	private int[][] Garret;
	private int[][] Ari;
	private int[][] Door;
	private Item[][] Items;
	private int[][] Stairs;
	private Random fate = new Random();
	private boolean present;

	Room(int y, int x){
		this.area = new String[y][x];
		this.position = new int[y][x];
		this.Garret = new int[y][x];
		this.Ari = new int[y][x];
		this.Items = new Item[y][x];
		this.Door = new int[y][x];
		this.Stairs = new int[y][x];
	}//end of room constructor

	//this method is to check if the player is in the current room
	public boolean isHere(){
		for(int i = 0; i < this.position.length ; i++){//loop that iterates through the array to see 1
			for(int p = 0; p < this.position.length ; p++){
				if(this.position[i][p] == 1){
					return true;//if the position is 1 it sends a true
				}
			}
		}
		return false;//if not it's false
	}//end of is here method
	
	//this method is to teleport the player to the other room, where the other door is 
	public void teleportTo(int y, int x){
		this.position[y][x] = 1;
	}

	//this method is to make the position of the player in the past room gone
	public void ghost(){
		for(int i = 0; i < this.position.length ; i++){
			for(int p = 0; p < this.position.length ; p++){
				this.position[i][p] = 0;
			}
		}
	}//end of ghost method


	public void create(){
		//creating board to keep track of player postion with 1 or 0. 0 if not there 1 if they are there
		for(int i = 0; i <this.position.length; i++){
			for(int p = 0; p < this.position.length; p++){
				this.position[i][p] = 0;//filling with zero
			}
		}//end of position making board
		this.position[1][1] = 1;//putting player in this position

		//creating door in the rooms
		for(int i = 0; i <this.Door.length; i++){
			for(int p = 0; p < this.Door.length; p++){
				this.Door[i][p] = 0;//filling with zero
			}
		}//end of Door making board

		this.Door[9][13] = 1;

		//creating board to keep track of garret
//                for(int i = 0; i <this.Garret.length; i++){
  //                      for(int p = 0; p < this.Garret.length; p++){
    //                            this.Garret[i][p] = 0;//filling with zero
      //                  }
        //        }//end of garret board
          //      this.Garret[18][10] = 1;//putts garret there
//
//		//creating board to keep track of garret
  //              for(int i = 0; i <this.Ari.length; i++){
    //                    for(int p = 0; p < this.Ari.length; p++){
      //                          this.Ari[i][p] = 0;//filling with zero
        //                }
          //      }//end of garret board
            //    this.Ari[5][13] = 1;//putts ari there


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



	public void create2(){
		//creating board to keep track of player postion with 1 or 0. 0 if not there 1 if they are there
		for(int i = 0; i <this.position.length; i++){
			for(int p = 0; p < this.position.length; p++){
				this.position[i][p] = 0;//filling with zero
			}
		}//end of position making board
		this.position[1][2] = 1;//putting player in this position

		//creating door in the rooms
                for(int i = 0; i <this.Door.length; i++){
                        for(int p = 0; p < this.Door.length; p++){
                                this.Door[i][p] = 0;//filling with zero
                        }
                }//end of Door making board
                this.Door[1][1] = 1;

		//creating stairs to transport to room3
		for(int i = 0; i <this.Stairs.length; i++){
                        for(int p = 0; p < this.Stairs.length; p++){
                                this.Stairs[i][p] = 0;//filling with zero
                        }
                }//end of Door making board
                this.Stairs[18][18] = 1;

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
		for(int i = 3; i< 4 ; i++){
			for(int p = 1; p < 18; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 6; i< 7 ; i++){
			for(int p = 19; p > 1; p--){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 9; i< 10 ; i++){
			for(int p = 1; p < 18; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 12; i< 13 ; i++){
			for(int p = 19; p > 1; p--){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 15; i< 16 ; i++){
			for(int p = 1; p < 18; p++){
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




	public void create3(){
		//creating board to keep track of player postion with 1 or 0. 0 if not there 1 if they are there
		for(int i = 0; i <this.position.length; i++){
			for(int p = 0; p < this.position.length; p++){
				this.position[i][p] = 0;//filling with zero
			}
		}//end of position making board
		this.position[1][1] = 1;//putting player in this position

		//creating stairs to connect rooms
		for(int i = 0; i <this.Stairs.length; i++){
                        for(int p = 0; p < this.Stairs.length; p++){
                                this.Stairs[i][p] = 0;//filling with zero
                        }
		}
                this.Stairs[1][1] = 1;

		//creating board to keep track of garret
		for(int i = 0; i <this.Garret.length; i++){
			for(int p = 0; p < this.Garret.length; p++){
				this.Garret[i][p] = 0;//filling with zero
			}
		}//end of garret board
		this.Garret[18][10] = 1;//putts garret there

		//creating board to keep track of ari
//		for(int i = 0; i <this.Ari.length; i++){
//			for(int p = 0; p < this.Ari.length; p++){
//				this.Ari[i][p] = 0;//filling with zero
//			}
//		}
//		this.Ari[7][11] = 1;//putts ari there

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
		for(int i = 1; i< 6 ; i++){
			for(int p = 7; p < 8; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 6; i< 7 ; i++){
			for(int p = 7; p > 4; p--){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 6; i< 11 ; i++){
			for(int p = 4; p < 5; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 10; i< 11 ; i++){
			for(int p = 5; p < 8; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 11; i< 15 ; i++){
			for(int p = 7; p < 8; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 15; i< 16 ; i++){
			for(int p = 7; p > 3; p--){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 13; i< 14 ; i++){
			for(int p = 1; p < 4; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 4; i< 5 ; i++){
			for(int p = 12; p < 17; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 5; i< 9 ; i++){
			for(int p = 12; p < 13; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 13; i< 14 ; i++){
			for(int p = 7; p < 12; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 13; i< 16 ; i++){
			for(int p = 12; p < 13; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 16; i< 19 ; i++){
			for(int p = 10; p < 11; p++){
				this.area[i][p] = "[ ]";
			}
		}
		for(int i = 9; i< 10 ; i++){
			for(int p = 12; p < 19; p++){
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

	private int count =0;//holds variable that has list placment to make garret walk in pattern
	public void enemymoveGarret(){
		int YEG = 0;
		int XEG = 0;
		int[] turns = new int[]{0,0,0,0,0,2,1,1,1,1,1,3};//dependign on the placement garret will move a certain way
		for(int i = 0 ; i < this.Garret.length;i++){//this grabs garrets current locations
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
				}
			}
		}
		switch(input){//first block is up and down second block is left and right
			case "a":
				if(this.area[YM][XM-1] != "[ ]"){
					this.position[YM][XM-1] = 1;//to turn left
					this.position[YM][XM] = 0;
				}
				break;
			case "d":
				if(this.area[YM][XM+1] != "[ ]"){
					this.position[YM][XM+1] = 1;//to turn right
					this.position[YM][XM] = 0;
				}
				break;
			case "w":
				if(this.area[YM-1][XM] != "[ ]"){
					this.position[YM-1][XM] = 1;//to turn up
					this.position[YM][XM] = 0;
				}
				break;
			case "s":
				if(this.area[YM+1][XM] != "[ ]"){
					this.position[YM+1][XM] = 1;//to turn down
					this.position[YM][XM] = 0; 
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
				else if(this.Door[i][p] ==1){
					System.out.print(" D ");
				}
				else if(this.Stairs[i][p] ==1){
                                        System.out.print(" S ");
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
				else if(this.Door[i][p] ==1){
                                        System.out.print(" D ");
                                }
				else if(this.Stairs[i][p] ==1){
                                        System.out.print(" S ");
                                }
				else{
					System.out.print(this.area[i][p]);
				}
			}//end of inner for print
		}//end of outter for print
	}

	public void print(){
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("                                         ~ ONE ROOM DUNGEON GAME ~ ");
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
				else if(this.Door[i][p] ==1){
                                        System.out.print(" D ");
                                }
				else if(this.Stairs[i][p] ==1){
                                        System.out.print(" S ");
                                }
				else{
					System.out.print(this.area[i][p]);
				}
			}//end of inner for print
		}//end of outter for print

	}//end of print

}//end of class Room
