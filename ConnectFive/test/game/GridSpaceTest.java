package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GridSpaceTest {

	GridSpace testGridSpace;
	Colour testColour;
	
	@BeforeEach
	void setUp() throws Exception {
		testGridSpace = new GridSpace();
		testColour = Colour.O;
	}

	/**
	 * 
	 */
	@Test
	void testDefaultConstructor() {
		assertNotNull(testGridSpace);
	}
	
	/**
	 * 
	 */
	@Test 
	void testConstructorWithArgs() {
		GridSpace testGridSpaceNew = new GridSpace(testColour);
		
		assertNotNull(testGridSpaceNew);
		assertEquals(testColour, testGridSpaceNew.getColour());
	}
	
	/**
	 * 
	 */
	@Test
	void testGetterSetterColour() {
		testGridSpace.setColour(testColour);
		
		assertEquals(testColour, testGridSpace.getColour());
	}

}
