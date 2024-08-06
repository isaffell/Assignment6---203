/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: application is ]designed to interact with the BevShop class,
*  allowing users to manage beverage orders in a simulated beverage shop environment. 
*  The application provides a practical interface for testing the functionalities of the BevShop system.
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/
import java.util.Scanner;

public class BevShopDriverApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BevShop bevShop = new BevShop();

		double totalOrder1 = 0;
		double totalOrder2 = 0;
		double overallTotal = 0;
		int currentOrderNo = -1;

		// Start the first order
		System.out.println("The current order in process can have at most 3 alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is 21");
		System.out.println("Start please a new order:");

		// Input for the first order
		System.out.print("Would you please enter your name: ");
		String name = scanner.nextLine();
		System.out.print("Would you please enter your age: ");
		int age = scanner.nextInt();
		scanner.nextLine();  // Consume newline

		// Create new order
		try {
			bevShop.startNewOrder(12, Day.MONDAY, name, age); // Example time and day
			currentOrderNo = bevShop.getCurrentOrder().getOrderNo(); // Track current order number
			System.out.println("Your Total Order for now is " + bevShop.totalOrderPrice(currentOrderNo));
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid time or age. Please try again.");
			scanner.close();
			return;  // Exit if invalid
		}

		if (age >= 21) {
			System.out.println("Your age is above 20 and you are eligible to order alcohol");
			int alcoholCount = 0;

			while (alcoholCount < bevShop.getMaxOrderForAlcohol()) {
				System.out.print("Would you please add an alcohol drink (yes/no): ");
				String response = scanner.nextLine();
				if (response.equalsIgnoreCase("yes")) {
					if (bevShop.isEligibleForMore()) {
						alcoholCount++;
						System.out.println("Adding alcohol drink #" + alcoholCount);
						bevShop.processAlcoholOrder("Beer", Size.MEDIUM);  // Example beverage
						System.out.println("The current order of drinks is " + alcoholCount);
						System.out.println("The Total price on the Order is " + bevShop.totalOrderPrice(currentOrderNo));
						if (alcoholCount == bevShop.getMaxOrderForAlcohol()) {
							System.out.println("You have a maximum alcohol drinks for this order");
						}
					} else {
						System.out.println("Cannot add more alcoholic beverages.");
						break;
					}
				} else {
					break;
				}
			}
		} else {
			System.out.println("Your Age is not appropriate for alcohol drink!!");
		}

		// Coffee Order
		System.out.print("Would you please add a COFFEE to your order (yes/no): ");
		String coffeeResponse = scanner.nextLine();
		if (coffeeResponse.equalsIgnoreCase("yes")) {
			bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
			System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getNumItems());
			System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(currentOrderNo));
		}

		// Calculate and store the total for the first order
		totalOrder1 = bevShop.totalOrderPrice(currentOrderNo);
		overallTotal += totalOrder1;

		// Start a new order
		System.out.println("#------------------------------------#");
		System.out.println("Would you please start a new order");
		System.out.print("Would you please enter your name: ");
		name = scanner.nextLine();
		System.out.print("Would you please enter your age: ");
		age = scanner.nextInt();
		scanner.nextLine();  // Consume newline

		// Create new order
		try {
			bevShop.startNewOrder(12, Day.MONDAY, name, age); // Example time and day
			currentOrderNo = bevShop.getCurrentOrder().getOrderNo(); // Update current order number
			System.out.println("Your Total Order for now is " + bevShop.totalOrderPrice(currentOrderNo));
		} catch (IllegalArgumentException e) {
			System.out.println("You are not old enough for alcohol!");
			// Continue to prompt for smoothies even if age validation fails
		}

		// Initialize total for the second order
		double currentOrderTotal = 0;

		// Adding Smoothies
		System.out.print("Would you please add a SMOOTHIE to order (yes/no): ");
		String smoothieResponse = scanner.nextLine();
		if (smoothieResponse.equalsIgnoreCase("yes")) {
			bevShop.processSmoothieOrder("Fruit Smoothie", Size.LARGE, 3, true);
			currentOrderTotal = bevShop.totalOrderPrice(currentOrderNo);
			System.out.println("The Total Price on the Order: " + currentOrderTotal);
		}

		System.out.print("Would you please add another SMOOTHIE to order (yes/no): ");
		String secondSmoothieResponse = scanner.nextLine();
		if (secondSmoothieResponse.equalsIgnoreCase("yes")) {
			bevShop.processSmoothieOrder("Veg Smoothie", Size.MEDIUM, 2, false);
			currentOrderTotal = bevShop.totalOrderPrice(currentOrderNo);
			System.out.println("The Total Price on the Order: " + currentOrderTotal);
		}

		// Adding Coffee
		System.out.print("Would you please add a COFFEE to your order (yes/no): ");
		String coffeeSecondResponse = scanner.nextLine();
		if (coffeeSecondResponse.equalsIgnoreCase("yes")) {
			bevShop.processCoffeeOrder("Espresso", Size.MEDIUM, false, true);
			currentOrderTotal = bevShop.totalOrderPrice(currentOrderNo);
			System.out.println("The Total Price on the Order: " + currentOrderTotal);
		}

		// Check for Alcohol eligibility again
		System.out.print("Would you please add an alcohol drink (yes/no): ");
		String alcoholFinalResponse = scanner.nextLine();
		if (age >= 21) {
			if (!bevShop.isValidAge(age)) {
				System.out.println("Your Age is not appropriate for alcohol drink!!");
			}
		}
		System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getNumItems());
		System.out.println("The Total price on the Order: " + currentOrderTotal);

		// Print max fruits
		System.out.println("The total number of fruits is " + bevShop.getCurrentOrder().getTotalFruits());
		if (bevShop.isMaxFruit(bevShop.getCurrentOrder().getTotalFruits())) {
			System.out.println("You reached a Maximum number of fruits.");
		}

		// Calculate and store the total for the second order
		totalOrder2 = currentOrderTotal;
		overallTotal += totalOrder2;

		// Print totals
		System.out.println("Total price on the first Order: " + totalOrder1);
		System.out.println("Total price on the second Order: " + totalOrder2);
		System.out.println("Total amount for all Orders: " + overallTotal);

		scanner.close();
	}
}
