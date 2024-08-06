/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: Student tests to test the features of the bevShop class. 
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmoothieTestStudent {
	private Smoothie smoothie;
	private Smoothie smoothieCopy;

	@BeforeEach
	public void setUp() {
		smoothie = new Smoothie("Tropical Delight", Size.LARGE, 3, true);
		smoothieCopy = new Smoothie(smoothie.getBevName(), smoothie.getSize(), smoothie.getNumOfFruits(), smoothie.getAddProtein()); // Copy constructor
	}

	@Test
	public void testConstructor() {
		assertEquals("Tropical Delight", smoothie.getBevName(), "The smoothie name should be 'Tropical Delight'.");
		assertEquals(Size.LARGE, smoothie.getSize(), "The size should be LARGE.");
		assertEquals(3, smoothie.getNumOfFruits(), "The number of fruits should be 3.");
		assertTrue(smoothie.getAddProtein(), "Protein should be added.");
	}

	@Test
	public void testCopyConstructor() {
		assertEquals(smoothie.getBevName(), smoothieCopy.getBevName(), "The copied smoothie name should be the same.");
		assertEquals(smoothie.getSize(), smoothieCopy.getSize(), "The copied smoothie size should be the same.");
		assertEquals(smoothie.getNumOfFruits(), smoothieCopy.getNumOfFruits(), "The copied number of fruits should be the same.");
		assertEquals(smoothie.getAddProtein(), smoothieCopy.getAddProtein(), "The copied protein addition flag should be the same.");
	}

	@Test
	public void testCalcPrice() {
		// Price calculation: Base price (size) + (3 fruits * 0.50) + (Protein cost 1.50)
		double expectedPrice = smoothie.addSizePrice() + (3 * 0.50) + 1.50;
		assertEquals(expectedPrice, smoothie.calcPrice(), 0.01, "The calculated price should match the expected value.");
	}

	@Test
	public void testToString() {
		String expected = "Smoothie Name: Tropical Delight\n" +
				"Size: LARGE\n" +
				"Number of Fruits: 3\n" +
				"Protein Added: Yes\n" +
				"Price: " + smoothie.calcPrice() + "\n";
		assertEquals(expected, smoothie.toString(), "The toString output should match the expected format.");
	}

	@Test
	public void testEquals() {
		// Test equality with itself
		assertTrue(smoothie.equals(smoothie), "A smoothie should be equal to itself.");

		// Test equality with a copy
		assertTrue(smoothie.equals(smoothieCopy), "A smoothie should be equal to its copy.");

		// Test equality with a different Smoothie
		Smoothie differentSmoothie = new Smoothie("Berry Blast", Size.MEDIUM, 2, false);
		assertFalse(smoothie.equals(differentSmoothie), "Smoothies with different properties should not be equal.");

		// Test equality with a null object
		assertFalse(smoothie.equals(null), "A smoothie should not be equal to null.");

		// Test equality with an object of a different class
		assertFalse(smoothie.equals("Not a Smoothie"), "A smoothie should not be equal to an object of a different class.");
	}


}
