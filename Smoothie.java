/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: The smoothie class extends the Beverage class and represents an alcoholic beverage with additional features. 
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/

public class Smoothie extends Beverage{
	private static final double PROTEIN_COST = 1.50;
	private static final double FRUIT_COST = 0.50;
	private int numOfFruits;
	private boolean addProtein;

	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size); 
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	public int getNumOfFruits() {
		return numOfFruits;
	}

	public boolean getAddProtein() {
		return addProtein;
	}
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		price += numOfFruits * FRUIT_COST;
		if (addProtein) {
			price += PROTEIN_COST;
		}
		return price;
	}
	@Override
	public String toString() {
		String str = "Smoothie Name: " + this.getBevName() + "\n";
		str += "Size: " + this.getSize() + "\n";
		str += "Number of Fruits: " + this.numOfFruits + "\n";
		str += "Protein Added: " + (this.addProtein ? "Yes" : "No") + "\n";
		str += "Price: " + this.calcPrice() + "\n";
		return str;
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev) return true;
		if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
		if (!super.equals(anotherBev)) return false;
		Smoothie smoothie = (Smoothie) anotherBev;
		return numOfFruits == smoothie.numOfFruits &&
				addProtein == smoothie.addProtein;
	}

}
