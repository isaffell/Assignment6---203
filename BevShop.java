/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: represents a beverage shop that manages orders for various types of beverages. 
* It implements the BevShopInterface and provides functionality for orders,  sales, and  conditions.
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private ArrayList<Order> orders;
	private int currentOrderIndex;
	private static final int MAX_FRUIT = 5;
	private static final int MAX_ORDER_FOR_ALCOHOL = 3;
	private static final int MIN_AGE_FOR_ALCOHOL = 21;
	private static final int MIN_TIME = 8;
	private static final int MAX_TIME = 23;

	public BevShop() {
		this.orders = new ArrayList<>();
		this.currentOrderIndex = -1; // Indicates no current order
	}

	@Override
	public boolean isValidTime(int time) {
		return time >= MIN_TIME && time <= MAX_TIME;
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if (currentOrderIndex >= 0 && currentOrderIndex < orders.size()) {
			Order currentOrder = orders.get(currentOrderIndex);
			return currentOrder.findNumOfBeveType(Type.ALCOHOL) < MAX_ORDER_FOR_ALCOHOL;
		}
		return false;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		if (currentOrderIndex >= 0 && currentOrderIndex < orders.size()) {
			Order currentOrder = orders.get(currentOrderIndex);
			return currentOrder.findNumOfBeveType(Type.ALCOHOL);
		}
		return 0;
	}

	@Override
	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		if (isValidTime(time) && isValidAge(customerAge)) {
			Order newOrder = new Order(time, day, new Customer(customerName, customerAge));
			orders.add(newOrder);
			currentOrderIndex = orders.size() - 1; // Set the index to the new order
		} else {
			throw new IllegalArgumentException("Invalid time or age.");
		}
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		if (currentOrderIndex >= 0 && currentOrderIndex < orders.size()) {
			Order currentOrder = orders.get(currentOrderIndex);
			currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		} else {
			throw new IllegalStateException("No current order.");
		}
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		if (currentOrderIndex >= 0 && currentOrderIndex < orders.size()) {
			Order currentOrder = orders.get(currentOrderIndex);
			if (isEligibleForMore()) {
				currentOrder.addNewBeverage(bevName, size);
			} else {
				throw new IllegalStateException("Maximum number of alcohol beverages reached.");
			}
		} else {
			throw new IllegalStateException("No current order.");
		}
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		if (currentOrderIndex >= 0 && currentOrderIndex < orders.size()) {
			if (!isMaxFruit(numOfFruits)) {
				Order currentOrder = orders.get(currentOrderIndex);
				currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
			} else {
				throw new IllegalArgumentException("Exceeds maximum number of fruits allowed.");
			}
		} else {
			throw new IllegalStateException("No current order.");
		}
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		int index = findOrder(orderNo);
		if (index >= 0) {
			Order order = orders.get(index);
			return order.calcOrderTotal();
		}
		return 0.0;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;
		for (Order order : orders) {
			total += order.calcOrderTotal();
		}
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		if (currentOrderIndex >= 0 && currentOrderIndex < orders.size()) {
			return orders.get(currentOrderIndex);
		}
		return null;
	}

	@Override
	public Order getOrderAtIndex(int index) {
		if (index >= 0 && index < orders.size()) {
			return orders.get(index);
		}
		return null;
	}

	@Override
	public void sortOrders() {
		for (int i = 0; i < orders.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
					minIndex = j;
				}
			}
			// Swap the found minimum element with the first element
			Order temp = orders.get(minIndex);
			orders.set(minIndex, orders.get(i));
			orders.set(i, temp);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Total Monthly Sale: $").append(totalMonthlySale()).append("\n");
		sb.append("Orders:\n");
		for (Order order : orders) {
			sb.append(order.toString()).append("\n");
		}
		return sb.toString();
	}
}
