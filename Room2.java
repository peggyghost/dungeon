import java.util.ArrayList;
import java.util.Random;

class Room2{

	private String[][] borders;
	private int[][] position;
	private int[][] demon;
	private int[][] dragon;
	private Item[][] items;
	private Random chance = new Random();
	private int[][] door;

	Room2(){
		this.borders = new String[20][20];
		this.position = new int[20][20];
		this.demon = new int[20][20];
		this.dragon = new int[20][20];
		this.items = new Item[20][20];
		this.door = new int[20][20];
	}

	public void board(){

		for(int i = 0; i< this.position.length; i++){
			for(int p =0; p < this.position.length; p++){
				this.position[i][p] = 0;
			}
		}
		this.position[18][18] = 1;

		for(int i =0; i <this.demon.length; i++){
			for(int p = 0; p < this.demon.length; p++){
				this.demon[i][p] = 0;
			}
		}
		this.demon[5][9] = 1;

		for(int i = 0; i <this.dragon.length; i++){
			for(int p =0; p < this.dragon.length; p++){
				this.dragon[i][p] = 0;
			}
		}
		this.dragon[9][5]= 1;

		 for(int i = 0; i <this.door.length; i++){
                        for(int p =0; p < this.door.length; p++){
                                this.door[i][p] = 0;
                        }
                }

		this.door[19][19] = 1;

		for(int i = 0; i < this.items.length; i++){
			for(int p = 0; p < this.items.length; p++){
				this.items[i][p] = null;
			}
		}


		for(int i = 0; i < this.borders.length; i++){
			for(int p =0; p<this.borders.length; p++){
				if(i==0){
					this.borders[i][p] = "__";
				}
				else if (p==0 || p==19){
					this.borders[i][p] = "__";
				}
				else if (i==19){
					this.borders[i][p] = "__";
				}
				else{
					this.borders[i][p] = "	";
				}
			}
		}
		 for(int i = 4; i< 5 ; i++){
                        for(int p = 4; p < 7; p++){
                                this.borders[i][p] = "[ }";
                        }
                }
                for(int i = 4; i< 5 ; i++){
                        for(int p = 4; p < 7; p++){
                                this.borders[p][i] = "[ ]";
                        }
                }
                for(int i = 7; i< 8 ; i++){
                         for(int p = 2; p < 7; p++){
                                this.borders[i][p] = "[ ]";
                        }
                }
                for(int i = 17; i< 18 ; i++){
                        for(int p = 13; p < 17; p++){
                                this.borders[i][p] = "[ ]";
                        }
                }
                for(int i = 14; i< 15 ; i++){
                        for(int p = 13; p < 17; p++){
                                this.borders[p][i] = "[ ]";
			}
		}
		 for(int i = 11; i< 12 ; i++){
                        for(int p = 10; p < 17; p++){
                                this.borders[i][p] = "[ ]";
                        }
                }
                for(int i = 15; i< 16 ; i++){
                        for(int p = 3; p < 6; p++){
                                this.borders[i][p] = "[ ]";
                        }
                }
                for(int i = 16; i< 17 ; i++){
                        for(int p = 6; p < 13; p++){
                                this.borders[p][i] = "[ ]";
                        }
                }
                for(int i = 12; i< 13 ; i++){
                        for(int p = 5; p < 10; p++){
                                this.borders[i][p] = "[ ]";
                        }
                        System.out.println("  ");
                }//end of for that creates walls

		int y = 0;
                int x = 0;
                for(int i = 0;i<10;i++){
                        Item thing = ItemGenerator.generate();//making an item
                        boolean there = false;
                        while(!good){//makes coordates until there is nothing in the way
                                y = chance.nextInt(20);//getting coordiantaes
                                x = chance.nextInt(20);
                                if(this.items[y][x]==null && this.borders[y][x] != "[ ]"){
                                        good = true;
                                }//end of if
                                else{
                                        there = false;
                                }
                        }//end of while
                        items[y][x] = thing;
                }//end of for that distributes items on board
        }//end of create

	}



