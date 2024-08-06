/*
* Class: CMSC203
* Instructor: Grigory Grinberg
* Description: The Alcohol class extends the Beverage class and represents an alcoholic beverage with additional features
* Due: 08/05/2024
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
Deliverables
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Isabel Saffell
*/
public class Alcohol extends Beverage{
	static final double WEEKEND_COST = 0.60;
    private boolean isWeekend;
    
    
    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size); 
        this.isWeekend = isWeekend;
    }
    public boolean isWeekend() {
        return isWeekend;
    }
   // public void setWeekend(boolean isWeekend) {
    //    this.isWeekend = isWeekend;
    //}
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (isWeekend) {
            price += WEEKEND_COST;
        }
        return price;
    }
    @Override
    public String toString() {
        String str = "Alcohol Name: " + this.getBevName() + "\n";
        str += "Size: " + this.getSize() + "\n";
        str += "Served on Weekends: " + this.isWeekend + "\n";
        str += "Price: " + this.calcPrice() + "\n";
        return str;
    }
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        if (!super.equals(anotherBev)) return false;
        Alcohol alcohol = (Alcohol) anotherBev;
        return isWeekend == alcohol.isWeekend;
    }
}
