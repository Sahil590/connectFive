package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Player testPlayer;
	Colour testColour;
	String testName;
	
	@BeforeEach
	void setUp() throws Exception {
		testPlayer = new Player();
		testColour = Colour.X;
		testName = "TestName";
	}

	/**
	 * 
	 */
	@Test
	void testPlayerDefaultConstructor() {
		assertNotNull(testPlayer);
	}
	
	/**
	 * 
	 */
	@Test
	void testPlayerConstructor() {
		Player testPlayerNew = new Player(testColour, testName);
		
		assertEquals(testColour, testPlayerNew.getColour());
		assertEquals(testName, testPlayerNew.getName());
	}
	
	/**
	 * 
	 */
	@Test
	void testGetterSetterColour() {
		testPlayer.setColour(testColour);
		
		assertEquals(testColour, testPlayer.getColour());
	}
	
	/**
	 * 
	 */
	@Test
	void testGetterSetterName() {
		testPlayer.setName(testName);
		
		assertEquals(testName, testPlayer.getName());
	}

}
