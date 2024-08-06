/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: The order class categorizes all the parts of customers order and implements the order interface. 
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
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{
	private int orderNo;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	private int totalFruits;

	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(cust); // Deep copy of Customer
		this.beverages = new ArrayList<>();
		this.orderNo = generateOrder(); // Generate order number
		this.totalFruits = 0;

	}
	private int generateOrder() {
		Random random = new Random();
		int randInt = random.nextInt((90_000 - 10_000) + 10_000);
		return randInt;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public Customer getCustomer() {
		return new Customer(customer); // Return a deep copy
	}
	public boolean isWeekend() {
		return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
	}

	public Beverage getBeverage(int itemNo) {
		if (itemNo >= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo); // Return a shallow copy
		}
		return null;
	}
	public void addNewBeverage(String bevName, Size size) {
		Beverage beverage = new Alcohol(bevName, size, false); // Default for isWeekend
		beverages.add(beverage);
	}

	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Beverage beverage = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(beverage);
	}

	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Beverage beverage = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(beverage);
	}
	@Override
	public double calcOrderTotal() {
		double total = 0;
		for (Beverage bev : beverages) {
			total += bev.calcPrice();
		}
		return total;
	}
	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for (Beverage bev : beverages) {
			if (bev.getType() == type) {
				count++;
			}
		}
		return count;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Order Number: ").append(orderNo).append("\n");
		str.append("Order Time: ").append(orderTime).append("\n");
		str.append("Order Day: ").append(orderDay).append("\n");
		str.append("Customer: ").append(customer.getName()).append(", Age: ").append(customer.getAge()).append("\n");
		str.append("Beverages:\n");
		for (Beverage bev : beverages) {
			str.append(bev.toString()).append("\n");
		}
		return str.toString();
	}

	@Override
	public int compareTo(Order anotherOrder) {
		return Integer.compare(this.orderNo, anotherOrder.orderNo);
	}

	public double getTotalPrice() {
		return calcOrderTotal();
	}

	public int getNumItems() {
		return beverages.size();
	}

	public int getTotalFruits() {
		return totalFruits;
	}

}
