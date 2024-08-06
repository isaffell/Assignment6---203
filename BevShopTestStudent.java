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

public class BevShopTestStudent {
	private BevShop bevShop;

	@BeforeEach
	public void setUp() {
		bevShop = new BevShop();
	}

	@Test
	public void testIsValidTime() {
		assertTrue(bevShop.isValidTime(10), "Valid time should return true.");
		assertFalse(bevShop.isValidTime(7), "Invalid time should return false.");
		assertFalse(bevShop.isValidTime(24), "Invalid time should return false.");
	}

	@Test
	public void testGetMaxNumOfFruits() {
		assertEquals(5, bevShop.getMaxNumOfFruits(), "Max number of fruits should be 5.");
	}

	@Test
	public void testGetMinAgeForAlcohol() {
		assertEquals(21, bevShop.getMinAgeForAlcohol(), "Minimum age for alcohol should be 21.");
	}

	@Test
	public void testIsMaxFruit() {
		assertTrue(bevShop.isMaxFruit(6), "Should return true for more than maximum fruits.");
		assertFalse(bevShop.isMaxFruit(4), "Should return false for fruits within the limit.");
	}

	@Test
	public void testGetMaxOrderForAlcohol() {
		assertEquals(3, bevShop.getMaxOrderForAlcohol(), "Maximum number of alcohol drinks should be 3.");
	}

	@Test
	public void testIsEligibleForMore() {
		bevShop.startNewOrder(10, Day.MONDAY, "John", 22);
		bevShop.processAlcoholOrder("Beer", Size.SMALL);
		bevShop.processAlcoholOrder("Wine", Size.MEDIUM);
		assertTrue(bevShop.isEligibleForMore(), "Should be eligible for more alcohol.");
		bevShop.processAlcoholOrder("Whiskey", Size.LARGE);
		assertFalse(bevShop.isEligibleForMore(), "Should not be eligible for more alcohol after reaching the limit.");
	}

	@Test
	public void testGetNumOfAlcoholDrink() {
		bevShop.startNewOrder(10, Day.MONDAY, "John", 22);
		bevShop.processAlcoholOrder("Beer", Size.SMALL);
		bevShop.processAlcoholOrder("Wine", Size.MEDIUM);
		assertEquals(2, bevShop.getNumOfAlcoholDrink(), "Should return the correct number of alcohol drinks.");
	}

	@Test
	public void testIsValidAge() {
		assertTrue(bevShop.isValidAge(22), "Age should be valid for alcohol.");
		assertFalse(bevShop.isValidAge(20), "Age should be invalid for alcohol.");
	}

	@Test
	public void testStartNewOrder() {
		bevShop.startNewOrder(10, Day.MONDAY, "John", 22);
		Order currentOrder = bevShop.getCurrentOrder();
		assertNotNull(currentOrder, "Current order should not be null.");
		assertEquals("John", currentOrder.getCustomer().getName(), "Customer name should match.");
		assertEquals(10, currentOrder.getOrderTime(), "Order time should match.");
	}



	@Test
	public void testProcessAlcoholOrder() {
		bevShop.startNewOrder(10, Day.MONDAY, "John", 22);
		bevShop.processAlcoholOrder("Beer", Size.SMALL);
		Order currentOrder = bevShop.getCurrentOrder();
		assertEquals(1, currentOrder.getNumItems(), "Number of items in the order should be 1.");
		assertEquals(2.0, bevShop.totalOrderPrice(currentOrder.getOrderNo()), "Total price should match.");
	}



	@Test
	public void testFindOrder() {
		bevShop.startNewOrder(10, Day.MONDAY, "John", 22);
		int orderNo = bevShop.getCurrentOrder().getOrderNo();
		assertEquals(0, bevShop.findOrder(orderNo), "Order index should be 0.");
	}






}
