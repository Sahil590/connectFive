/**
 * 
 */
package game;

/**
 * The GridSpace class contains all information relating to the spaces in the game's grid
 * @author 40233576
 *
 */
public class GridSpace {

	//instance vars
	private Colour colour;
	
	/**
	 * default constructor
	 */
	public GridSpace() {
		
	}

	/**
	 * constructor with args
	 * @param colour
	 */
	public GridSpace(Colour colour) {
		this.colour = colour;
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
	
}
