/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: The beverage class is an abstract class that eclares base feature for beverages, extended by the alcohol, smoothie, and coffee classes.
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/

import java.util.Objects;
public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	private static final double BASE_PRICE = 2.0;
	private static final double SIZE_PRICE = 0.5;

	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	public String getBevName() {
		return bevName;
	}
	//public void setBevName(String bevName) {
	//   this.bevName = bevName;
	//}

	public Type getType() {
		return type;
	}
	//public void setType(Type type) {
	//   this.type = type;
	//}
	public Size getSize() {
		return size;
	}
	//public void setSize(Size size) {
	//   this.size = size;
	//}
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public double addSizePrice() {
		switch (size) {
		case MEDIUM:
			return BASE_PRICE + SIZE_PRICE;
		case LARGE:
			return BASE_PRICE + 2 * SIZE_PRICE;
		case SMALL:
		default:
			return BASE_PRICE;
		}
	}


	public abstract double calcPrice();


	@Override
	public String toString() {
		return String.format("%s,%s", bevName, size);
	}


	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev) return true;
		if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
		Beverage beverage = (Beverage) anotherBev;
		return bevName.equals(beverage.bevName) &&
				type == beverage.type &&
				size == beverage.size;
	}

}
