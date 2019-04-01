package game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author 40233576
 *
 */
class GameGridTest {

	GameGrid testGameGrid;
	GridSpace testSpaceBlank, testSpaceX;
	GridSpace[][] testGridSpace2DArrayBlank, testGridSpace2DArray;
	int columns, rows, testColumn1, testColumn9;
	Colour testColour;
	
	@BeforeEach
	void setUp() throws Exception {
		testGameGrid = new GameGrid();
		testSpaceBlank = new GridSpace(Colour.BLANK);
		testColour = Colour.X;
		testSpaceX = new GridSpace(Colour.X);
		columns = 9;
		rows = 6;
		testColumn1 = 1;
		testColumn9 = 9;
		
		testGridSpace2DArrayBlank = new GridSpace[rows][columns];
		testGridSpace2DArray = new GridSpace[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				testGridSpace2DArrayBlank[i][j] = testSpaceBlank;
				testGridSpace2DArray[i][j] = testSpaceX;
			}
		}
		/**
		//fill the final column with Xs
		for(int i = 0; i < rows; i++) {
			testGridSpace2DArray[i][8] = testSpaceX;
		}
		//fill the bottom row with Xs
		for(int i = 4; i < columns; i++) {
			testGridSpace2DArray[0][i] = testSpaceX;
		}
		//fill the diagonal with Xs
		testGridSpace2DArray[1][5] = testSpaceX;
		testGridSpace2DArray[2][6] = testSpaceX;
		testGridSpace2DArray[3][7] = testSpaceX;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(testGridSpace2DArray[i][j] != testSpaceX) {
					testGridSpace2DArray[i][j] = testSpaceBlank;
				}
			}
		}
		**/
	}

	/**
	 * test the default constructor
	 */
	@Test
	void testDefaultConstructor() {
		assertNotNull(testGameGrid);
	}

	/**
	 * test that the constructor with args works as expected
	 */
	@Test
	void testConstructorWithArgs() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArrayBlank);
		
		assertNotNull(testGameGridNew);
		assertEquals(testGridSpace2DArrayBlank, testGameGridNew.getGridSystem());
	}
	
	/**
	 * 
	 */
	@Test
	void testGetterSetterGridSystem() {
		testGameGrid.setGridSystem(testGridSpace2DArrayBlank);
		
		assertEquals(testGridSpace2DArrayBlank, testGameGrid.getGridSystem());
	}
	
	/**
	 * test that the display all method prints the expected display
	 */
	@Test
	void testDisplayAllBlanks() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArrayBlank);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		testGameGridNew.displayAll();
		
		String expectedOutput = "[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n";
	
		assertEquals(expectedOutput, out.toString());
	}
	
	/**
	 * test that the display all method prints the expected display
	 */
	@Test
	void testDisplayAllXs() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		testGameGridNew.displayAll();
		
		String expectedOutput = "[X][X][X][X][X][X][X][X][X]\n[X][X][X][X][X][X][X][X][X]\n[X][X][X][X][X][X][X][X][X]\n[X][X][X][X][X][X][X][X][X]\n[X][X][X][X][X][X][X][X][X]\n[X][X][X][X][X][X][X][X][X]\n";
	
		assertEquals(expectedOutput, out.toString());
	}
	
	/**
	 * test that the fillSpace methods fills in new space in the grid as expected and returns true for valid choice
	 */
	@Test
	void testFillSpaceValid() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArrayBlank);
		
		assertTrue(testGameGridNew.fillSpace(testColumn1, testColour));
		assertEquals(testColour, testGameGridNew.getGridSystem()[0][0].getColour());
	}
	
	/**
	 * test that the fillSpace method recognises that the column selected is full, and so returns false for valid choice
 	 */
	@Test
	void testFillSpaceInvalid() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);
		assertFalse(testGameGridNew.fillSpace(testColumn9, testColour));
	}
	
	/**
	 * test that for the grid of blanks a winner is not declared by the horizontal check
	 */
	@Test
	void testHorizintalWinnerFalse() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArrayBlank);
		assertFalse(testGameGridNew.checkIfWinnerHorizontal());	
	}
	
	/**
	 * test that for the grid of blanks a winner is not declared by the horizontal check
	 */
	@Test
	void testVerticalWinnerFalse() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArrayBlank);
		assertFalse(testGameGridNew.checkIfWinnerVertical());	
	}
	
	/**
	 * test that for the grid of blanks a winner is not declared by the horizontal check
	 */
	@Test
	void testDiagonalWinnerFalse() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArrayBlank);
		assertFalse(testGameGridNew.checkIfWinnerDiagonal());	
	}
	
	/**
	 * test that for the grid with Xs a winner is declared by the horizontal check
	 */
	@Test
	void testHorizintalWinnerTrue() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);

		boolean check = testGameGridNew.checkIfWinnerHorizontal();
		assertEquals(true, check);
		assertNotNull(testGameGridNew);
	}
	
	/**
	 * test that for the grid with Xs a winner is declared by the horizontal check
	 */
	@Test
	void testVerticalWinnerTrue() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);
		assertTrue(testGameGridNew.checkIfWinnerVertical());	
	}
	
	/**
	 * test that for the grid with Xs a winner is declared by the horizontal check
	 */
	@Test
	void testDiagonalWinnerTrue() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);
		assertTrue(testGameGridNew.checkIfWinnerDiagonal());	
	}
}
