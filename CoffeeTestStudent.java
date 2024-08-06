/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: Student tests to test the features of the coffee class. 
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
public class CoffeeTestStudent {




	private Coffee coffeeNoExtras;
	private Coffee coffeeWithExtraShot;
	private Coffee coffeeWithExtraSyrup;
	private Coffee coffeeWithBothExtras;

	@BeforeEach
	public void setUp() {
		coffeeNoExtras = new Coffee("Latte", Size.SMALL, false, false);
		coffeeWithExtraShot = new Coffee("Latte", Size.SMALL, true, false);
		coffeeWithExtraSyrup = new Coffee("Latte", Size.SMALL, false, true);
		coffeeWithBothExtras = new Coffee("Latte", Size.SMALL, true, true);
	}

	@Test
	public void testCalcPriceNoExtras() {
		assertEquals(3.0, coffeeNoExtras.calcPrice(), "Price should be 3.0 for a small coffee without extras.");
	}

	@Test
	public void testCalcPriceWithExtraShot() {
		assertEquals(3.5, coffeeWithExtraShot.calcPrice(), "Price should be 3.5 for a small coffee with an extra shot.");
	}

	@Test
	public void testCalcPriceWithExtraSyrup() {
		assertEquals(3.5, coffeeWithExtraSyrup.calcPrice(), "Price should be 3.5 for a small coffee with extra syrup.");
	}

	@Test
	public void testCalcPriceWithBothExtras() {
		assertEquals(4.0, coffeeWithBothExtras.calcPrice(), "Price should be 4.0 for a small coffee with both extras.");
	}

	@Test
	public void testToString() {
		String expected = "Coffee Name: Latte\n" +
				"Size: SMALL\n" +
				"Extra Shot: No\n" +
				"Extra Syrup: No\n" +
				"Price: 3.0\n";
		assertEquals(expected, coffeeNoExtras.toString(), "ToString output should match the expected format.");
	}

	@Test
	public void testToStringWithExtras() {
		String expected = "Coffee Name: Latte\n" +
				"Size: SMALL\n" +
				"Extra Shot: Yes\n" +
				"Extra Syrup: No\n" +
				"Price: 3.5\n";
		assertEquals(expected, coffeeWithExtraShot.toString(), "ToString output with extras should match the expected format.");
	}

	@Test
	public void testEquals() {
		Coffee anotherCoffeeWithBothExtras = new Coffee("Latte", Size.SMALL, true, true);
		assertTrue(coffeeWithBothExtras.equals(anotherCoffeeWithBothExtras), "Coffees with the same properties should be equal.");
	}

	@Test
	public void testNotEqualsDifferentExtras() {
		assertFalse(coffeeWithExtraShot.equals(coffeeWithExtraSyrup), "Coffees with different extras should not be equal.");
	}

	@Test
	public void testNotEqualsDifferentSize() {
		Coffee coffeeDifferentSize = new Coffee("Latte", Size.MEDIUM, true, true);
		assertFalse(coffeeWithBothExtras.equals(coffeeDifferentSize), "Coffees with different sizes should not be equal.");
	}

	@Test
	public void testNotEqualsNull() {
		assertFalse(coffeeWithBothExtras.equals(null), "Coffee should not be equal to null.");
	}

	@Test
	public void testNotEqualsDifferentClass() {
		assertFalse(coffeeWithBothExtras.equals("String"), "Coffee should not be equal to an object of a different class.");
	}

}
