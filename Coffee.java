/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: The coffee class extends the Beverage class and represents an alcoholic beverage with additional features. 
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/

public class Coffee extends Beverage{
	private static final double EXTRA_SHOT_COST = 0.50;
	private static final double EXTRA_SYRUP_COST = 0.50;
	private final boolean extraShot;
	private final boolean extraSyrup;

	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}

	public boolean getExtraShot() {
		return extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if (extraShot) {
			price += EXTRA_SHOT_COST;
		}
		if (extraSyrup) {
			price += EXTRA_SYRUP_COST;
		}
		return price;
	}
	@Override
	public String toString() {
		String str = "Coffee Name: " + this.getBevName() + "\n";
		str += "Size: " + this.getSize() + "\n";
		str += "Extra Shot: " + (this.extraShot ? "Yes" : "No") + "\n";
		str += "Extra Syrup: " + (this.extraSyrup ? "Yes" : "No") + "\n";
		str += "Price: " + this.calcPrice() + "\n";
		return str;
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev) return true;
		if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
		if (!super.equals(anotherBev)) return false;
		Coffee coffee = (Coffee) anotherBev;
		return extraShot == coffee.extraShot &&
				extraSyrup == coffee.extraSyrup;
	}
}
