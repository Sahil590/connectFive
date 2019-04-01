package game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameGridTest {

	GameGrid testGameGrid;
	GridSpace testSpaceBlank, testSpaceX;
	GridSpace[][] testGridSpace2DArray;
	int columns, rows, testColumn1, testColumn9;
	Colour testColour;
	
	@BeforeEach
	void setUp() throws Exception {
		testGameGrid = new GameGrid();
		testSpaceBlank = new GridSpace(Colour.BLANK);
		testSpaceX = new GridSpace(testColour);
		columns = 9;
		rows = 6;
		testColour = Colour.X;
		testColumn1 = 1;
		testColumn9 = 9;
		
		testGridSpace2DArray = new GridSpace[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				testGridSpace2DArray[i][j] = testSpaceBlank;
			}
		}
		
		//fill the final column with Xs
		for(int i = 0; i < rows; i++) {
			testGridSpace2DArray[i][8] = testSpaceX;
		}
	}

	/**
	 * 
	 */
	@Test
	void testDefaultConstructor() {
		assertNotNull(testGameGrid);
	}

	/**
	 * 
	 */
	@Test
	void testConstructorWithArgs() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);
		
		assertNotNull(testGameGridNew);
		assertEquals(testGridSpace2DArray, testGameGridNew.getGridSystem());
	}
	
	/**
	 * 
	 */
	@Test
	void testGetterSetterGridSystem() {
		testGameGrid.setGridSystem(testGridSpace2DArray);
		
		assertEquals(testGridSpace2DArray, testGameGrid.getGridSystem());
	}
	
	/**
	 * 
	 */
	@Test
	void testDisplayAll() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		testGameGridNew.displayAll();
		
		String expectedOutput = "[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n[-][-][-][-][-][-][-][-][-]\n[X][X][X][X][X][X][X][X][X]\n";
	
		assertEquals(expectedOutput, out.toString());
	}
	
	/**
	 * 
	 */
	@Test
	void testFillSpaceValid() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);
		
		assertTrue(testGameGridNew.fillSpace(testColumn1, testColour));
		assertEquals(testColour, testGameGridNew.getGridSystem()[0][0].getColour());
	}
	
	/**
	 * 
	 */
	@Test
	void testFillSpaceInvalid() {
		GameGrid testGameGridNew = new GameGrid(testGridSpace2DArray);
		assertFalse(testGameGridNew.fillSpace(testColumn9, testColour));
	}
}
