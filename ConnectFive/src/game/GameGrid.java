/**
 * 
 */
package game;

/**
 * The GameGrid class contains all the info necessary for the gameGrid. Contains the method for updating and 
 * checking the status of the grid
 * @author 40233576
 *
 */
public class GameGrid {

	//instance vars
	private GridSpace[][] gridSystem;
	
	/**
	 * default constructor
	 */
	public GameGrid() {
		
	}
	
	/**
	 * constructor with args
	 * @param gridSystem
	 */
	public GameGrid(GridSpace[][] gridSystem) {
		this.gridSystem = gridSystem;
	}

	/**
	 * 
	 * @return
	 */
	public GridSpace[][] getGridSystem() {
		return gridSystem;
	}

	/**
	 * 
	 * @param gridSystem
	 */
	public void setGridSystem(GridSpace[][] gridSystem) {
		this.gridSystem = gridSystem;
	}
	
	/**
	 * method to display the game grid
	 */
	public void displayAll() {
		//start from the top row of the grid
		for(int x =  this.gridSystem.length - 1; x >= 0; x--) {
			for(int y = 0; y < this.gridSystem[0].length; y++) {
				
				//when end of the row is reached, go to new line
				if(y == this.gridSystem[0].length - 1) {
					if(this.gridSystem[x][y].getColour().equals(Colour.BLANK)) {
						System.out.print("[-]\n");
					}
					else {
						System.out.print("[" + this.gridSystem[x][y].getColour().toString() + "]\n");
					}
					
				}
				else {
					if(this.gridSystem[x][y].getColour().equals(Colour.BLANK)) {
						System.out.print("[-]");
					}
					else {
						System.out.print("[" + this.gridSystem[x][y].getColour().toString() + "]");
					}	
				}
			}
		}
	}
	
	/**
	 * check if a player has won horizontally
	 * @return
	 */
	public boolean checkIfWinnerHorizontal() {
		boolean winner = false;
		//System.out.println("horizontal");
		
		Check: for(int y = 0; y < this.gridSystem.length; y++) {
			
					for(int x = 0; x < this.gridSystem[0].length - 5; x++) {
						
						//only do the check if the spaces aren't blank
						if(this.gridSystem[y][x].getColour() != Colour.BLANK) {
							//System.out.println("new check");
							Colour check = this.gridSystem[y][x].getColour();
							int win = 1;
							
							for(int k = x + 1; k <= x + 4; k++) {
								if(this.gridSystem[y][k].getColour() == check) {
									++win;
									//System.out.println(check.toString() + "; " + "[" + y + "]" + "[" + k + "]; " + win);
									if(win == 5) {
										winner = true;
										break Check;
									}
								}
							}
						}
					}
				}
					
		return winner;
	}
	
	/**
	 * check if a player has won diagonally
	 * @return
	 */
	public boolean checkIfWinnerDiagonal() {
		boolean winner = false;
		//System.out.println("diagonal");
		
		Check: for(int y = 0; y < this.gridSystem.length - 5; y++) {
			
			for(int x = 0; x < this.gridSystem[0].length - 5; x++) {
				
				if(this.gridSystem[y][x].getColour() != Colour.BLANK) {
					//System.out.println("new check");
					Colour check = this.gridSystem[y][x].getColour();
					int win = 1;
					int i = 1;
					
					for(int k = x + 1; k <= x + 4; k++) {
						if(this.gridSystem[y + i][k].getColour() == check) {
							win++;
							//System.out.println(check.toString() + "; " + "[" + (y + i) + "]" + "[" + k + "]; " + win);
							if(win == 5) {
								winner = true;
								break Check;
							}
						}
						i++;
					}
				}
			}
			
		}
		
		return winner;
	}
	
	/**
	 * check if a player has won vertically
	 * @return
	 */
	public boolean checkIfWinnerVertical() {
		boolean winner = false;
		//System.out.println("vertical");
		
		Check: for(int y = 0; y < this.gridSystem.length - 5; y++) {
			
					for(int x = 0; x < this.gridSystem[0].length - 1; x++) {
						
						//only do the check if the spaces aren't blank
						if(this.gridSystem[y][x].getColour() != Colour.BLANK) {
							//System.out.println("new check");
							Colour check = this.gridSystem[y][x].getColour();
							int win = 1;
							
							for(int k = y + 1; k <= y + 4; k++) {
								if(this.gridSystem[k][x].getColour() == check) {
									++win;
									//System.out.println(check.toString() + "; " + "[" + k + "]" + "[" + x + "]; " + win);
									if(win == 5) {
										winner = true;
										break Check;
									}
								}
							}
						}
					}
				}
					
		return winner;
	}
	
	/**
	 * fills in a space in the grid
	 * @param col
	 * @param c
	 */
	public boolean fillSpace(int col, Colour c) {
		boolean validChoice = true;
		if(this.gridSystem[gridSystem.length - 1][col - 1].getColour() == Colour.BLANK) {
			
			Fill: for(int i = 0; i < this.gridSystem.length; i++) {
					if(this.gridSystem[i][col - 1].getColour() == Colour.BLANK) {
						
						this.gridSystem[i][col - 1].setColour(c);
						break Fill;
						
					}
			}
		}
		else {
			System.out.println("This column is already full.");
			validChoice = false;
		}
		
		return validChoice;
	}
}
