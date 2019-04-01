/**
 * 
 */
package game;

/**
 * The player class contains all information relating to the game's players.
 * @author 40233576
 *
 */
public class Player {

	//instance variables
	private Colour colour;
	private String name;
	
	/**
	 * default constructor
	 */
	public Player() {
		
	}
	
	/**
	 * constructor with args
	 * @param colour
	 * @param name
	 */
	public Player(Colour colour, String name) {
		this.colour = colour;
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public Colour getColour() {
		return colour;
	}
	
	/**
	 * 
	 * @param colour
	 */
	public void setColour(Colour colour) {
		this.colour = colour;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
}	
