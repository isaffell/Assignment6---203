/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: Stuent tests to test the features of the alcohol class that extends beverage with different pricing. 
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
import org.junit.jupiter.api.Test;

public class AlcoholTestStudent {

	@Test
	public void testGetBevName() {
		Alcohol beer = new Alcohol("Beer", Size.MEDIUM, true);
		assertEquals("Beer", beer.getBevName(), "Test 1 Failed");
	}

	@Test
	public void testGetSize() {
		Alcohol beer = new Alcohol("Beer", Size.MEDIUM, true);
		assertEquals(Size.MEDIUM, beer.getSize(), "Test 2 Failed");
	}

	@Test
	public void testCalcPriceWeekend() {
		Alcohol beerWeekend = new Alcohol("Beer", Size.MEDIUM, true);
		double sizePriceMedium = beerWeekend.addSizePrice(); // Ensure addSizePrice returns the correct size price
		double expectedPrice = sizePriceMedium + Alcohol.WEEKEND_COST;
		assertEquals(expectedPrice, beerWeekend.calcPrice(), "Test 3 Failed");
	}

	@Test
	public void testCalcPriceWeekday() {
		Alcohol beerWeekday = new Alcohol("Beer", Size.MEDIUM, false);
		double sizePriceMedium = beerWeekday.addSizePrice(); // Ensure addSizePrice returns the correct size price
		double expectedPrice = sizePriceMedium;
		assertEquals(expectedPrice, beerWeekday.calcPrice(), "Test 4 Failed");
	}

	@Test
	public void testToString() {
		Alcohol beerWeekend = new Alcohol("Beer", Size.MEDIUM, true);
		double sizePriceMedium = beerWeekend.addSizePrice(); // Ensure addSizePrice returns the correct size price
		double expectedPrice = sizePriceMedium + Alcohol.WEEKEND_COST;
		String expectedString = "Alcohol Name: Beer\nSize: MEDIUM\nServed on Weekends: true\nPrice: " + expectedPrice + "\n";
		assertEquals(expectedString, beerWeekend.toString(), "Test 5 Failed");
	}

	@Test
	public void testEquals() {
		Alcohol beerWeekend1 = new Alcohol("Beer", Size.MEDIUM, true);
		Alcohol beerWeekend2 = new Alcohol("Beer", Size.MEDIUM, true);
		Alcohol beerWeekday = new Alcohol("Beer", Size.MEDIUM, false);
		Alcohol differentSizeBeer = new Alcohol("Beer", Size.LARGE, true);
		Alcohol differentNameBeer = new Alcohol("Ale", Size.MEDIUM, true);

		assertEquals(beerWeekend1, beerWeekend2, "Test 6 Failed");
		assertNotEquals(beerWeekend1, beerWeekday, "Test 7 Failed");
		assertNotEquals(beerWeekend1, differentSizeBeer, "Test 8 Failed");
		assertNotEquals(beerWeekend1, differentNameBeer, "Test 9 Failed");
		assertNotEquals(beerWeekend1, null, "Test 10 Failed");
		assertNotEquals(beerWeekend1, new Object(), "Test 11 Failed");
	}
}
