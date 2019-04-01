/**
 * 
 */
package game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * main game play takes place in the main method of this class.
 * Other classes and declared and instantiated from here.
 * @author 40233576
 *
 */
public class GamePlay {

	//static vars - can be changed to expand game size
	public static int GRID_COLUMNS = 9;
	public static int GRID_ROWS = 6;
	public static int NUMBER_OF_PLAYERS = 2;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//declare and instantiate the winner var to false - when set to true the game is over
		boolean winner = false;
		
		//create multi-dim array
		GridSpace[][] gridSpace = new GridSpace[GRID_ROWS][GRID_COLUMNS];
		
		//populate the array
		for(int i = 0; i < GRID_ROWS; i++) {
			for(int j = 0; j < GRID_COLUMNS; j++){
				gridSpace[i][j] = new GridSpace(Colour.BLANK);
			}
		}
		
		//create new instance of the gamegrid
		GameGrid grid = new GameGrid(gridSpace);
		
		//view the grid
		grid.displayAll();
		
		//create players
		Player[] gamePlayers = createPlayers();
		
		//while loop - while there is no wonner take turns
		//for loop - through players and take turns
		String currentPlayer = "";
		while(winner == false) {
			for(int k = 0; k < gamePlayers.length; k++) {
			
				//view the grid
				grid.displayAll();
				
				//take turn, and continue only once a non-full column is chosen by the player
				boolean validTurn = false;
				while(validTurn == false) {
					validTurn = grid.fillSpace(takeTurn(gamePlayers[k], grid), gamePlayers[k].getColour());
				}
				
				//check if winner - must check horizontals, verticals, and diagonals
				winner = grid.checkIfWinnerHorizontal();
				if(winner == false) {
					winner = grid.checkIfWinnerDiagonal();
					if(winner == false) {
						winner = grid.checkIfWinnerVertical();
					}
				}
				
				//get current player's name in case they have won
				currentPlayer = gamePlayers[k].getName();
				
				//if winner variable has been updated then break the loop
				if(winner == true) {
					break;
				}
			}
		}
		
		//once the while loop breaks call the declare winner method, and display the board in its final format
		grid.displayAll();
		declareWinner(currentPlayer);
		
	}
	
	/**
	 * method to get the players' names
	 * @param playerNum
	 * @return
	 */
	public static Player getPlayers(int playerNum) {
		Player player = new Player();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello Player " + playerNum + ", what is your name?");
		String playerName = scanner.nextLine();
		
		if(playerNum == 1) {
			player.setColour(Colour.X);
		}
		else {
			player.setColour(Colour.O);
		}
		
		player.setName(playerName);
		return player;
	}
	
	/**
	 * creates the players' array for the game
	 * @return
	 */
	public static Player[] createPlayers() {
		Player[] players = new Player[NUMBER_OF_PLAYERS];
	
		for(int i = 0; i < NUMBER_OF_PLAYERS; i++) {
			Player player = getPlayers(i + 1);
			players[i] = player;
		} 
		
		return players;
	}
	
	/**
	 * prompt player for a column choice
	 * @param p
	 * @param g
	 * @return
	 */
	public static int takeTurn(Player p, GameGrid g) {
		int answer = 0;

		while(answer == 0) {
			int input;
			Scanner scanner = new Scanner(System.in);
			System.out.println(p.getName() + ", please select a column (1 - 9)");
			
			try {
				input = scanner.nextInt();
				
				if(input >= 1 && input <= 9) {
					answer = input;
				}
				else {
					System.err.println("Please enter a number between 1 and 9");
				}
			}
			catch(InputMismatchException e) {
				System.err.println("Please enter a number between 1 and 9");
			}
		}
		
		return answer;
	}
	
	/**
	 * declare the game's winner
	 * @param name
	 */
	public static void declareWinner(String name) {
		System.out.println("Congratulations " + name + ", you have won the game!!");
	}
	
}
